import java.util.*;

class NumberOfValidSubarrays {
    public static void main(String[] args) {
        System.out.println("NumberOfValidSubarrays is runnable. Add test cases in main().");
    }
    public int validSubarrays(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < length; i++) {
            //when found a smaller means end of index, push all subarrays' length
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result += i - stack.pop();
            }
            stack.push(i);
        }
        //for remaining indices - can go till end
        while (!stack.isEmpty())
            result += length - stack.pop();
        return result;
    }
}