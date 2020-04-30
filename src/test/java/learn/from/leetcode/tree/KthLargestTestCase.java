package learn.from.leetcode.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import learn.from.leetcode.ds.TreeNode;

public class KthLargestTestCase {
	
	private KthLargest kthLargest;
	private TreeNode root;
	
	@Before
	public void init() {
		kthLargest = new KthLargest();
		
		root = new TreeNode(5);
		TreeNode l1 = new TreeNode(3);
		TreeNode r1 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		TreeNode l21 = new TreeNode(2);
		TreeNode l22 = new TreeNode(4);
		l1.left = l21;
		l1.right = l22;
		TreeNode l31 = new TreeNode(1);
		l21.left = l31;
	}
	
	@Test
	public void test1() {
		assertEquals(kthLargest.kthLargest(root, 3), 4);
	}
	
	@Test
	public void test2() {
		assertEquals(kthLargest.kthLargest(root, 6), 1);
	}
	
	@Test
	public void test3() {
		assertEquals(kthLargest.kthLargest(root, 1), 6);
	}

}
