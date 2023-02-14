package leetcode.editor.cn;

public class Code01_ReverseList {
    public static class Node{
        Node next;
        int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

        public static Node reverse(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node pre = null;
            while (head != null) {
                Node next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

}
