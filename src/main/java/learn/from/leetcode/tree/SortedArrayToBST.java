package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance <br/>
 * @from https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/ <br/>
 *       https://leetcode-cn.com/problems/minimum-height-tree-lcci/ <br/>
 * @desc 将有序数组转换为二叉搜索树 <br/>
 *       将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 <br/>
 *       一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {

	/**
	 * @param nums
	 * @return
	 */
	public TreeNode go(int[] nums) {
		if (nums != null && nums.length > 0) {
			return build(nums, 0, nums.length - 1);
		}
		return null;
	}

	private TreeNode build(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int i = (left + right) / 2;
		TreeNode node = new TreeNode(nums[i]);
		node.left = build(nums, left, i - 1);
		node.right = build(nums, i + 1, right);
		return node;
	}

}
