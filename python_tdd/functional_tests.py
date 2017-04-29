from selenium import webdriver
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

    # test~로 명명한 test Method
    def test_can_start_a_list(self):
        self.browser.get('http://localhost:8000')

        # 웹 페이지 타이틀과 헤더가 'To-Do'를 표시
        self.assertIn('To-Do', self.browser.title)
        self.fail('Finish the test') # 강제로 Test 실패 발생

    # Test-story 에 맞추어 작성
    # ...

    # import 가 아닌 Cmd 를 통함 unittest.main() 호출(Test Class 와 Method 를 찾아 실행)
    if __name__ == '__main__':
        # 불필요한 리소스 경고 제거
        unittest.main(warnings='ignore')

