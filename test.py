# into the test.py current directory, and then go into the python commond environment, then key in the "python test.py"

#!/usr/bin/python

from math import *

def bx(n):
	n = n +2;
	return n


def ax(n):
	if n == 1:
		return False
	for i in range(2, 1 + int(floor(sqrt(n)))):
		if n % i == 0:
			return False
	return True

print ax(23123)
print ax(23124)
print bx(3)
print bx(4)

