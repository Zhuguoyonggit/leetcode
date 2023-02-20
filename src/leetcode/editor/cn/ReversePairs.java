  //给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 398 👎 0

  
  package leetcode.editor.cn;
  public class ReversePairs{
      public static void main(String[] args) {
           Solution solution = new ReversePairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }
    public int process(int[] nums, int l, int r){
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r) + merge(nums, l, r, mid);
    }
    public int merge(int[] nums, int l, int r, int mid){
        int res = 0;
        int win = mid + 1;
        // 从左往右面数
        for (int i = l; i <= mid; i++) {
            while (win <= r && (long) nums[i] > (long) 2 * nums[win]) {
                win++;
            }
            res += win - mid - 1;
        }
        // 进行排序
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l++] = help[j];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }