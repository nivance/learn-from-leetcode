package learn.from.leetcode.tree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import learn.from.leetcode.ds.Node;

public class NTreeOrderTestCase {
	
	private NTreeOrder nTreeOrder;
	
	@Before
	public void init() {
		nTreeOrder = new NTreeOrder();
	}
	
	@Test
	public void test1() {
		Node node = new Node(1, new ArrayList<>());
		for (int i = 0; i < 3; i++) {
			Node n = new Node();
			n.val = i + 2;
			node.children.add(n);
		}
		assertEquals(nTreeOrder.preorder(node), Arrays.asList(new int[]{1, 2, 3, 4}));
	}

}
