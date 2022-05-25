package SortingExamples;

public class SortingExamples {

    static void bubbleSort(int arr[])
    {
        int count = 0;
        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            int n = arr.length;
            for(int i = 0; i < n-1; i++) {
                for (int j = 0; j < n - i - 1; j++)
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        needIteration = true;
                        count++;
                        showArray(arr);
                    }
            }
        }
        System.out.println("The number of permutations is " + count);
    }

    static void insertionSort(int arr[])
    {
        int count=0;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int keyItem = arr[i];
            System.out.println(keyItem);
            int j = i - 1;
            while(j >= 0 && arr[j] > keyItem) {
                arr[j + 1] = arr[j];
                j = j - 1;
                count++;
                showArray(arr);
            }
            arr[j + 1] = keyItem;
            showArray(arr);
        }
        System.out.println("The number of permutations is " + count);
    }

    static void selectionSort(int arr[])
    {
        int count=0;
        int n = arr.length;
        for(int i = 0; i < n-1; i++)
        {
            int min = i;
            for(int j = i+1; j < n; j++)
                if(arr[j] < arr[min])
                    min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            count++;
        }
        System.out.println("The number of permutations is " + count);
    }

    static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {// Build max heap
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) { // Heap sort
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);// Heapify root element to get highest element at root again
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int mean = (left + right) / 2;
            mergeSort(arr, left, mean);
            mergeSort(arr, mean+1, right);
            merge(arr, left, mean, right);
        }
    }

    private static void merge(int[] items, int left, int mean, int right)
    {
        int leftSize = mean - left + 1;
        int rightSize = right - mean;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = items[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = items[mean + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = left;

        // Until we reach the end of either leftArr or rightArr, pick larger among
        // elements leftArr and rightArr and place them in the correct position at
        //items[left..right]
        while(i < leftSize && j < rightSize)
        {
            if (leftArr[i] <= rightArr[j]) {
                items[k] = leftArr[i];
                i++;
            } else {
                items[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            items[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            items[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int keyIndex = partition(arr, left, right);
            quickSort(arr, left, keyIndex - 1);// Sort the elements on the left of a key element
            quickSort(arr, keyIndex + 1, right);// Sort the elements on the right of a key element
        }
    }

    private static int partition(int[] items, int left, int right)
    {
        int key = items[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (items[j] <= key) {
                i++;
                int temp = items[i];
                items[i] = items[j];
                items[j] = temp;
            }
        }
        int temp = items[i + 1];
        items[i + 1] = items[right];
        items[right] = temp;
        return (i + 1);
    }

    static void showArray(int[] arr)
    {
        for(int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String []args) {
        int[] libraryNum = {124,235,456,123,756,476,285,998,379,108};
        System.out.println("Initial array");
        showArray(libraryNum);
//        bubbleSort(libraryNum);
//        insertionSort(libraryNum);
//        selectionSort(libraryNum);
//        heapSort(libraryNum);
//        mergeSort(libraryNum);
//        quickSort(libraryNum);

        System.out.println("Sorted array");
        showArray(libraryNum);
    }
}
