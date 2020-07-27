package learn.from.leetcode.linkedlist;

import learn.from.leetcode.ds.ListNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 		 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @desc 输入两个链表，找出它们的第一个公共节点。
 */
public class IntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pa = headA, pb = headB;
		while (pa != pb) {
			pa = pa == null ? headB : pa.next;
			pb = pb == null ? headA : pb.next;
		}
		return pa;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int lengthA = getListNodeLength(headA);
		int lengthB = getListNodeLength(headB);
		ListNode pa = headA, pb = headB;
		if (lengthA > lengthB) {
			pa = forward(pa, lengthA - lengthB);
		} else {
			pb = forward(pb, lengthB - lengthA);			
		}
		while(pa != pb) {
			pa = pa.next;
			pb = pb.next;
		}
		return pa;
	}
	
	private ListNode forward(ListNode head, int step) {
		for (int i = 0; i < step; i++) {
			head = head.next;
		}
		return head;
	}
	
	private int getListNodeLength(ListNode head) {
		int length = 0;
		ListNode h = head;
		while(h != null) {
			length++;
			h = h.next;
		}
		return length;
	}
}
