  //有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 227 👎 0

  
  package leetcode.editor.cn;

  public class GetKthMagicNumberLcci{
      public static void main(String[] args) {
           Solution solution = new GetKthMagicNumberLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        // 逐步计算求得
        int[] res = new int[k + 1];
        int i3 = 1;
        int i5 = 1;
        int i7 = 1;
        int index = 2;
        // 为方便res[0]不使用
        res[1] = 1;
        while (index <= k) {
            // 乘以上一个求得的数字
            int x = 3 * res[i3];
            int y = 5 * res[i5];
            int z = 7 * res[i7];
            int min = Math.min(x, Math.min(y, z));
            if (min == x) {
                i3++;
            }
            if (min == y) {
                i5++;
            }
            if (min == z) {
                i7++;
            }
            res[index] = min;
            index++;
        }
        return res[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }