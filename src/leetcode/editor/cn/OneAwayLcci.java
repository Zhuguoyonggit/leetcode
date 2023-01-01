  //字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
//
// Related Topics 双指针 字符串 👍 229 👎 0

  
  package leetcode.editor.cn;

  public class OneAwayLcci{
      public static void main(String[] args) {
           Solution solution = new OneAwayLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        // 第一次用的for循环写挺麻烦，同时漏了考虑一些问题，双指针加while就好些
        int m = first.length();
        int n = second.length();
        if (Math.abs(m - n) > 1) {
            return  false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        // 这个判断很好，不用下面进行比长短了
        if (m > n) {
            return oneEditAway(second, first);
        }
        while (i < m && i < n && count <= 1) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (n == m) {
                    i++;
                    j++;
                    count++;
                    if (count > 1) {
                        return false;
                    }
                } else {
                    j++;
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        return count <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }