public class CustomerSurvey {

    // helper swap method for two elements in the array
    public static void swap(WordFreq[] arr, int a, int b) {
        WordFreq temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    } 
    
    // max-heap property, node value greater than childrens'
    public static void maxHeapify(WordFreq[] arr, int i) {
        int left = (2 * i) + 1;     // left child
        int right = (2 * i) + 2;    // right child
        int largest = i;

        // check if left child is larger than root
        if (left < arr.length && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        // check if right child is larger than current largest
        if (right < arr.length && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        // swap if largest isn't root, recursively call heapify
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    // builds max-heap (bottom-up)
    public static void buildMaxHeap(WordFreq[] arr) {
        // start at last non-leaf node, since leaf nodes are already max heaps
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    public static void main(String[] args) {
        WordFreq[] customerSurvey = new WordFreq[10];

        customerSurvey[0] = new WordFreq("happy", 400);
        customerSurvey[1] = new WordFreq("satisfied", 100);
        customerSurvey[2] = new WordFreq("neutral", 300);
        customerSurvey[3] = new WordFreq("would buy again", 200);
        customerSurvey[4] = new WordFreq("terrible", 160);
        customerSurvey[5] = new WordFreq("inconvient", 900);
        customerSurvey[6] = new WordFreq("difficult to use", 100);
        customerSurvey[7] = new WordFreq("easy to use", 140);
        customerSurvey[8] = new WordFreq("would recommend to friends", 800);
        customerSurvey[9] = new WordFreq("visit the store", 700);

        buildMaxHeap(customerSurvey);

        for (int i = 0; i < customerSurvey.length; i++) {
            System.out.println(customerSurvey[i].word + " : " + customerSurvey[i].frequency);
        }
    }
}
