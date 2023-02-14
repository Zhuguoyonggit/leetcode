package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Code07_TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList();
            help = new LinkedList();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = help;
            help = queue;
            queue = temp;
            return ans;
        }

        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.peek();
            help.offer(queue.poll());
            Queue<T> temp = help;
            help = queue;
            queue = temp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
