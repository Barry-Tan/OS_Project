/** 1. test threshould :
 *      a. if less than 100, use insertion sort
 *      b. if greater than 100, use quickSort and mergeSort
 *  2. compare execution time between single threading and multithreading sorting (for both quickSort and mergeSort)
 *
 */


import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.Random;

public class SortCompare {

    //function that

    /**
     *  test threshould 2.if greater than 100, use single thread sorting else use insertion sort
     * @param arr
     */
    static void completeProgram_single(int[] arr) {

        int threshold = 100;

        int[] arr_c = arr.clone();

        if (arr.length > threshold) {
            System.out.println("\nOver 100 elements, singlethreading quicksort implement:");
            QuickSortSingleThreading qs = new QuickSortSingleThreading();
            qs.quickSort(arr, 0, arr.length - 1);
            printArray(arr);

            System.out.println("\nOver 100 elements, singlethreading mergesort implement:");
            MergeSortSingleThreading ms = new MergeSortSingleThreading();
            ms.sort(arr_c,0,arr_c.length-1);
            printArray(arr);


        } else {
            System.out.println("\nWithin 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }
    }

    /**
     * 1. test threshould 2.if greater than 100, use multi-thread sorting else use insertion sort
     * @param arr
     */
    static void completeProgram_multi(int[] arr) {

        int threshold = 100;
        int[] arr_c = arr.clone();

        if (arr.length > threshold) {
            System.out.println("\n\nOver 100 elements, mutithreading quicksort implement:");
            ForkJoinPool pool = ForkJoinPool.commonPool();
            // Start the thread in fork
            pool.invoke(new QuickSortMutliThreading(0, arr.length - 1, arr));
            printArray(arr);


            System.out.println("\n\nOver 100 elements, mutithreading mergesort implement:");
            ForkJoinPool pool1 = ForkJoinPool.commonPool();
            pool1.invoke(new MergeSortMultithreading(arr_c, 0, arr_c.length-1));
            printArray(arr_c);


        } else {
            System.out.println("\n\nWithin 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }
    }


    public static void printArray( int[] arr){
        if(arr != null)              System.out.println(Arrays.toString(arr));
    }


    // the main function that can

    /**
     * 1. verify and compare result from multi and single threading in quicksort and mergesort
     * 2. compare execution time between single and multi threading in
     *          a. quick sort
     *          b. merge sort
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //test array for singlethreading,multithreading
        //create array over 100 threshold
        //call quick sort and merge sort if threshold>100

        int[] arr1 = new int[120];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Random().nextInt(80);
        }
        completeProgram_single(arr1);
        completeProgram_multi(arr1);




        //test array for multithreading
        //create array over 100 threshold
        int[] arr_m = new int[105];
        for (int i = 0; i < arr_m.length; i++) {
            arr_m[i] = new Random().nextInt(80);
        }




    }
}

















//


