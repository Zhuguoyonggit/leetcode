package leetcode.editor.cn;

public class Code03_SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static Node listPartition2(Node head,int pivot) {
		if (head == null || head.next == null) {
			return head;
		}
		Node head1 = null;
		Node head2 = null;
		Node head3 = null;
		Node tail1 = null;
		Node tail2 = null;
		Node tail3 = null;
		Node next = null;// 用来保存下一个节点
		Node cur = head;
		while (cur != null) {
			next = cur.next;
			if (cur.value < pivot) {
				if (head1 == null) {
					head1 = cur;
					tail1 = cur;
				} else {
					tail1 = cur;
				}
			} else if (cur.value == pivot) {
				if (head2 == null) {
					head2 = cur;
					tail2 = cur;
				} else {
					tail2 = cur;
				}
			} else {
				if (head3 == null) {
					head3 = cur;
					tail3 = cur;
				} else {
					tail3 = cur;
				}
			}
		}
		if (tail1 != null) {
			if (tail2 != null) {
				tail1.next = head2;
				tail2.next = head3;
			} else {
				tail1.next = head3;
			}
			return head1;
		} else {
			if (tail2 != null) {
				tail2 = head3;
				return head2;
			} else {
				return head3;
			}
		}
	}
}