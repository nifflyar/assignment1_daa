package assignment1;

public class MergeSort {

    private static final int CUT_OFF = 18;
    
    private static void merge(int[] a, int[] buffer, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            buffer[i] = a[i];
        }

        int i = left;    
        int j = mid + 1; 
        int k = left;   

        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                a[k++] = buffer[i++];
            } else {
                a[k++] = buffer[j++];
            }
        }

        while (i <= mid) {
            a[k++] = buffer[i++];
        }
        while (j <= right) {
            a[k++] = buffer[j++];
        }
    }


    private static void mergeSort(int[] a, int[] buffer, int left, int right) {

        if (right - left + 1 <= CUT_OFF) {
            insertionSort(a, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(a, buffer, left, mid);      
        mergeSort(a, buffer, mid + 1, right);
        merge(a, buffer, left, mid, right);
    }


    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= left && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }


    public static void sort(int[] nums){
        int[] buffer = new int[nums.length];
        mergeSort(nums, buffer, 0, nums.length-1);
    }


}
