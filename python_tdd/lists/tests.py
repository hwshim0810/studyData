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

        # 상수가 아닌 템플릿을 이용한 테스트로 변경
        expected_html = render_to_string('lists/index.html')
        self.assertEqual(response.content.decode(), expected_html)
