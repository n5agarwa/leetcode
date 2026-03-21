class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int left[] = new int[n];
        int right[] = new int[n];

        //left pairs
        for (int i = 0; i < n; i++) {
            //Monotonic increasing stack
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        //right pairs
        for (int i = n - 1; i >= 0; i--) {
            //Monotonic decreasing stack
            //Monotonic increasing stack
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }
        return (int) sum;
    }
}