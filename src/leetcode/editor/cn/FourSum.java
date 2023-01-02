  //给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1462 👎 0

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.List;

  public class FourSum{
      public static void main(String[] args) {
           Solution solution = new FourSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 一定不能忘记排序呀
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    // 注意这个看k < n要放在前面防止越界
                    while (k > j + 1 && k < n && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    if (k >= l) {
                        break;
                    }
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;    // 这里忘记k++了
                    }
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }