package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/same-tree/
 * @desc 给定两个二叉树，编写一个函数来检验它们是否相同。 <br/>
 *       如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

}
