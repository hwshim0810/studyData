from .base import FunctionalTest


class LayoutAndStylingTest(FunctionalTest):
    def test_layout_and_styling(self):
        self.browser.get(self.server_url)
        self.browser.set_window_size(1024, 768)

        # 입력상자의 가운데 배치 확인
        input_box = self.get_item_input_box()
        # +- 10의 반올림 처리
        self.assertAlmostEqual(
            input_box.location['x'] + input_box.size['width'] / 2,
            512,
            delta=10
        )
