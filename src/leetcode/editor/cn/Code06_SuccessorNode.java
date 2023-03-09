package leetcode.editor.cn;

public class Code06_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    // 后继节点: 有右树的话，最左的节点，无右树，第一个左父节点
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }

        if (node.right != null) {
            return getMostLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 前区节点 有左树，左树的最后一个，无左树第一个右父节点
    public static Node lastNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            return getMostLastNode(node.left);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static void printAllFolds(int n) {
        process(1, n, true);
        System.out.println();
    }

    public static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i++, n, true);
        System.out.println(down ? "凹" : "凸");
        process(i++,n,false);
    }
    public static Node getMostLastNode(Node node) {
        while (node != null) {
            node = node.right;
        }
        return node;
    }
    public static Node getMostLeft(Node node) {
        while (node != null) {
            node = node.left;
        }
        return node;
    }
}
