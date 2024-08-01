import unittest
import sys
import os

# Adjust the path to include the 'src' directory
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

from arithmetic import add, subtract, multiply, divide

class TestArithmetic(unittest.TestCase):

    def setUp(self):
        # Called before every test method
        print(f"Starting test: {self._testMethodName}")

    def tearDown(self):
        # Called after every test method
        print(f"Finished test: {self._testMethodName}")

    def test_add(self):
        print("Running test_add")
        self.assertEqual(add(2, 3), 5)
        self.assertEqual(add(-1, 1), 0)

    def test_subtract(self):
        print("Running test_subtract")
        self.assertEqual(subtract(5, 3), 2)
        self.assertEqual(subtract(0, 5), -5)

    def test_multiply(self):
        print("Running test_multiply")
        self.assertEqual(multiply(2, 3), 6)
        self.assertEqual(multiply(-1, -1), 1)

    def test_divide(self):
        print("Running test_divide")
        self.assertEqual(divide(6, 3), 2)
        self.assertEqual(divide(-9, -3), 3)
        with self.assertRaises(ValueError):
            divide(1, 0)

if __name__ == '__main__':
    unittest.main()
