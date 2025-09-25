package assignment1;
import assignment1.util.Utils;


public class QuickSort {


    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        Utils.shuffle(arr);

        quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            int pivotIndex = Utils.partition(arr, low, high);

            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1);   
                low = pivotIndex + 1;                
            } else {
                quickSort(arr, pivotIndex + 1, high);
                high = pivotIndex - 1;               
            }
        }
    }


    
}
