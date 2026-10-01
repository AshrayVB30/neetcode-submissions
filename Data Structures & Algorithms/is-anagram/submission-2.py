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