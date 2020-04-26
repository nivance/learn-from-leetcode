package learn.from.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/ <br/>
 *       https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @desc 二叉树的最大深度
 */
public class MaxDepth {

	public static int maxDepth(TreeNode root) {
		if (root != null) {
			int depth = 0;
			Deque<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				depth++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.pop();
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				size = queue.size();
			}
			return depth;
		}
		return 0;
	}

	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
