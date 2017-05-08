from .base import FunctionalTest


class ItemValidationTest(FunctionalTest):
    def test_cannot_add_empty_list_items(self):
        # 빈 작업을 등록하려고 엔터키를 눌러 등록
        self.browser.get(self.server_url)
        self.get_item_input_box().send_keys('\n')

        # 페이지 새로 고침 후, 빈 아이템은 등록불가 에러메세지 출력
        err = self.browser.find_element_by_class_name('has-error')
        self.assertEqual(err.text, "빈 아이템은 등록불가")
        
        # 다른 아이템 입력
        self.get_item_input_box().send_keys('우유 사기\n')
        self.check_for_row_in_list_table('1: 우유 사기')
        
        # 다시 빈 아이템 등록
        self.get_item_input_box().send_keys('\n')
        
        # 다시 에러메세지 표시
        self.check_for_row_in_list_table('1: 우유 사기')
        err = self.browser.find_element_by_class_name('has-error')
        self.assertEqual(err.text, "빈 아이템은 등록불가")
        
        # 내용이 있는 아이템을 등록하면 동작
        self.get_item_input_box().send_keys('커피 우유 만들기\n')
        self.check_for_row_in_list_table('1: 우유 사기')
        self.check_for_row_in_list_table('2: 커피 우유 만들기')

