package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Code03_UnRecursiveTraversalBT {
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node() {

        }
    }

    // 使用栈实现先序遍历: 头左右->栈的话，头右左
    public static void pre(Node head) {
        Deque<Node> stack = new LinkedList<>();
        if (head == null) {
            return;
        }
        stack.push(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    // 使用栈实现中序遍历 左中右， 一直添加左节点，到无法添加，输出，然后探测右孩子
    public static void in(Node head) {
        Deque<Node> stack = new LinkedList<>();
        Node node = head;
        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    // 实现后序遍历，就是左右中， 中右左的栈-> 中左右的栈
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack1 = new LinkedList<>();
        Deque<Node> stack2 = new LinkedList<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack2.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }
    }

    public static void level(Node head) {
        // 使用队列
        Deque<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
    }
}
