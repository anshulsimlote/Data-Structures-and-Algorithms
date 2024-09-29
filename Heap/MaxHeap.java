package Heap;

public class MaxHeap {
    private Integer[] heap; // Array representation of the heap
    private int n; // Keeps track of the number of elements in the heap

    public MaxHeap(int capacity) {
        heap = new Integer[capacity + 1]; // Initializing the heap with given capacity + 1 for 1-based index
        n = 0; // Heap starts empty
    }

    public boolean isEmpty() {
        return n == 0; // Returns true if the heap is empty
    }

    public int size() {
        return n; // Returns the number of elements in the heap
    }

    // Resize the heap array if it's full
    private void resize(int capacity) {
        Integer[] newHeap = new Integer[capacity];
        System.arraycopy(heap, 0, newHeap, 0, n + 1);
        heap = newHeap;
    }

    public void insert(int data){
        if(n == heap.length - 1){ // If heap is full, resize the array
            resize(2 * heap.length);
        }
        heap[++n] = data;
        swim(n);
    }

    // Swim method to maintain heap order when inserting elements
    public void swim(int k){
        while(k > 1 && heap[k/2] < heap[k]) {
            swap(k, k / 2); // Swap child with its parent
            k = k / 2; // Move up to the parent
        }
    }

    public int deleteMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[1]; // The root is the maximum
        swap(1, n--); // Swap the root with the last element
        sink(1); // Restore heap order
        heap[n + 1] = null; // Prevent loitering
        if(n > 0 && n == (heap.length - 1) / 4) {
            resize(heap.length / 2); // Shrink size of the array if necessary
        }
        return max;
    }

    // Sink method to maintain heap order when deleting elements
    public void sink(int k) {
        while(2 * k <= n) {
            int j = 2 * k; // Left child
            if(j < n && heap[j] < heap[j + 1]) {
                j++; // Choose the larger child
            }
            if(heap[k] >= heap[j]) {
                break; // If parent is larger, stop sinking
            }
            swap(k, j); // Swap parent with the larger child
            k = j; // Move down to the child
        }
    }

    // Swap method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Max Heap:");
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        System.out.println("Size: " + maxHeap.size());
        System.out.println("Max value: " + maxHeap.deleteMax()); // Should return 40
        System.out.println("Max value: " + maxHeap.deleteMax()); // Should return 30
        System.out.println("Max value: " + maxHeap.deleteMax()); // Should return 20
        System.out.println("Max value: " + maxHeap.deleteMax()); // Should return 15
        System.out.println("Max value: " + maxHeap.deleteMax()); // Should return 10
        System.out.println("Is Empty: " + maxHeap.isEmpty());
    }
}
