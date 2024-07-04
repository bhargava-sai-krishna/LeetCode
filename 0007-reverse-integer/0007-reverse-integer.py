class Solution:
    def reverse(self, x: int) -> int:
        if(x>=0):
            a=str(x)
            a=a[::-1]
            a=int(a)
            if(a >= 2 ** 31 - 1 or a <= -2 ** 31):
                return 0
            return a
        else:
            x=x*-1
            a=str(x)
            a=a[::-1]
            a=int(a)
            a=-a
            if(a >= 2 ** 31 - 1 or a <= -2 ** 31):
                return 0
            return a