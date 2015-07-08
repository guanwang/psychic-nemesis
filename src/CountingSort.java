/**
 * -----------------------------------------------------------------------
 *     Copyright (C) 2013  All rights reserved.
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
  
        int z = 0;
        for (int k = 0; k < c.length; k++) {
            int y = c[k];
            while(y>0) {
                b[z++] = k;
                y--;       
            }
        }

        return b;
    }
}
