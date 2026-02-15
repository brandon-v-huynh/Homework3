public class CustomerSurvey {

    // helper swap method
    public static void swap(WordFreq[] arr, int a, int b) {
        WordFreq temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    } 
    
    // 
    public static void maxHeapify(WordFreq[] arr, int i) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int largest = i;

        if (left < arr.length && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }

        if (right < arr.length && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
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
        customerSurvey[8] = new WordFreq("would reccomend to friends", 800);
        customerSurvey[9] = new WordFreq("visit the store", 700);

        for (int i = 0; i < customerSurvey.length; i++) {
            System.out.print(customerSurvey[i].word + " : " + customerSurvey[i].frequency);
        }
    }
}
