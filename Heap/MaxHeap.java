package Heap;

public class MaxHeap {
    private Integer[] heap; // Private access modifier for encapsulation
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

    public static void main(String[] args) {
        System.out.println("Max Heap:");
        MaxHeap maxHp = new MaxHeap(3);
        System.out.println("Size "+maxHp.size());
        System.out.println("Is Empty "+maxHp.isEmpty());
        
    }
}
