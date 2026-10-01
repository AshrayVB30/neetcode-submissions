class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # checking the length
        if len(s) != len(t):
            return False

        # Count char frequencies
        count = {}
        for char_s, char_t in zip(s, t):
            count[char_s] = count.get(char_s, 0) + 1
            count[char_t] = count.get(char_t, 0) - 1

        # verifying balance
        return all(value == 0 for value in count.values())

### Algorithm

# 1. **Check if the string lengths are equal.**
# > If `s` and `t` have different lengths, they cannot be anagrams.
# > Return `False` immediately.


# 2. **Create an empty hash map (dictionary) called `count`.**
# > A hash map lets us store each character and track how many times it appears.


# 3. **Go through both strings character by character at the same time.**
# > For the character from `s`, add `1` to its tally in `count`.
# > For the character from `t`, subtract `1` from its tally in `count`.


# 4. **Verify if all character tallies balanced out.**
# > If every count in `count` equals `0`, then both strings had the exact same letters in the same amounts—return `True`.
# > If any value is not `0`, a letter was missing or extra—return `False`.