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

	/**
	 * --------------------------------------------------
	 * 
	 * @from https://leetcode-cn.com/problems/path-sum-iii/
	 * @desc 给定一个二叉树，它的每个结点都存放着一个整数值。 <br/>
	 *       找出路径和等于给定数值的路径总数。<br/>
	 *       路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。<br/>
	 *       二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。<br/>
	 * 
	 *       --------------------------------------------------
	 */
	private int count = 0;

	public int pathSum(TreeNode root, int sum) {
		preOrderPath(root, sum);
		return count;
	}

	private void preOrderPath(TreeNode root, int sum) {
		if (root != null) {
			count += hasPathSum2(root, sum);
			if (root.left != null) {
				preOrderPath(root.left, sum);
			}
			if (root.right != null) {
				preOrderPath(root.right, sum);
			}
		}
	}

	private int hasPathSum2(TreeNode root, int sum) {
		if (root != null) {
			int v = sum - root.val;
			int result = v == 0 ? 1 : 0;
			return result + hasPathSum2(root.left, v) + hasPathSum2(root.right, v);
		}
		return 0;
	}
}
