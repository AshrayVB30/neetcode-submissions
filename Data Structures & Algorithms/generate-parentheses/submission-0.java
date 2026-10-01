class Solution {
    // Helper method using backtracking to build all valid combinations of parentheses
    private void backtrack(int openN, int closeN, int n, List<String> res, StringBuilder stack) {
        // Base case: if the number of open and close parentheses used equals n,
        // it means we have a valid combination
        if (openN == closeN && openN == n) {
            res.add(stack.toString()); // Add the current valid combination to the result list
            return;
        }

        // If we can still add an open parenthesis (i.e., we haven't reached the max limit `n`)
        if (openN < n) {
            stack.append("("); // Choose: add an open parenthesis
            backtrack(openN + 1, closeN, n, res, stack); // Explore further with one more open
            stack.deleteCharAt(stack.length() - 1); // Undo the choice (backtrack)
        }

        // If the number of closing parentheses is less than open ones, we can safely add a closing one
        if (closeN < openN) {
            stack.append(")"); // Choose: add a closing parenthesis
            backtrack(openN, closeN + 1, n, res, stack); // Explore further with one more close
            stack.deleteCharAt(stack.length() - 1); // Undo the choice (backtrack)
        }
    }

    // Public method to initiate the backtracking process
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); // To store all valid combinations
        StringBuilder stack = new StringBuilder(); // To build the current combination
        backtrack(0, 0, n, res, stack); // Start the recursion with 0 open and 0 close parentheses
        return res; // Return the final list of combinations
    }
}