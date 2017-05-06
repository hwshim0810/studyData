from .base import FunctionalTest


class ItemValidationTest(FunctionalTest):
    def test_cannot_add_empty_list_items(self):
        # 빈 작업을 등록하려고 엔터키를 눌러 등록

        # 페이지 새로 고침 후, 빈 아이템은 등록불가 에러메세지 출력
        self.fail('write')
