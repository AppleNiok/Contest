class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        s = sum(x for x in nums if x > 0)
        a = [abs(x) for x in nums]
        p = [0]
        a.sort()
        for x in a[:k]:
            q = [x + y for y in p]
            p = p + q
            p.sort()
            p = p[:k]
        return s - p[k - 1]