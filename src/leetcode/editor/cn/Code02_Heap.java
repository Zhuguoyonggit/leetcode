package leetcode.editor.cn;

public class Code02_Heap {
    public static class MyMaxHeap {
        private final int limit;
        private int[] heap;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("堆已经满了");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        // 移动到无法代替自己的父亲节点或者0的位置
        public void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void swap(int[] heap, int index, int father) {
            int temp = heap[index];
            heap[index] = heap[father];
            heap[father] = temp;
        }

        // 返回最大值，要先弹出零，然后和heapsize进行交换
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        // 从index位置进行下沉，直到较大的孩子没有index大的时候
        public void heapify(int[] heap, int index, int heapSize) {
            int left = index * 2 + 1;
            // 这里的终止条件，使用left和总长度进行比较
            while (left < heapSize) {
                // 找到最大孩子的下标和值
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                largest = heap[index] > heap[largest] ? index : largest;
                // 判断此时的最大值是不是index，如果是的话就可以跳出了
                if (largest == index) {
                    break;
                }
                swap(heap, index, largest);
                index = largest;
                left = 2 * largest + 1;
            }
        }
    }
}
