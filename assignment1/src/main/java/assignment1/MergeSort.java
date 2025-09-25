package assignment1;

import assignment1.util.Utils;

public class MergeSort {

    private static final int CUT_OFF = 18;

    private static void merge(int[] a, int[] buffer, int left, int mid, int right) {
        Utils.guardNotNull(a);
        Utils.guardRange(a, left, right);

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
            Utils.insertionSort(a, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(a, buffer, left, mid);
        mergeSort(a, buffer, mid + 1, right);
        merge(a, buffer, left, mid, right);
    }

    public static void sort(int[] nums) {
        Utils.guardNotNull(nums);
        if (nums.length <= 1) return;

        int[] buffer = new int[nums.length];
        mergeSort(nums, buffer, 0, nums.length - 1);
    }
}