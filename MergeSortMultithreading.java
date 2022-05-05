import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class MergeSortMultithreading extends RecursiveAction {

    private int[] arr_origin;
    private int l, r;


    MergeSortMultithreading(int[] arr, int l, int r) {
        this.arr_origin = arr;
        this.l = l;
        this.r = r;


    }

    @Override
    protected void compute() {

        if (l < r) {
            int middle = l + (r - l) / 2;


            MergeSortMultithreading leftTask = new MergeSortMultithreading(arr_origin, l, middle);
            MergeSortMultithreading rightTask = new MergeSortMultithreading(arr_origin, middle + 1, r);


            invokeAll(leftTask, rightTask);

            merge(arr_origin, l, r);

        }


    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int r) {


            // Find the middle point
            int m = l + (r - l) / 2;


            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];

            /*Copy data to temp arrays*/
            for (int i = 0; i < n1; i++)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; j++)
                R[j] = arr[m + 1 + j];

            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }


    }


    // Driver code
    public static void main(String args[]) {
        int[] arr = {17, 19, 65, 54, 57, 24, 64, 95, 82, 12, 32, 63, 22, 10, 1, 2, 8};

        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Start the thread in fork
        pool.invoke(new MergeSortMultithreading(arr, 0, arr.length - 1));



        System.out.print(Arrays.toString(arr));
        }
    }


//1 2 8 10 12 17 19 22 24 32 54 57 63 64 65 82 95





