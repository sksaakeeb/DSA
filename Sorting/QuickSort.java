package Sorting;

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // set the last element as the pivot
        int i = low - 1; // initialize the pointer for the smaller element

        for (int j = 0; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap the current element with the element at the smaller element index
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;

        // swap the pivot element with the element at the smaller element index
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i; // return the pivot index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // partition the array and get the pivot

            quickSort(arr, low, pivot-1);  // Sort the left half
            quickSort(arr, pivot+1, low);  // Sort the right half
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
