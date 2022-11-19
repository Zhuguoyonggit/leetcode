  //编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 105 👎 0

  
  package leetcode.editor.cn;

  import java.util.*;

  public class GroupAnagramsLcci{
      public static void main(String[] args) {
           Solution solution = new GroupAnagramsLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = transform(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            // 别忘了还要加回去
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public String transform(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }