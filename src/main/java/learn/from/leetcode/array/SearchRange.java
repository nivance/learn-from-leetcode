package learn.from.leetcode.array;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 		 https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @desc  在排序数组中查找元素的第一个和最后一个位置
 * 		     给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 		    你的算法时间复杂度必须是 O(log n) 级别。
 * 		    如果数组中不存在目标值，返回 [-1, -1]
 */
public class SearchRange {
	
	public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int mid  = (i + j) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i -1;

        i = 0;
        j = nums.length - 1;
        while(i <= j) {
            int mid  = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j + 1;
        if (left <= right) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

}
