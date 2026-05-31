import java.util.*;

public class RemoveDupsFromSortArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        int length = new RemoveDupsFromSortArray().removeDuplicates(nums);
        System.out.println(length + " -> " + Arrays.toString(Arrays.copyOf(nums, length)));
    }

	public int removeDuplicates(int[] nums) {
		int counter = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[counter]) {
				nums[++counter] = nums[j];
			}
		}
		return counter + 1;
	}
}
