  //给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 672 👎 0

  
  package leetcode.editor.cn;

  import java.util.HashMap;
import java.util.Map;

  public class ContainsDuplicateIii{
      public static void main(String[] args) {
           Solution solution = new ContainsDuplicateIii().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 使用桶排序，这方法很好
        size = valueDiff + 1;
        Map<Long, Long> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            long index = getIndex(u);
            // 如果有了桶返回TRUE
            if (map.containsKey(index)) {
                return true;
            }
            // 没有桶，判断相邻的桶
            if (map.containsKey(index - 1) && u - map.get(index - 1) <= valueDiff) {
                return true;
            }
            if (map.containsKey(index + 1) && map.get(index + 1) - u <= valueDiff) {
                return true;
            }
            map.put(index, u);
            if (i >= indexDiff) {
                map.remove(getIndex(nums[i - indexDiff]));
            }
        }
        return false;
    }
    long getIndex(long u) {
        return u >= 0 ? u / size : ((u + 1) / size) -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }