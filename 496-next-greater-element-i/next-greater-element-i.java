class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ansmap = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int ans[] = new int[nums1.length];
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < n) {
                ansmap.put(stack.peekLast(), n);
                stack.pollLast();

            }
            stack.offer(n);
        }
        while (!stack.isEmpty()) {
            ansmap.put(stack.pollLast(), -1);
        }
        for (int i = 0; i < nums1.length; i++)
            ans[i] = ansmap.get(nums1[i]);
        return ans;
    }
}