from django.test import TestCase
from django.core.urlresolvers import resolve
from django.template.loader import render_to_string
from django.http import HttpRequest

from lists.views import index
from lists.models import Item


class IndexPageTest(TestCase):
    def test_root_url_resolves_to_index_view(self):
        found = resolve('/')
        self.assertEqual(found.func, index)

    def test_index_page_returns_correct_html(self):
        response = index(HttpRequest())

        # 상수가 아닌 템플릿을 사용한 테스트
        expected_html = render_to_string('lists/index.html')
    
        self.assertEqual(response.content.decode(), expected_html)


class ItemModelTest(TestCase):
    def test_saving_and_retrieving_items(self):
        first_item = Item()
        first_item.text = '첫 번째 아이템'
        first_item.save()

        second_item = Item()
        second_item.text = '두 번째 아이템'
        second_item.save()

        saved_items = Item.objects.all()
        self.assertEqual(saved_items.count(), 2)

        first_saved_item = saved_items[0]
        second_saved_item = saved_items[1]
        self.assertEqual(first_saved_item.text, '첫 번째 아이템')
        self.assertEqual(second_saved_item.text, '두 번째 아이템')


class ListViewTest(TestCase):
    def test_uses_list_template(self):
        response = self.client.get('/lists/the-only-one/')
        self.assertTemplateUsed(response, 'lists/list.html')

    def test_index_page_displays_all_list_items(self):
        Item.objects.create(text='itemey 1')
        Item.objects.create(text='itemey 2')

        response = self.client.get('/lists/the-only-one/')

        # assertIn/response.content.decode() 를 대신함
        self.assertContains(response, 'itemey 1')
        self.assertContains(response, 'itemey 2')


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

        self.assertRedirects(response, '/lists/the-only-one/')
