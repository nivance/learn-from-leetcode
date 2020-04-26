package learn.from.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/symmetric-tree/ <br/>
 *       https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * @desc 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricBinaryTree {

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return isMirror(root.left, root.right);
		}
	}

	private static boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else {
			return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
		}
	}

	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}

}
