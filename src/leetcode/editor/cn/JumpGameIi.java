  //给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1907 👎 0

  
  package leetcode.editor.cn;

  public class JumpGameIi{
      public static void main(String[] args) {
           Solution solution = new JumpGameIi().new Solution();
      }
      public int jump1(int[] nums) {
          int n = nums.length;
          // 记录至少需要多少步到达
          int[] ints = new int[n];
          for (int i = 1, j = 0; i < n; i++) {
              while (j + nums[j] < i) {
                  j++;
              }
              ints[i] = ints[j] + 1;
          }
          return ints[n - 1];
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 当前范围和下一步范围如果下一步范围超出，说明了到达，count需要每次当前范围到达下一个范围
        int count = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(i + nums[i], next);
            if (i == cur) {
                count++;
                cur = next;
                if (next >= nums.length - 1) {
                    break;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }