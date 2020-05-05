package learn.from.leetcode.tree;

import java.util.Stack;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @desc 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
			假设一个二叉搜索树具有如下特征：
			节点的左子树只包含小于当前节点的数。
			节点的右子树只包含大于当前节点的数。
			所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
	
	public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }
	
	private boolean help(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}
		if (lower != null && node.val <= lower) {
			return false;
		}
		if (upper != null && node.val >= upper) {
			return false;
		}
		if (!help(node.left, lower, node.val)) {
			return false;
		}
		if (!help(node.right, node.val, upper)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 中序遍历的方式
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		int inOrderVal = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode node = stack.pop();
				if (node.val <= inOrderVal) {
					return false;
				} else {
					inOrderVal = node.val;
					root = node.right;
				}
			}
		}
		return true;
	}

}
