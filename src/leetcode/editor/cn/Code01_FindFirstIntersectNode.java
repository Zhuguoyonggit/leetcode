package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Code01_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 使用set来判断是否有环
    public static Node contain(Node head) {
        if (head == null) {
            return head;
        }
        Set<Node> set = new HashSet<>();
        Node cur = head;
        while (cur != null && !set.contains(cur.next)) {
            set.add(cur);
            cur = cur.next;
        }
        if (cur == null) {
            return null;
        } else {
            return cur.next;
        }
    }

    // 使用快慢指针来判断环的位置，是否有环
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    // 链表是否有交点，交点的位置在什么地方
    public static Node getIntersectNode(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 一个为空一个不为空，一定不交
        // 两者都为空或者，相等，那么等同于无环相交
        if (loop1 == loop2) {
            return noLoopOrLike(head1, head2, loop1, loop2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(loop1, loop2);
        }
        return null;
    }

    // 可能在环上相交
    public static Node bothLoop(Node loop1, Node loop2) {
        Node cur = loop1.next;
        while (cur != loop1) {
            if (cur == loop2) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    // 都没有环，或者不在环上相交
    public static Node noLoopOrLike(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int len1 = 0;
        int len2 = 0;
        while (cur1 != loop1) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != loop2) {
            len2++;
            cur2 = cur2.next;
        }
        if (len1 > len2) {
            noLoopOrLike(head2, head1, loop2, loop1);
        }
        int lenMore = len2 - len1;
        while (lenMore > 0) {
            head2 = head2.next;
            lenMore--;
        }
        while (head1 != head2 || head1 == loop1) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == head2) {
            return head1;
        }
        return null;
    }
}
