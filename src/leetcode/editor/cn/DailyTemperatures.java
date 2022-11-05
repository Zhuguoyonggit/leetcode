  //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1338 👎 0

  
  package leetcode.editor.cn;

  import java.util.Deque;
  import java.util.LinkedList;

  public class DailyTemperatures{
      public static void main(String[] args) {
           Solution solution = new DailyTemperatures().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈，左边或右边第一个大于或小于的情况
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int[] results = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                // temperatures[i] > temperatures[stack.peek()] 这是一个终止条件肯定是要加的
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    results[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }