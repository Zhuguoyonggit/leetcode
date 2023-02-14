  //DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 448 👎 0

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;

  public class RepeatedDnaSequences{
      public static void main(String[] args) {
           Solution solution = new RepeatedDnaSequences().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // 小于等于，因为0算一个了
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                list.add(str);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }