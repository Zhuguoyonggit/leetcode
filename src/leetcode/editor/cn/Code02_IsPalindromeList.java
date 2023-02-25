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
        //判断是否为空和长度为1
        if (head == null || head.next == null) {
            return true;
        }
        //找到中点或中点数向下取整位置
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //中点的next为空，并且翻转中点后的部分
        Node node1 = slow.next;
        slow.next = null;
        Node node2 = node1.next;
        node1.next = slow;
        Node tem = null;
        while (node2 != null) {
            //先保存第三个节点，第二个节点指向第一个，两个节点后移
            tem = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = tem;
        }
        //前后遍历对比，要保存最后的节点以方便还原链表
        tem = node1;
        Node start = head;
        boolean ans = true;
        while (node1 != null && start != null) {
//            if (node1.value != start.value) {
//                return false;
//            }
            // 上面不对，因为我们改变了链表的结构，不能直接返回
            if (node1.value != start.value) {
                ans = false;
                break;
            }
            node1 = node1.next;
            start = start.next;
        }
        //还原链表
        node1 = tem;
        node2 = tem.next;
        node1.next = null;
        while (node2 != null) {
            tem = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = tem;
        }
        return ans;
    }
}
