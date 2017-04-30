from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import unittest


# browser = webdriver.Chrome()
# browser.get('http://localhost:8000')
# assert 'To-Do' in browser.title, "Browser title was " + browser.title

# 상속을 통한 Test class 생성
class NewVisitorTest(unittest.TestCase):

    # Test 전 호출
    def setUp(self):
        self.browser = webdriver.Chrome()
        # 대기 후 처리
        self.browser.implicitly_wait(2)

    # Test 후 호출 : 예외시에도 실행
    def tearDown(self):
        self.browser.quit()

    def check_for_row_in_list_table(self, row_text):
        table = self.browser.find_element_by_id('id_list_table')
        rows = table.find_elements_by_tag_name('tr')
        self.assertIn(row_text, [row.text for row in rows])

    # test~로 명명한 test Method
    def test_can_start_a_list(self):
        self.browser.get('http://localhost:8000')

        # 웹 페이지 타이틀과 헤더가 'To-Do'를 표시
        self.assertIn('To-Do', self.browser.title)
        header_text = self.browser.find_element_by_tag_name('h1').text
        self.assertIn('To-Do', header_text)

        # 작업을 추가
        input_box = self.browser.find_element_by_id('id_new_item')
        self.assertEqual(
            input_box.get_attribute('placeholder'),
            '작업 입력'
        )

        # "공구 사기"라고 텍스트박스에 입력
        input_box.send_keys('공구 사기')

        # Enter key 입력 시 페이지 갱신 및 작업목록에 '1: 공구 사기' 추가됨
        input_box.send_keys(Keys.ENTER)
        self.check_for_row_in_list_table('1: 공구 사기')

        # 추가 입력 텍스트박스가 존재
        # 다시 추가작업 입력 '공구를 이용하여 조립'
        input_box = self.browser.find_element_by_id('id_new_item')
        input_box.send_keys('공구를 이용하여 조립')
        input_box.send_keys(Keys.ENTER)

        # 페이지 재 갱신후, 두개의 작업 출력
        self.check_for_row_in_list_table('2: 공구를 이용하여 조립')
        self.check_for_row_in_list_table('1: 공구 사기')

        # 강제로 Test 실패 발생
        self.fail('Finish the test')

        # Test-story 에 맞추어 작성
        # ...


# import 가 아닌 Cmd 를 통함 unittest.main() 호출(Test Class 와 Method 를 찾아 실행)
if __name__ == '__main__':
    # 불필요한 리소스 경고 제거
    unittest.main(warnings='ignore')

