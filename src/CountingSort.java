/**
 * -----------------------------------------------------------------------
 *     Copyright (C) 2013 LM Ericsson Limited.  All rights reserved.
 * -----------------------------------------------------------------------
 */

/**
 * @author ewanggu
 * @since 2013
 *
 */
public class CountingSort {
    public static void main(final String[] args) {
        final int[] array = new int[] { 10, 13, 24, 3, 6, 1, 0, 43, 6, 11, 12 };
        final CountingSort sort = new CountingSort();
        final int[] sortedArray = sort.countingSort(array);
        for (final int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    private int[] countingSort(final int[] array) {
        final int max = 43;
        final int[] c = new int[max + 1];
        final int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            c[array[i]]++;
        }

        for (int j = 1; j < c.length; j++) {
            c[j] += c[j - 1];
        }

        for (int k = array.length - 1; k >= 0; k--) {
            b[c[array[k]] - 1] = array[k];
            c[array[k]]--;
        }

        return b;
    }
}
