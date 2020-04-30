package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @desc 二叉搜索树的第k大节点
 */
public class KthLargest {
	private int count, result;

	public int kthLargest(TreeNode root, int k) {
		this.count = k;
		rightOrder(root);
		return result;
	}

	// 右中左遍历，顺数第K个
	private void rightOrder(TreeNode node) {
		if (node != null) {
			rightOrder(node.right);
			if (--count == 0) {
				result = node.val;
			}
			rightOrder(node.left);
		}
	}

}
