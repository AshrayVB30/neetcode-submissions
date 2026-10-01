class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = set()

        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False

# Algorithm
# 1. Create an empty set called seen.

#     > A set stores values without duplicates.
#     > It also lets us quickly check whether a value already exists.
# 2. Go through each number in nums, one at a time.
# 3. For each number:
#     > If the number is already in seen, then we have found a duplicate.
#         Return True immediately.
#     > If the number is not in seen, add it to the set.
# 4. If we finish checking the entire array without finding a duplicate, return False.