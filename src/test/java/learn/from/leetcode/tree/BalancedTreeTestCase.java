package learn.from.leetcode.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import learn.from.leetcode.ds.TreeNode;

public class BalancedTreeTestCase {
	
	private IsBalancedTree tree;
	
	@Before
	public void init() {
		tree = new IsBalancedTree();
	}
	
	@Test
	public void test1() {
		TreeNode p = new TreeNode(3);
		TreeNode pl = new TreeNode(9);		
		TreeNode p2 = new TreeNode(20);
		p.left = pl;
		p.right = p2;
		
		TreeNode ql = new TreeNode(15);
		TreeNode q2 = new TreeNode(7);
		p2.left = ql;
		p2.right = q2;
		assertEquals(tree.isBalanced2(p), true);
	}

}
