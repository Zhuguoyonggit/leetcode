package leetcode.editor.cn;

public class Code01_Trie {
    // 前缀树用来记录和查找字符串的个数和以pre开头的数目
    class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];// 只有26个字符
        }
    }

    private Node root;

    public Code01_Trie() {
        root = new Node();
    }

    public void insert(String str) {
        if (str == null) {
            return;
        }
        char[] chars = str.toCharArray();
        Node node = root;
        node.pass++;
        int path = 0;
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    // 查找指定字符串的数目
    public int search(String str) {
        if (str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    // 以字符串开头的数目
    public int startSearch(String str) {
        if (str == null) {
            return 0;
        }
        Node node = root;
        char[] chars = str.toCharArray();
        int path = 0;
        for (int i = 0; i < chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.pass;
    }

    public void delete(String str) {
        if (str == null) {
            return;
        }
        if (search(str) != 0) {
            Node node = root;
            node.pass--;
            int path = 0;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    // 不必要继续往下遍历，可以直接退出了
                    return;
                }
                node = node.nexts[path];
            }
            // 当遍历到全部时，对end--
            node.end--;
        }
        System.out.println("没有字符串可以删除");
    }
}
