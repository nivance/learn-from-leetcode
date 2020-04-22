package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @desc 二叉树的中序遍历
 */
public class InorderTraversal {

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		return list;
	}

	private static void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root != null) {
			inorderTraversal(root.left, list);
			list.add(root.val);
			inorderTraversal(root.right, list);
		}
	}

	/**
	 * 基于栈
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
	
	/**
	 * 莫里斯遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode curr = root;
		TreeNode pre;
		while(curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			} else {
				pre = curr.left;
				while(pre.right != null) {
					pre = pre.right;
				}
				pre.right = curr;
				TreeNode tmp = curr;
				curr = curr.left;
				tmp.left = null;
			}
		}
		return res;
	}

}
