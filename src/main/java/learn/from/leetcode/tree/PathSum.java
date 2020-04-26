package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/path-sum/ <br/>
 * @desc 路径总和 <br/>
 *       给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && (sum - root.val == 0)) {
			return true;
		} else {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}

}
