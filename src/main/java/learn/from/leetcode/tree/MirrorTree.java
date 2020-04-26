package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * @desc 二叉树的镜像
 */
public class MirrorTree {
	
	public TreeNode mirrorTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			mirrorTree(root.left);
			mirrorTree(root.right);
		}
		return root;
	}

}
