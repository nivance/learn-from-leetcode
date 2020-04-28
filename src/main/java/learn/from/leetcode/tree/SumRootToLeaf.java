package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * @desc 从根到叶的二进制数之和 <br/>
 *       给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 <br/>
 *       -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 */
public class SumRootToLeaf {

	public int sumRootToLeaf(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<String> paths = new ArrayList<>();
		buildPath(root, "", paths);
		int sum = 0;
		for (int i = 0; i < paths.size(); i++) {
			sum += Integer.parseUnsignedInt(paths.get(i), 2);
		}
		return sum;
	}

	private void buildPath(TreeNode root, String path, List<String> paths) {
		if (root != null) {
			path = path.length() > 0 ? path + root.val : root.val + "";
			if (root.left == null && root.right == null) {
				paths.add(path);
			} else {
				if (root.left != null) {
					buildPath(root.left, path, paths);
				}
				if (root.right != null) {
					buildPath(root.right, path, paths);
				}
			}
		}
	}
	
	private int sum;
	
	public int sumRootToLeaf2(TreeNode root) {
		travel(root, 0);
		return sum;
	}
	
	private void travel(TreeNode root, int curr) {
		if (root == null) {
			return;
		}
		curr = (curr << 1) + root.val;
		if (root.left == null && root.right == null) {
			sum += curr;
		}
		if (root.left != null) {
			travel(root.left, curr);
		}
		if (root.right != null) {
			travel(root.right, curr);
		}
	}

}
