from django.test import TestCase


class ExTest(TestCase):
    def test_ex_sum(self):
        self.assertEqual(1 + 1, 3)
