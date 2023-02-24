package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 前k个中一定有最小值
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            priorityQueue.add(arr[index]);
        }
        // 处理剩余的部分;
        int i = 0;
        // 比较一次就可以了
        for (; index < arr.length; index++) {
            arr[i] = priorityQueue.poll();
            priorityQueue.add(arr[index]);
            i++;
        }
        for (; i < arr.length; i++) {
            arr[i] = priorityQueue.poll();
        }
    }

}