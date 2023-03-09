package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 测试链接 : https://leetcode.com/problems/copy-list-with-random-pointer/
public class Code04_CopyListWithRandom {

	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList1(Node head) {
		if (head == null) {
			return head;
		}
		Map<Node, Node> map = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			Node node = map.get(cur);
			node.next = cur.next;
			node.random = cur.random;
			cur = cur.next;
		}
		return map.get(head);
	}

	public static Node copyRandomList2(Node head) {
		if (head == null) {
			return head;
		}
		// 复制节点紧跟其后
		Node cur = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.val);
			cur.next.next = next;
			cur = next;
		}
		// 对于拷贝节点的random指针进行赋值
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			cur.next.random = cur.random.next == null ? null : cur.random.next;
			cur = next;
		}
		//  对新老节点进行分离
		cur = head;
		Node res = head.next;
		while (cur != null) {
			next = cur.next.next;
			cur.next.next = next == null ? null : next.next;
			cur.next = next;
			cur = next;
		}
		return res;
	}
}