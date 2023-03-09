package leetcode.editor.cn;

public class Code02_IsBST {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static boolean isBst(Node node) {
        if (node == null) {
            return true;
        }
        return process(node).isBst;
    }
    public static class Info{
        public boolean isBst;
        public int max;
        public int min;


        public Info(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }
    public static Info process(Node node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        // 看看是否符合
        // 注意要判断是否为空
        boolean isBst= true;
        if (leftInfo != null && !leftInfo.isBst) {
            isBst = false;
        }
        if (rightInfo != null && !rightInfo.isBst) {
            isBst = false;
        }
        if (leftInfo != null && leftInfo.max >= node.value) {
            isBst = false;
        }
        if (rightInfo != null && rightInfo.min <= node.value) {
            isBst = false;
        }
        // 求出最大值，最小值
        int max = node.value;
        int min = node.value;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        return new Info(isBst, max, min);
    }
}
