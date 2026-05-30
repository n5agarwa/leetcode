class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (stack.size() + n - i) > k && stack.peek() > nums[i]) {
                stack.pop();
            }
            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }
        int ans[] = new int[k];
        
        while (!stack.isEmpty() && k >=0) {
            ans[--k] = stack.pop();
        }
        return ans;
    }
}