package learn.from.leetcode.tree;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ <br/>
 *       https://leetcode-cn.com/classic/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof <br/>
 * @desc 二叉搜索树的最近公共祖先   <br/>
 *       公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 *       的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorBST {
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal >= parentVal && qVal >= parentVal) {
        	return lowestCommonAncestor1(root.right, p, q);
        } else if (pVal <= parentVal && qVal <= parentVal) {
        	return lowestCommonAncestor1(root.left, p, q);
        } else {
        	return root;
        }
    }
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (root != null) {
        	int parentVal = node.val;
        	if (parentVal > pVal && parentVal > qVal) {
        		node = node.left;
        	} else if (parentVal < pVal && parentVal < qVal) {
        		node = node.right;
        	} else {
        		return node;
        	}
        }
        return null;
    }

}
