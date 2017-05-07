from django.test import TestCase
from django.core.urlresolvers import resolve
from django.template.loader import render_to_string
from django.http import HttpRequest

from lists.views import index
from lists.models import Item, List


class IndexPageTest(TestCase):
    def test_root_url_resolves_to_index_view(self):
        found = resolve('/')
        self.assertEqual(found.func, index)

    def test_index_page_returns_correct_html(self):
        response = index(HttpRequest())

        # 상수가 아닌 템플릿을 사용한 테스트
        expected_html = render_to_string('lists/index.html')
    
        self.assertEqual(response.content.decode(), expected_html)


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
        self.assertTemplateUsed(res, 'lists/list.html')
        expected_err = "빈 아이템 리스트를 기질 수 없다"
        self.assertContains(res, expected_err)


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
        expected_err = "빈 아이템 리스트를 기질 수 없다"
        self.assertContains(res, expected_err)

    def test_invalid_list_items_arent_saved(self):
        self.client.post('/lists/new', data={'task': ''})
        self.assertEqual(List.objects.count(), 0)
        self.assertEqual(Item.objects.count(), 0)
