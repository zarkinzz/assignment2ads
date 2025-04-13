package models;

import interfaces.MyList;

public class MyMinHeap {
    private MyList<Integer> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public int peekMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) >= heap.get(parent)) break;
            swap(i, parent);
            i = parent;
        }
    }

    private void heapifyDown(int i) {
        int size = heap.size();
        while (i < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < size && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}

