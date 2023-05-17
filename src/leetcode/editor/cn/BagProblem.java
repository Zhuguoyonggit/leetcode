package leetcode.editor.cn;

/**
 * @author zhuguoyong
 * @version 1.0
 * @description: TODO
 * @date 2023/4/23 9:20
 */
public class BagProblem {


    public static void testWeightBagProblem(int[] weight, int[] value, int bigSize) {
        // 确定dp及其下标含义
        int goods = weight.length;
        int[][] dp = new int[goods][bigSize + 1];
        // 初始化
        for (int i = weight[0]; i < bigSize; i++) {
            dp[0][i] = weight[0];
        }
        for (int i = 1; i < goods; i++) {
            for (int j = 1; j <= bigSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
    }
}
