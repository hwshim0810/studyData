from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from .base import FunctionalTest


class NewVisitorTest(FunctionalTest):
    # test~로 명명한 test Method
    def test_can_start_a_list(self):
        self.browser.get(self.server_url)

        # 웹 페이지 타이틀과 헤더가 'To-Do'를 표시
        self.assertIn('To-Do lists', self.browser.title)
        header_text = self.browser.find_element_by_tag_name('h1').text
        self.assertIn('작업 목록 시작', header_text)

        # 작업을 추가
        input_box = self.browser.find_element_by_id('id_new_item')
        self.assertEqual(
            input_box.get_attribute('placeholder'),
            '작업 입력'
        )

        # "공구 사기"라고 텍스트박스에 입력
        input_box.send_keys('공구 사기')

        # Enter key 입력 시 페이지 갱신 및 새로운 URL로 변경
        # 작업목록에 '1: 공구 사기' 추가됨
        input_box.send_keys(Keys.ENTER)
        user_list_url = self.browser.current_url
        # REST 설계의 구현을 확인하기 위함
        self.assertRegex(user_list_url, '/lists/.+')
        self.check_for_row_in_list_table('1: 공구 사기')

        # 추가 입력 텍스트박스가 존재
        # 다시 추가작업 입력 '공구를 이용하여 조립'
        input_box = self.browser.find_element_by_id('id_new_item')
        input_box.send_keys('공구를 이용하여 조립')
        input_box.send_keys(Keys.ENTER)

        # 페이지 재 갱신후, 두개의 작업 출력
        self.check_for_row_in_list_table('2: 공구를 이용하여 조립')
        self.check_for_row_in_list_table('1: 공구 사기')

        '''
        # 다른 사용자의 접속
        '''
        # 새로운 세션을 이용하여 전 사용자의 정보가
        # 쿠키를 통해 유입되는 것을 방지
        self.browser.quit()
        self.browser = webdriver.Chrome()

        # 새로운 사용자의 접속, 전 사용자의 정보는 보이지 않음
        self.browser.get(self.server_url)
        page_text = self.browser.find_element_by_tag_name('body').text
        self.assertNotIn('공구 사기', page_text)
        self.assertNotIn('공구를 이용하여 조립', page_text)

        # 새로운 사용자가 새로운 작업을 입력
        input_box = self.browser.find_element_by_id('id_new_item')
        input_box.send_keys('물통 구입')
        input_box.send_keys(Keys.ENTER)

        # 새로운 사용자 전용 URL 취득
        other_user_list_url = self.browser.current_url
        self.assertRegex(other_user_list_url, '/lists/.+')
        self.assertNotEqual(other_user_list_url, user_list_url)

        # 전 사용자의 입력흔적 확인
        page_text = self.browser.find_element_by_tag_name('body').text
        self.assertNotIn('공구 사기', page_text)
        self.assertIn('물통 구입', page_text)

        # 강제로 Test 실패 발생
        self.fail('Finish the test')

        # Test-story 에 맞추어 작성
        # ...