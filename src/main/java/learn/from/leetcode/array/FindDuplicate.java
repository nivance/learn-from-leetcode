package learn.from.leetcode.array;

/**
 * @author nivance
 * @https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @desc 寻找重复数
 * 		 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class FindDuplicate {

	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		for (int i = 0; i < nums.length; i++) {
			while ((i + 1) != nums[i]) {
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				int tmp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = tmp;
			}
		}
		return -1;
	}

	public int findDuplicate1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum - ((nums.length * (nums.length - 1)) >> 1);
	}
}
