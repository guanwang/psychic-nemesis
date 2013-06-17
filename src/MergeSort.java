import java.util.Arrays;

/**
 * -----------------------------------------------------------------------
 *     Copyright (C) 2013   All rights reserved.
 * -----------------------------------------------------------------------
 */

/**
 * @author ewanggu
 * @since 2013
 *
 */
public class MergeSort {

    public static void main(final String[] args) {
        final int[] array = new int[] { 10, 13, 24, 3, 6, 1, 0, 43, 6, 11, 12 };
        final MergeSort merge = new MergeSort();
        merge.sort(array);
        for (final int i : array) {
            System.out.print(i + " ");
        }
    }

    public void sort(final int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(final int[] array, final int left, final int right) {
        if (left >= right) {
            return;
        }
        mergeSort(array, left, left + (right - left) / 2);
        mergeSort(array, left + (right - left) / 2 + 1, right);
        merge(array, left, left + (right - left) / 2, right);

    }

    private void merge(final int[] array, final int left, final int middle, final int right) {

        final int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        final int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);
        int i = 0, j = 0;
        int k = left;
        while (i <= leftArray.length - 1 && j <= rightArray.length - 1) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i <= leftArray.length - 1) {
            array[k++] = leftArray[i++];
        }
        while (j <= rightArray.length - 1) {
            array[k++] = rightArray[j++];
        }

    }
}
