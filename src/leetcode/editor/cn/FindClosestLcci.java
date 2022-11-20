  //有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
//
// Related Topics 数组 字符串 👍 96 👎 0

  
  package leetcode.editor.cn;
  public class FindClosestLcci{
      public static void main(String[] args) {
           Solution solution = new FindClosestLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        // 想的问题出现了逻辑错误
        // 自己用了两个指针记录位置，但当符合条件时，不能直接移动两个指针
        // 显然让两个指针记录位置是简洁的
        int l = -1;
        int r = -1;
        // 要求最小的话，结果的初始化应该是最大
        int res = words.length;
        if (word1 == null || word2 == null) {
            return 0;
        }
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                l = i;
            }
            if (word2.equals(words[i])) {
                r = i;
            }
            // 判断是否是标志位
            if (l != -1 && r != -1) {
                res = Math.min(res, Math.abs(r - l));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }