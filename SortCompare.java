import java.util.concurrent.ForkJoinPool;
import java.util.Random;

public class SortCompare {

    //function that 1. test threshould 2.if greater than 100, use single thread quicksort else use insertion sort
    static void completeProgram_single(int[] arr) {

        int threshold = 100;

        if (arr.length > threshold) {
            System.out.println("\nOver 100 elements, singlethreading quicksort implement:");
            QuickSortSingleThreading qs = new QuickSortSingleThreading();
            qs.quickSort(arr, 0, arr.length - 1);



        } else {
            System.out.println("\nWithin 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }
    }

    //function that 1. test threshould 2.if greater than 100, use multi-thread quicksort else use insertion sort
    static void completeProgram_multi(int[] arr) {

        int threshold = 100;

        if (arr.length > threshold) {
            System.out.println("\n\nOver 100 elements, mutithreading quicksort implement:");
            ForkJoinPool pool = ForkJoinPool.commonPool();
            // Start the thread in fork
            pool.invoke(new QuickSortMutliThreading(0, arr.length - 1, arr));

        } else {
            System.out.println("\n\nWithin 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }
    }


    // the main function that can compare multi and single threading in quicksort
    public static void main(String[] args) throws Exception {
        //test array for singlethreading
        //create array over 100 thresold
        int[] arr_s = new int[120];

        for (int i = 0; i < arr_s.length; i++) {
            arr_s[i] = new Random().nextInt(80);
        }

        //test array for multithreading
        //create array over 100 thresold
        int[] arr_m = new int[105];
        for (int i = 0; i < arr_m.length; i++) {
            arr_m[i] = new Random().nextInt(80);
        }

        //call singlethreading quicksort if threshold>100

        completeProgram_single(arr_s);
        for (int i = 0; i < arr_s.length; i++) {
            System.out.print(arr_s[i] + " ");
        }

        //call multithreading quicksort if threshold>100
        completeProgram_multi(arr_m);
        for (int i = 0; i < arr_m.length; i++) {
            System.out.print(arr_m[i] + " ");
        }
    }
}

















//


