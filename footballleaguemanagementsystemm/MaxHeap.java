package footballleaguemanagementsystemm;

public class MaxHeap {

    public final int maxSize;
    public final int[] heap;
    public int currentSize;

    public MaxHeap(int maxSize) {
        this.heap = new int[maxSize];
        this.currentSize = -1;
        this.maxSize = maxSize;
    }

    // returns the index of the parent node
    public int parent(int i) {
        return (i - 1) / 2;
    }

    // return the index of the left child 
    public int leftChild(int i) {
        return 2 * i + 1;
    }

    // return the index of the right child 
    public int rightChild(int i) {
        return 2 * i + 2;
    }

    // insert the item at the appropriate position
    public void insert(int data) {
        if (currentSize == maxSize - 1) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        // First, insert the item at the last position of the array 
        // and move it up
        currentSize++;
        this.heap[currentSize] = data;
        int temp;

        // Move up until the heap property satisfies
        int currentIndex = currentSize;

        while (currentIndex > 0 && this.heap[this.parent(currentIndex)] < this.heap[currentIndex]) {
            temp = heap[currentIndex];
            heap[currentIndex] = heap[parent(currentIndex)];
            heap[parent(currentIndex)] = temp;
            currentIndex = this.parent(currentIndex);
        }
    }

    // Moves the item at position i of the array 
    // into its appropriate position
    public void maxHeapify(int i) {
        // Find left child node
        int left = this.leftChild(i);

        // Find right child node
        int right = this.rightChild(i);

        // Find the largest among 3 nodes
        int largest = i;

        // Check if the left node is larger than the current node
        if (left <= currentSize && heap[left] > heap[largest]) {
            largest = left;
        }

        // Check if the right node is larger than the current node 
        // or left node
        if (right <= currentSize && heap[right] > heap[largest]) {
            largest = right;
        }

        // Swap the largest node with the current node 
        // and repeat this process until the current node is larger 
        // than the right and the left node
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    // Returns the maximum item of the heap
    public int getMax() {
        return heap[0];
    }

    // Deletes the max item and returns it
    public int extractMax() {
        if (currentSize < 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }

        int maxItem = this.heap[0];

        // Replace the first item with the last item
        this.heap[0] = this.heap[currentSize];
        currentSize = currentSize - 1;

        // Maintain the heap property by heapifying the 
        // first item
        maxHeapify(0);
        return maxItem;
    }

    // Prints the heap
    public void printHeap() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
