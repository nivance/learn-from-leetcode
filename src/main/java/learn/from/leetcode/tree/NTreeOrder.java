package learn.from.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import learn.from.leetcode.ds.Node;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal <br />
 *       https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @desc N叉树的前序和后序遍历
 */
public class NTreeOrder {

	/**
	 * 前序遍历
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<>();
		preOrderTraval(root, list);
		return list;
	}

	private void preOrderTraval(Node root, List<Integer> list) {
		if (root != null) {
			list.add(root.val);
			if (root.children != null && root.children.size() > 0) {
				for (Node n : root.children) {
					preOrderTraval(n, list);
				}
			}
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 * @param list
	 */
	private void postOrderTraval(Node root, List<Integer> list) {
		if (root != null) {
			if (root.children != null && root.children.size() > 0) {
				for (Node n : root.children) {
					postOrderTraval(n, list);
				}
			}
			list.add(root.val);
		}
	}

}
