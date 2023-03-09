package leetcode.editor.cn;

public class Code03_IsBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.height = height;
            this.isBalanced = isBalanced;
        }


    }
    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean balanced = true;
        if (!leftInfo.isBalanced) {
            balanced = false;
        }
        if (!rightInfo.isBalanced) {
            balanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            balanced = false;
        }
        return new Info(balanced, height);
    }
    public static boolean isBalanced(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBalanced;
    }
}
