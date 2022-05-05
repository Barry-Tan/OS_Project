public class MergeSortSingleThreading {

    MergeSortSingleThreading(){}

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
        {
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
                }
                else {
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

        // Main function that sorts arr[l..r] using
        // merge()
        void sort(int arr[], int l, int r)
        {
            if (l < r) {
                // Find the middle point
                int m =l+ (r-l)/2;

                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);

                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }



        // Driver code
        public static void main(String args[])
        {
            int[] arr = {17,19,65,54,57,24, 64, 95, 82, 12, 32, 63,22,10,1,2,8 };
            MergeSortSingleThreading m1 = new MergeSortSingleThreading();
            // Print shorted elements
            m1.sort(arr,0,arr.length-1);
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }
        }

     //1 2 8 10 12 17 19 22 24 32 54 57 63 64 65 82 95
    /* This code is contributed by Rajat Mishra */





