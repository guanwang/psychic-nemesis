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
public class HeapSort {
    public static void main(final String[] args) {
        final int[] array = new int[] { 10, 13, 24, 3, 6, 1, 0, 43, 6, 11, 12 };
        final HeapSort sort = new HeapSort();
        sort.heapSort(array);
        for (final int i : array) {
            System.out.print(i + " ");
        }
    }

    private void heapSort(final int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);

        }
    }

    private void buildHeap(final int[] array) {
        final int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, i, length);
        }
        //  for (final int i : array) {
        //       System.out.print(i + " ");
        //   }
        //   System.out.println();
    }

    private void heapify(final int[] array, final int pos, final int length) {
        final int leftChild = 2 * pos + 1;
        if (leftChild + 1 > length) {
            return;
        }
        int maxPos = pos;
        if (array[pos] < array[leftChild]) {
            maxPos = leftChild;
        }
        final int rightChild = 2 * pos + 2;
        if (rightChild + 1 > length) {
            maxPos = leftChild;
        } else if (array[maxPos] < array[rightChild]) {
            maxPos = rightChild;
        }
        swap(array, pos, maxPos);
        if (maxPos <= length - 1 && maxPos != pos) {
            heapify(array, maxPos, length);
        }
    }

    private void swap(final int[] array, final int x, final int y) {
        final int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
