class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            // Skip non-alphanumeric characters on the left
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            // Skip non-alphanumeric characters on the right
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }

            // Compare characters in a case-insensitive way
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean alphaNum(char c) {
        return (Character.isLetterOrDigit(c));
    }
}
