package learn.from.leetcode.array;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/find-majority-element-lcci/
 * @desc 主要元素: 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * 		你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？  
 */
public class MajorityElement {
	
	public int majorityElement(int[] nums) {
		if (nums != null && nums.length > 0) {
			int tmp = nums[0];
			int count = 1;
			for (int i = 1; i < nums.length; i++) {
				if(tmp ==  nums[i]) {
					count++;
				} else {
					if (--count == 0) {
						tmp = nums[i];
						count = 1;
					}
				}
			}
			// 验证是否满足要求
			count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == tmp) {
					count ++;
				}
			}
			if (count > (nums.length >> 1)) {
				return tmp;
			}
		} 
		return -1;
    }

}
