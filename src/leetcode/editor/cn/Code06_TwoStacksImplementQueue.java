package leetcode.editor.cn;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        // 在pop栈中为空时可以从push向pop中倒数据
        public void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int value) {
            stackPush.push(value);
            pushToPop();
        }

        public void poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("队列是空的，需要添加数据");
            }
            pushToPop();
            stackPop.pop();
        }

        public void peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("队列已经空了");
            }
            pushToPop();
            stackPush.peek();
        }
    }
}
