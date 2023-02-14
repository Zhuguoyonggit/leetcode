  //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 743 👎 0

  
  package leetcode.editor.cn;
  public class SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int m, n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int a = 0;
        int b = n - 1;
        while (check(a, b) && matrix[a][b] != target) {
            if (matrix[a][b] > target) {
                b--;
            } else {
                a++;
            }
        }
        // 注意这里也要进行检查
        return check(a, b) && matrix[a][b] == target;
    }

  boolean check(int x, int y) {
      return x >= 0 && x < m && y >= 0 && y < n;
  }

}
//leetcode submit region end(Prohibit modification and deletion)

  }