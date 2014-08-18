#!/usr/bin/python

from math import *

def add1(x):
	x = x + 1
	return x


def ax(n):
	if n == 1:
		return False
	for i in range(2, 1 + int(floor(sqrt(n)))):
		if n % i == 0:
			return False
	return True

echo add1(1)
print 'Hello World' 
print floor(4.3)
print ax(23123)
print add1(23)

