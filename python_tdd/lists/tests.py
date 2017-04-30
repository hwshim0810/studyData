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

    def test_index_page_can_save_a_POST_request(self):
        # 단위 테스트의 구성
        # setup
        req = HttpRequest()
        req.method = 'POST'
        req.POST['task'] = '신규 작업 아이템'

        # exercise
        response = index(req)

        # assert
        # objects.all().count() 의 축약, 저장된 것을 확인
        self.assertEqual(Item.objects.count(), 1)
        new_item = Item.objects.first()
        self.assertEqual(new_item.text, '신규 작업 아이템')

    def test_index_page_redirects_after_POST(self):
        req = HttpRequest()
        req.method = 'POST'
        req.POST['task'] = '신규 작업 아이템'

        response = index(req)

        self.assertEqual(response.status_code, 302)
        self.assertEqual(response['location'], '/')

    def test_index_page_only_saves_item_when_necessary(self):
        index(HttpRequest())
        self.assertEqual(Item.objects.count(), 0)

    def test_index_page_displays_all_list_items(self):
        Item.objects.create(text='itemey 1')
        Item.objects.create(text='itemey 2')

        response = index(HttpRequest())

        self.assertIn('itemey 1', response.content.decode())
        self.assertIn('itemey 2', response.content.decode())


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
