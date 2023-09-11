class Solution {
     int[] heap;
    int capacity;
    int k;

    public Solution() {
    }

    public Solution(int[] heap, int k) {
        this.heap = heap.clone();
        this.capacity = 0;
        this.k = k;
    }

    public int findKthLargest(int[] nums, int k) {
        Solution maxHeap = new Solution(nums, k);
        for (int num : nums) {
            maxHeap.push(num);
        }

     for (int i = 1; i <= k - 1; i++) {
            maxHeap.pop();
        }
        return maxHeap.pop();
    }

    private void push(int num) {
        if (capacity == heap.length) {
            throw new RuntimeException("push에러");
        }
        heap[capacity] = num;
        bubbleUp(capacity); // Heap의 맨 마지막 요소인 array[n]부터 bubble Up
        capacity++;
    }

    public void bubbleUp(int i) {
        int child = i;
        int parent = (i - 1) / 2;

        if (parent >= 0 && heap[child] > heap[parent]) {
            int tmp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = tmp;
            bubbleUp(parent);
        }
    }

    private int pop() {
        if (capacity == 0) {
            throw new RuntimeException("pop에러");
        }

        int max = heap[0];
        heap[0] = heap[capacity - 1];
        capacity--;

        bubbleDown(0);
        return max;
    }

    private void bubbleDown(int i) {
        int leftChild = i * 2 + 1;
        int rightChild = 2 * i + 2;

        if (leftChild <= capacity - 1) {
            if (rightChild <= capacity - 1 && heap[rightChild] > heap[leftChild]) {
                leftChild = rightChild;
            }

            if (heap[i] < heap[leftChild]) {
                int tmp = heap[i];
                heap[i] = heap[leftChild];
                heap[leftChild] = tmp;
                bubbleDown(leftChild);
            }
        }
    }

    public static void main(String[] args) {
        Solution maxHeap = new Solution();
        System.out.println("maxHeap.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2) = " + maxHeap.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}