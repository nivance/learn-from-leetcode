package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @desc 二叉树的层序遍历
 */
public class LevelOrder {

	public static List<List<Integer>> go(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = queue.size();
		while (count > 0) {
			List<Integer> subList = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pop();
				subList.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count = queue.size();
			list.add(subList);
		}
		return list;
	}

}
