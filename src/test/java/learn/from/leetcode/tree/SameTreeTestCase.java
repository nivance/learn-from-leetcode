package learn.from.leetcode.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import learn.from.leetcode.ds.TreeNode;

public class SameTreeTestCase {
	
	@Test
	public void testNull1() {
		assertEquals(SameTree.isSameTree(null, null), true);
	}
	
	@Test
	public void testNull2() {
		TreeNode p = new TreeNode(3);
		assertEquals(SameTree.isSameTree(p, null), false);
	}
	
	@Test
	public void test3() {
		TreeNode p = new TreeNode(1);
		TreeNode pl = new TreeNode(2);
		p.left = pl;
		
		TreeNode q = new TreeNode(1);
		TreeNode ql = new TreeNode(2);
		q.right = ql;
		assertEquals(SameTree.isSameTree(q, p), false);
	}
	
	@Test
	public void test4() {
		TreeNode p = new TreeNode(1);
		TreeNode pl = new TreeNode(2);
		p.left = pl;
		
		TreeNode q = new TreeNode(1);
		TreeNode ql = new TreeNode(2);
		q.left = ql;
		assertEquals(SameTree.isSameTree(q, p), true);
	}
	
	@Test
	public void test5() {
		TreeNode p = new TreeNode(1);
		TreeNode pl = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		p.left = pl;
		p.right = p2;
		
		TreeNode q = new TreeNode(1);
		TreeNode ql = new TreeNode(2);
		TreeNode q2 = new TreeNode(3);
		q.left = ql;
		q.right = q2;
		assertEquals(SameTree.isSameTree(q, p), true);
	}
	
}
