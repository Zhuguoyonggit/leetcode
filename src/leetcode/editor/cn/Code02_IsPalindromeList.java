package leetcode.editor.cn;

import java.util.Stack;

public class Code02_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 笔试的时候简点更好
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
        }
        return true;
    }

    // need n/2 extra space
    // 怎么没想一下快慢指针呢
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 这是中间后一个
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        return true;
    }
}
