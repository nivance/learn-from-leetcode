package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @desc 二叉树的最小深度<br/>
 *       最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		if (root.left != null && root.right != null) {
			return Math.min(leftMinDepth, rightMinDepth) + 1;			
		} else {
			return leftMinDepth + rightMinDepth + 1;
		}
	}

}
