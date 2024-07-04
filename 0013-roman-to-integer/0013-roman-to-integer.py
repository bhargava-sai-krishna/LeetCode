def value(r):
	if (r == 'I'):
		return 1
	if (r == 'V'):
		return 5
	if (r == 'X'):
		return 10
	if (r == 'L'):
		return 50
	if (r == 'C'):
		return 100
	if (r == 'D'):
		return 500
	if (r == 'M'):
		return 1000
	return -1

class Solution:
    def romanToInt(self, s: str) -> int:
        res = 0
        i = 0
        n=len(s)
        while (i < n):
            s1 = value(s[i])
            if (i + 1 < len(s)):
                s2 = value(s[i + 1])
                if (s1 >= s2):
                    res = res + s1
                    i = i + 1
                else:
                    res = res + s2 - s1
                    i = i + 2
            else:
                res = res + s1
                i = i + 1
        return res