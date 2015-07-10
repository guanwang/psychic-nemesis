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
        mergeSort(array, 0, array.length);
    }

    public void mergeSort(final int[] array, final int left, final int right) {
        if (left >= right - 1) {
            return;
        }
        mergeSort(array, left, (right + left) / 2);
        mergeSort(array, (right + left) / 2, right);
        merge(array, left, (right + left) / 2, right);

    }

    private void merge(final int[] array, final int left, final int middle, final int right) {

        // final int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        // final int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);
        final int[] tempArray = new int[right - left];
        int i = left, j = middle;
        int k = 0;
        while (i < middle && j < right) {
            if (array[i] < array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }

        while (i < middle) {
            tempArray[k++] = array[i++];
        }
        while (j < right) {
            tempArray[k++] = array[j++];
        }

        for (int z = left; z < right; z++) {
            array[z] = tempArray[z - left];
        }

    }
}
