package learn.from.leetcode.tree;

import org.junit.Before;
import org.junit.Test;

import learn.from.leetcode.ds.ListNode;
import learn.from.leetcode.linkedlist.ReverseKGroup;

public class ReverseKGroupTestCase {

	private ReverseKGroup reverseKGroup;

	@Before
	public void init() {
		reverseKGroup = new ReverseKGroup();
	}

	@Test
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		ListNode listNode = reverseKGroup.reverseKGroup(node1, 3);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	
}
