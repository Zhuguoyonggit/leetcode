package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HeapGreater<T> {

    private int heapSize;
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> comp) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comp = comp;
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T o) {
        heap.add(o);
        indexMap.put(o, heapSize++);
        heapInsert(heapSize);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void resign(T o) {
        // 这时候是不知道是往上还是往下移动的
        heapInsert(indexMap.get(o));
        heapify(indexMap.get(o));
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int most = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(index)) < 0 ? (left + 1) : left;
            most = comp.compare(heap.get(most), heap.get(index)) < 0 ? most : index;
            if (index == most) {
                break;
            }
            swap(index, most);
            left = 2 * index + 1;
        }
    }

    private void swap(int o1, int o2) {
        T i = heap.get(o1);
        T j = heap.get(o2);
        heap.set(o1, j);
        heap.set(o2, i);
        indexMap.put(i, o2);
        indexMap.put(j, o1);
    }
}
