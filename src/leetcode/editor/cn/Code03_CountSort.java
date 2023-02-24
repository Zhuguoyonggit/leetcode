package leetcode.editor.cn;

public class Code03_CountSort {
    // only for 0~200 value
    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 零到max所以要多一位
        int[] ints = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            ints[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (ints[i] > 0) {
                arr[j++] = i;
            }
        }
    }
}
