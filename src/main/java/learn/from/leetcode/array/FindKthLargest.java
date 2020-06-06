package learn.from.leetcode.array;

import java.util.Arrays;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @desc 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
	
	public int findKthLargest0(int[] nums, int k) {
		int len = nums.length;
		Arrays.sort(nums);
		return nums[len -k];
	}

	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		int left = 0;
		int right = len -1;
		
		int target = len = k;
		while(true) {
			int index = parition(nums, left, right);
			if (index == target) {
				return nums[target];
			} else if (index < target) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}
	}
	
	/**
	 * 在数组 nums 的子区间 [left, right] 执行 partition 操作, 返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private int parition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int j = left;
		for (int i = left + 1; i<= right; i++) {
			if (nums[i] < pivot) {
				// 小于 pivot 的元素都被交换到前面
				j++;
				swap(nums, i, j);
			}
		}
		// 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
		swap(nums, j, left);
		// 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
		return j;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
