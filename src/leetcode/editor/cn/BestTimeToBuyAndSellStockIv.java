  //给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 942 👎 0

  
  package leetcode.editor.cn;
  public class BestTimeToBuyAndSellStockIv{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
      }

      public int maxProfit1(int k, int[] prices) {
          int[][][] dp = new int[prices.length][k + 1][2];
          // 初始化
          for (int i = 0; i <= k; i++) {
              dp[0][i][1] = -prices[0];
          }
          for (int i = 1; i < prices.length; i++) {
              for (int j = 1; j <= k; j++) {
                  // 0 表示不持有， 1 表示持有
                  dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                  dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
              }
          }
          return dp[prices.length - 1][k][0];
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k + 1][2];
        // 初始化
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 0 表示不持有， 1 表示持有
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }