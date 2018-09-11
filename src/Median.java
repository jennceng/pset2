/*
 * Median.java
 *
 * Starter code by Computer Science E-22 Staff
 *
 * Modifed by:      <your name>, <your e-mail address>
 * Date modified:   <current date>
 */

import java.util.Arrays;

public class Median {
    /*
     * swap - swap the values of the array elements at
     * position a and position b of the array to which arr refers.
     * Used by the partition method below.
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /* partition - helper method for your recursive median-finding method */
    private static int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1;  // index going left to right
        int j = last + 1;   // index going right to left

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j)
                swap(arr, i, j);
            else
                return j;   // index of last element in the left subarray
        }
    }

    /*
     * findMedian - "wrapper" method for your recursive median-finding method.
     * It just makes the initial call to that method, passing it
     * whatever initial parameters make sense.
     */
    public static void findMedian(int[] arr) {
        int medianIndexMin = (arr.length - 1) / 2;
        int medianIndexMax = arr.length % 2 == 1 ? medianIndexMin : medianIndexMin + 1;

        fMedian(arr, 0, arr.length - 1, medianIndexMin, medianIndexMax);
    }

    /*
     * Put the definition of your recursive median-finding method below.
     */

    private static void fMedian(int[] arr, int first, int last, int medianIndexMin, int medianIndexMax) {
        if(first > medianIndexMax || last < medianIndexMin) {
            return;
        }
        int split = partition(arr, first, last);
        if (first < split)
            fMedian(arr, first, split,  medianIndexMin, medianIndexMax); // left subarray
        if (last > split + 1)
            fMedian(arr, split + 1, last,  medianIndexMin, medianIndexMax); // right subarray
    }


    public static void main(String[] args) {
        // the median of this array is 15
        int[] oddLength = {4, 18, 12, 34, 7, 42, 15, 22, 5};
        int[] oddLengthTwo = {7, 5, 5, 13, 12, 27, 26};

        // the median of this array is the average of 15 and 18 = 16.5
        int[] evenLength = {4, 18, 12, 34, 7, 42, 15, 22, 5, 27};

//        findMedian(oddLength);
//        System.out.println(Arrays.toString(oddLength));
//
//        findMedian(oddLengthTwo);
//        System.out.println(Arrays.toString(oddLengthTwo));
        /* Put code to test your method here. */
        findMedian(evenLength);
        System.out.println(Arrays.toString(evenLength));


    }
}
