package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/binary-tree-paths/
 * @desc 二叉树的所有路径 <br/>
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths1(TreeNode root) {
		List<String> paths = new ArrayList<>();
		buildPath(root, "", paths);
		return paths;
	}

	private void buildPath(TreeNode root, String path, List<String> paths) {
		if (root != null) {			
			path = path.length() > 0 ? path + "->" + root.val : root.val + "";
			if (root.left == null && root.right == null) {
				paths.add(path);				
			} else {
				buildPath(root.left, path, paths);
				buildPath(root.right, path, paths);				
			}
		}
	}

}
