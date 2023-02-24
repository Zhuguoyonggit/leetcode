package leetcode.editor.cn;

import java.util.ArrayList;

/*
* 中间位置问题
* */
public class Code01_LinkedListMid {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    // 为了循环可以先判断两个
    public Node midOrUpMidNode(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 使用快慢指针进行遍历
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 笔试的时候更加容易理清楚逻辑的方法
    public Node right(Node head) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        return nodes.get((nodes.size() - 1) / 2);
    }
}
