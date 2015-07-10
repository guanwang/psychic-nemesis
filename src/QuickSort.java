/**
 * -----------------------------------------------------------------------
 *     Copyright (C) 2013 All rights reserved.
 * -----------------------------------------------------------------------
 */

/**
 * @author ewanggu
 * @since 2013
 *
 */
public class QuickSort {

    public static void main(final String[] args) {
        final int[] array = new int[] { 10, 13, 24, 3, 6, 1, 0, 43, 6, 11, 12 };
        final QuickSort sort = new QuickSort();
        sort.quickSort(array, 0, array.length - 1);
        for (final int i : array) {
            System.out.print(i + " ");
        }
    }

    private void quickSort(final int[] array, final int left, final int right) {
        if (left < right) {
            final int pos = getPartititon(array, left, right);
            quickSort(array, left, pos - 1);
            quickSort(array, pos + 1, right);
        }
    }

    private int getPartititon(final int[] array, final int left, final int right) {
        final int pivot = array[left];
        int i = left;
        int j = right;
        while (i != j) {

            while (array[j] > pivot && i < j) {
                j--;
            }

            if (i < j) {
                array[i++] = array[j];
            }

            while (array[i] < pivot && i < j) {
                i++;
            }

            if (i < j) {
                /*    if (array[i] == array[j]) {
                        i++;
                        continue;
                    }*/
                //swap(array, i, j);
                array[j--] = array[i];
            }

        }
        array[i] = pivot;
        return i;
    }

    private void swap(final int[] array, final int left, final int right) {
        final int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}
