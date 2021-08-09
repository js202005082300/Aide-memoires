#coding:utf-8
import sys
sys.path.append("..")
from src.panda import Panda
import unittest

class TestPanda(unittest.TestCase):
    def setUp(self):
        self.p = Panda("Kiko", 150)

    def test_panda_is_instance_of_panda(self):
        #p = Panda(15.64, 15)
        #self.assertIsInstance(p, Panda)
        self.assertIsInstance(self.p, Panda)
    
    def test_panda_age_is_positive(self):
        #p = Panda("Kiko", 15)
        #self.assertGreater(p.age, 0)
        self.assertGreater(self.p.age, 0)

if __name__ == '__main__':
    unittest.main()