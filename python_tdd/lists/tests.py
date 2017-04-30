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
        request = HttpRequest()
        request.method = 'POST'
        request.POST['item_next'] = '신규 작업 아이템'

        # exercise
        response = index(request)

        # assert
        # self.assertIn('신규 작업 아이템', response.content.decode())
        expected_html = render_to_string(
            'lists/index.html',
            {'new_item_text': '신규 작업 아이템'},
        )
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
