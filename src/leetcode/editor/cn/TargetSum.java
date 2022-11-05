  //给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1398 👎 0

  
  package leetcode.editor.cn;

  import java.util.BitSet;

  public class TargetSum{
      public static void main(String[] args) {
           Solution solution = new TargetSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 思路，要有结果就要左面 left - (sum - left) = target -> left = (target + sum)/2
        // 这里是个难点，也是能否转化为背包问题的关键
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 考虑不能背包，不符合条件的是很关键的
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        // 注意这里的值要大于零
        int bagNumber = (sum + target) / 2 > 0 ? (sum + target) / 2 : - (sum + target) / 2;
        int[] dp = new int[bagNumber + 1];
        // 初始化很重要，千万不能忘记
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagNumber; j >= nums[i]; j--) {
                // 地推公式的意思是已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 dp[5]
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagNumber];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }