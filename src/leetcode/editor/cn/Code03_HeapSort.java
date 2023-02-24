package leetcode.editor.cn;

public class Code03_HeapSort {
    // 堆排序
    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        // 插入成为大根堆的形式
//		for (int i = 0; i < arr.length; i++) {
//			heapInsert(arr, i);
//		}
        // 比插入更优的做法
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        // 将最大的值交换到结尾
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 调整大根堆
            heapify(arr, 0, heapSize);
            // 交换最大值到结尾出
            swap(arr, 0, --heapSize);
        }
        return arr;
    }
    // 根据索引值往上移动
    public static void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            // 求出最大索引
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(heap, index, largest);
        }
    }

    // 交换
    public static void swap(int[] heap, int index, int gold) {
        int temp = heap[index];
        heap[index] = heap[gold];
        heap[gold] = temp;
    }
}
