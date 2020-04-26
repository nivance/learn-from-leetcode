package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/ <br/>
 *       https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @desc 二叉的最近公共祖先 <br/>
 *       公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 *       的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == q || root == p) {
			return root;
		}
		TreeNode left = lowestCommonAncestor1(root.left, p, q);
		TreeNode right = lowestCommonAncestor1(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}

}
