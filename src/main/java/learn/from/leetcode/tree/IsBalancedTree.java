package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/balanced-binary-tree/ <br/>
 *       https://leetcode-cn.com/problems/check-balance-lcci
 * @desc 给定一个二叉树，判断它是否是高度平衡的二叉树。<br/>
 *       本题中，一棵高度平衡二叉树定义为：<br/>
 *       一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalancedTree {

	/**
	 * 自顶向下的遍历(存在大量冗余计算, 可通过map存储每个节点的高度)
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left)
					&& isBalanced(root.right);
		}
		return true;
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	/**
	 * 自底向上（后序遍历）
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced2(TreeNode root) {
		return isBalanceTree(root).balanced;
	}

	private TreeInfo isBalanceTree(TreeNode root) {
		if (root == null) {
			return new TreeInfo(-1, true);
		}
		TreeInfo leftTreeInfo = isBalanceTree(root.left);
		if (!leftTreeInfo.balanced) {
			return new TreeInfo(-1, false);
		}
		TreeInfo rightTreeInfo = isBalanceTree(root.right);
		if (!rightTreeInfo.balanced) {
			return new TreeInfo(-1, false);
		}
		if (Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1) {
			return new TreeInfo(Math.max(leftTreeInfo.height, rightTreeInfo.height), true);
		} else {
			return new TreeInfo(-1, false);
		}
	}

	class TreeInfo {
		public final int height;
		public final boolean balanced;

		public TreeInfo(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
	}

}
