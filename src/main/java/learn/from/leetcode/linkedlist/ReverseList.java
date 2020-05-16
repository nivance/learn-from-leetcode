package learn.from.leetcode.linkedlist;

import learn.from.leetcode.ds.ListNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/reverse-linked-list/
 * @desc 反转一个单链表
 */
public class ReverseList {
	
	public ListNode reverseList1(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		return pre;
    }
	
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = reverseList2(head);
		head.next.next = head;
		head.next = null;
		return p;
    }

}
