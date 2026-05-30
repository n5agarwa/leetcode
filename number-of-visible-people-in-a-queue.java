class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans[] = new int[n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            count = 0;
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }

            if (!stack.isEmpty())
                count++;
            ans[i] = count;
            stack.push(heights[i]);
        }
        return ans;
    }
}