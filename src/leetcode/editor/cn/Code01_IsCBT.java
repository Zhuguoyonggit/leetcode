package leetcode.editor.cn;

public class Code01_IsCBT {
    // 对每一棵子树，是否是满二叉树、是否是完全二叉树、高度
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        // 满二叉树
        public boolean isFull;
        public boolean isCbt;
        public int height;

        public Info(boolean isFull, boolean isCbt, int height) {
            this.isFull = isFull;
            this.isCbt = isCbt;
            this.height = height;
        }
    }

    public static boolean isCbt(Node node) {
        if (node == null) {
            return true;
        }
        return process(node).isCbt;
    }
    public static Info process(Node node) {
        if (node == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        boolean isFull = false;
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isFull = true;
        }
        boolean isCbt = false;
        if (isFull) {
            isCbt = true;
        } else {
            if (leftInfo.isCbt && rightInfo.isCbt) {
                if (leftInfo.isFull && rightInfo.isCbt && leftInfo.height == rightInfo.height + 1) {
                    isCbt = true;
                }
                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isCbt = true;
                }
                if (leftInfo.isFull && rightInfo.isCbt && leftInfo.height == rightInfo.height) {
                    isCbt = true;
                }
            }
        }
        return new Info(isFull, isCbt, Math.max(leftInfo.height, rightInfo.height) + 1);
    }
}
