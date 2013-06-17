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
public class MaxSubArray {

    public static void main(final String[] args) {
        final int[] array = new int[] { 6, -5, -5, 3, -2, 6, -1, -3, 3, 1, -2 };
        final MaxSubArray max = new MaxSubArray();

        System.out.println("Total value of max sub array is " + max.maxSubArray(array));
        for (final int i : array) {
            System.out.print(i + " ");
        }
    }

    private String maxSubArray(final int[] array) {
        int sum = 0;
        int maxSum = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                end = i;

            }
        }
        return maxSum + ":" + end;
    }
}
