package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/path-sum-ii/
 * @desc 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSumII {
	List<List<Integer>> rs = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		dfs(root, sum);
		return rs;
	}

	private Deque<Integer> tempRs = new LinkedList<>();

	private void dfs(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		tempRs.addLast(root.val);
		if (root.right == null && root.left == null && sum - root.val == 0) {
			rs.add(new ArrayList<>(tempRs));
		}
		dfs(root.left, sum - root.val);
		dfs(root.right, sum - root.val);
		tempRs.pollLast();
	}

}
