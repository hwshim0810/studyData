from django.test import TestCase
from django.core.urlresolvers import resolve
from django.template.loader import render_to_string
from django.http import HttpRequest

from lists.views import index


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
