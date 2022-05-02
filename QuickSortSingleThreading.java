
public class QuickSortSingleThreading{

    QuickSortSingleThreading(){}

    public void swap(int[] arr, int v1, int v2){
        int temp = arr[v1];
        arr[v1]=arr[v2];
        arr[v2]=temp;
    }

    /* This function takes closest to center element as pivot, places
   the pivot at its correct position in sorted array, and places all
   smaller to left of pivot and all greater elements to right */
    private int partition(int arr[], int left, int right){
      int i = left, j = right;
//      int pivot = arr[(left + right) / 2]; //assign the center as pivot
        int pivot = arr[left + (right-left) / 2]; //assign the center as pivot


        while (i <= j) {
            while (arr[i] < pivot)
                  i++;

            while (arr[j] > pivot)
                  j--;

            if (i <= j) {
                  swap(arr,i,j);
                  i++;
                  j--;
            }
      };
      return i;
    }

public void quickSort(int arr[], int start, int end) {
      int index = partition(arr, start, end);

      if (start < index - 1)
            quickSort(arr, start, index - 1);

      if (index < end)
            quickSort(arr, index, end);
}
    //Driver Code: testing purpose, not the complete verison
    public static void main(String[] args) throws Exception {
        int[] arr = {17,19,65,54,57,24, 64, 95, 82, 12, 32, 63,22,10,1,2,8 };
        QuickSortSingleThreading q1 = new QuickSortSingleThreading();
        // Print shorted elements
        q1.quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


}

