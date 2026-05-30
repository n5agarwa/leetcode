class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            int modidx = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[modidx]) {
                ans[stack.pop()] = nums[modidx];
            }
            if (i < n)
                stack.push(modidx);
        }
        return ans;
    }
}