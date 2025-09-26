package assignment1;

import assignment1.util.Utils;

public class DeterministicSelect {
     public static int select(int[] arr, int k) {
        Utils.guardNotNull(arr);
        Utils.guardRange(arr, 0, k);
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);

        int pivotIndex = Utils.partitionWithPivot(arr, left, right, pivot);

        if (k == pivotIndex) {
            return arr[pivotIndex];
        } else if (k < pivotIndex) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k);
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n < 5) {
            Utils.insertionSort(arr, left, right);
            return arr[left + n/2];
        }

        int numMedians = (int) Math.ceil(n / 5.0);
        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);

            Utils.insertionSort(arr, subLeft, subRight);
            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        return select(medians, 0, numMedians - 1, numMedians / 2);
    }
}
