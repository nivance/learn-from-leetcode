package learn.from.leetcode.linkedlist;

import learn.from.leetcode.ds.ListNode;

/**
 * @author nivance
 * @from https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @desc 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 		 k 是一个正整数，它的值小于或等于链表的长度。
 *       如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    
		ListNode pre = dummy; // 上一组最后一个node
		ListNode curr = head;
		// 1.先找出Group元素；2.反转Group元素；3. goto 1
		while (curr != null) {
			ListNode q = curr;
			for (int i = 1; i < k && q != null; i++) {
				q = q.next;
			}
			if (q == null) { // 不够K个，退出
				break;
			}
			
			ListNode start = curr;
			// curr移到下一组
			curr = q.next;
			q.next = null;
			ListNode ln = reverseNode(start);
			// 上一组的尾连这一组的头
			if (pre != null) {
				pre.next = ln;
			}
			start.next = curr;
			// 本组最后一个node
			pre = start;
		}
		return dummy.next;
	}

	private ListNode reverseNode(ListNode head){
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
	
}
