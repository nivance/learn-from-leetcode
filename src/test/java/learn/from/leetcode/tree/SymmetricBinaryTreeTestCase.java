package learn.from.leetcode.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import learn.from.leetcode.ds.TreeNode;

/**
 * @author nivance
 *
 */
public class SymmetricBinaryTreeTestCase {
	
	@Test
	public void test1() {
		assertEquals(SymmetricBinaryTree.isSymmetric(null), true);
	}
	
	@Test
	public void test2() {
		TreeNode root = new TreeNode(1);
		assertEquals(SymmetricBinaryTree.isSymmetric(root), true);
	}
	
	@Test
	public void test3() {
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode l1 = new TreeNode(2);
		root.right = r1;
		root.left = l1;
		assertEquals(SymmetricBinaryTree.isSymmetric(root), true);
	}
	
	@Test
	public void test4() {
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode l1 = new TreeNode(2);
		root.right = r1;
		root.left = l1;
		TreeNode r21 = new TreeNode(3);
		TreeNode l22 = new TreeNode(4);
		r1.right = r21;
		r1.left = l22;
		TreeNode r23 = new TreeNode(3);
		TreeNode l24 = new TreeNode(4);
		l1.right = r23;
		l1.left = l24;
		assertEquals(SymmetricBinaryTree.isSymmetric(root), false);
	}
	
	@Test
	public void test5() {
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode l1 = new TreeNode(2);
		root.right = r1;
		root.left = l1;
		TreeNode r21 = new TreeNode(3);
		TreeNode l22 = new TreeNode(4);
		r1.right = r21;
		r1.left = l22;
		TreeNode r23 = new TreeNode(4);
		TreeNode l24 = new TreeNode(3);
		l1.right = r23;
		l1.left = l24;
		assertEquals(SymmetricBinaryTree.isSymmetric(root), true);
	}

}
