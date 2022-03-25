package sorts;

/**
 * Insertion sort is a simple sorting algorithm that builds the 
 * final sorted array (or list) one item at a time. It is much 
 * less efficient on large lists than more advanced algorithms 
 * such as quicksort, heapsort, or merge sort.
 * 
 * @link https://en.wikipedia.org/wiki/Insertion_sort
 */
public class InsertionSort {
    /**
    * Insertion sort algorithm implements
    * 
    * @param arr to be sorted
    */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > arr[i]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = temp;
        }
    }

    // Prints the array
    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        insertionSort(arr);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}