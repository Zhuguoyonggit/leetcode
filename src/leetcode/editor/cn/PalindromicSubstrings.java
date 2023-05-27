  //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 999 👎 0

  
  package leetcode.editor.cn;
  public class PalindromicSubstrings{
      public static void main(String[] args) {
           Solution solution = new PalindromicSubstrings().new Solution();
      }
      public int countSubstrings1(String s) {
          boolean[][] dp = new boolean[s.length()][s.length()];
          for (int i = 0; i < s.length(); i++) {
              for (int j = 0; j <= i; j++) {
                  if (s.charAt(i) == s.charAt(j)) {
                      if (i - j < 3) {
                          dp[j][i] = true;
                      } else {
                          dp[j][i] = dp[j + 1][i - 1];
                      }
                  } else {
                      dp[j][i] = false;
                  }
              }
          }
          int count = 0;
          for (int i = 0; i < s.length(); i++) {
              for (int j = 0; j < s.length(); j++) {
                  if (dp[i][j]) {
                      count++;
                  }
              }
          }
          return count;
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        // dp[]发现无法被推导出来，考虑回文串的本质，i,j的范围内为真则i+1到j+1的范围可以根据其字符来推断
        // dp[i][j]需要dp[i + 1][j - 1]
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化都是FALSE
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
        }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }