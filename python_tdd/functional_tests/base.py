from selenium import webdriver
from django.contrib.staticfiles.testing import StaticLiveServerTestCase

import sys


# 상속을 통한 Test class 생성
class FunctionalTest(StaticLiveServerTestCase):
    @classmethod
    def setUpClass(cls):
        for arg in sys.argv:
            if 'liveserver' in arg:
                cls.server_url = 'http://' + arg.split('=')[1]
                return
        super().setUpClass()
        cls.server_url = cls.live_server_url

    @classmethod
    def tearDownClass(cls):
        if cls.server_url == cls.live_server_url:
            super().tearDownClass()

    # Test 전 호출
    def setUp(self):
        self.browser = webdriver.Firefox()
        # 대기 후 처리
        self.browser.implicitly_wait(2)

    # Test 후 호출 : 예외시에도 실행
    def tearDown(self):
        self.browser.refresh()
        self.browser.quit()

    def check_for_row_in_list_table(self, row_text):
        table = self.browser.find_element_by_id('id_list_table')
        rows = table.find_elements_by_tag_name('tr')
        self.assertIn(row_text, [row.text for row in rows])

# LiveServerTestCase 의 이용으로 test 명령어로 시작 가능

# # import 가 아닌 Cmd 를 통함 unittest.main() 호출(Test Class 와 Method 를 찾아 실행)
# if __name__ == '__main__':
#     # 불필요한 리소스 경고 제거
#     unittest.main(warnings='ignore')

