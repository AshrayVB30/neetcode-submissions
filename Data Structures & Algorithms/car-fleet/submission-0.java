class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair: [position, speed]
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort cars by starting position in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            double time = (double)(target - p[0]) / p[1];
            // If this car catches up to the car in front, they form one fleet
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }

        return stack.size();
    }
}
