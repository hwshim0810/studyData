from django.test import TestCase

from lists.models import Item, List
from lists.forms import ItemForm, EMPTY_LIST_ERROR


class IndexPageTest(TestCase):
    # def test_root_url_resolves_to_index_view(self):
    #     found = resolve('/')
    #     self.assertEqual(found.func, index)

    def test_index_page_renders_index_template(self):
        response = self.client.get('/')
        self.assertTemplateUsed(response, 'lists/index.html')

    def test_index_page_uses_item_form(self):
        response = self.client.get('/')
        self.assertIsInstance(response.content['form'], ItemForm)


class ListViewTest(TestCase):
    def test_uses_list_template(self):
        list_ = List.objects.create()
        response = self.client.get('/lists/%d/' % (list_.id, ))
        self.assertTemplateUsed(response, 'lists/list.html')

    def test_displays_only_items_for_that_list(self):
        correct_list = List.objects.create()
        Item.objects.create(text='itemey 1', list=correct_list)
        Item.objects.create(text='itemey 2', list=correct_list)

        other_list = List.objects.create()
        Item.objects.create(text='다른 아이템1', list=other_list)
        Item.objects.create(text='다른 아이템2', list=other_list)

        response = self.client.get('/lists/%d/' % (correct_list.id, ))

        # assertIn/response.content.decode() 를 대신함
        self.assertContains(response, 'itemey 1')
        self.assertContains(response, 'itemey 2')
        self.assertNotContains(response, '다른 아이템1')
        self.assertNotContains(response, '다른 아이템2')

    def test_can_save_a_POST_request_to_an_existing_list(self):
        other_list = List.objects.create()
        correct_list = List.objects.create()

        self.client.post(
            '/lists/%d/' % (correct_list.id,),
            data={'task': '기존 리스트에 새로운 아이템'}
        )

        self.assertEqual(Item.objects.count(), 1)
        new_item = Item.objects.first()
        self.assertEqual(new_item.text, '기존 리스트에 새로운 아이템')
        self.assertEqual(new_item.list, correct_list)

    def test_POST_redirects_to_list_view(self):
        other_list = List.objects.create()
        correct_list = List.objects.create()

        response = self.client.post(
            '/lists/%d/' % (correct_list.id,),
            data={'task': '기존 리스트에 새로운 아이템'}
        )

        self.assertRedirects(response, '/lists/%d/' % (correct_list.id, ))

    def test_passes_correct_list_to_template(self):
        other_list = List.objects.create()
        correct_list = List.objects.create()

        response = self.client.get(
            '/lists/%d/' % (correct_list.id,)
        )

        self.assertEqual(response.context['list'], correct_list)

    def test_validation_errors_end_up_on_lists_page(self):
        list_ = List.objects.create()
        res = self.client.post(
            '/lists/%d/' % (list_.id,),
            data={'task': ''}
        )
        self.assertEqual(res.status_code, 200)
        self.assertTemplateUsed(res, 'lists/index.html')
        expected_err = "빈 아이템 리스트를 기질 수 없다"
        self.assertContains(res, expected_err)

    def test_displays_item_form(self):
        list_ = List.objects.create()
        res = self.client.get('/lists/%d' % (list_.id,))
        self.assertIsInstance(res.content['form'], ItemForm)
        self.assertContains(res, 'name="task"')

    def post_invalid_input(self):
        list_ = List.objects.create()
        return self.client.post(
            '/lists/%d/' % (list_.id,),
            data={'task': ''}
        )

    def test_for_invalid_input_noting_saved_to_db(self):
        self.post_invalid_input()
        self.assertEqual(Item.objects.count(), 0)

    def test_for_invalid_input_renders_lists_template(self):
        res = self.post_invalid_input()
        self.assertTemplateUsed(res, 'lists/list.html')

    def test_for_invalid_input_passes_form_to_template(self):
        res = self.post_invalid_input()
        self.assertIsInstance(res.context['form'], ItemForm)

    def test_for_invalid_input_shows_error_on_page(self):
        res = self.post_invalid_input()
        self.assertContains(res, EMPTY_LIST_ERROR)


class NewListTest(TestCase):
    def test_saving_a_POST_request(self):
        # setup
        # 꼬리 '/'를 사용하지 않는 경우는 DB에 변경을 가하는 액션 URL 인 경우
        self.client.post(
            '/lists/new',
            data={'task': '신규 작업 아이템'}
        )

        # assert
        # objects.all().count() 의 축약, 저장된 것을 확인
        self.assertEqual(Item.objects.count(), 1)
        new_item = Item.objects.first()
        self.assertEqual(new_item.text, '신규 작업 아이템')

    def test_redirects_after_POST(self):
        response = self.client.post(
            '/lists/new',
            data={'task': '신규 작업 아이템'}
        )
        new_list = List.objects.first()
        self.assertRedirects(response, '/lists/%d/' % (new_list.id,))

    def test_validation_errors_are_sent_back_to_home_template(self):
        res = self.client.post('/lists/new', data={'task': ''})
        self.assertEqual(res.status_code, 200)
        self.assertTemplateUsed(res, 'lists/index.html')

    def test_invalid_list_items_arent_saved(self):
        self.client.post('/lists/new', data={'task': ''})
        self.assertEqual(List.objects.count(), 0)
        self.assertEqual(Item.objects.count(), 0)

    # def test_validation_errors_are_shown_on_index_page(self):
    #     res = self.client.post('/lists/new', data={'text': ''})
    #     self.assertContains(res, EMPTY_LIST_ERROR)

    def test_for_invalid_input_passes_form_to_template(self):
        res = self.client.post('/lists/new', data={'text': ''})
        self.assertIsInstance(res.content['form'], ItemForm)
