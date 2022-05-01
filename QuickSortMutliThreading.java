import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSortMutliThreading
	extends RecursiveAction {

	int start, end;
	int[] arr;

	public QuickSortMutliThreading(int start,int end,int[] arr)
	{
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
    
    public void swap(int[] arr, int v1, int v2){
        int temp = arr[v1];
        arr[v1]=arr[v2];
        arr[v2]=temp;
    }

	private int partition(int start, int end,int[] arr)
	{

		int i = start, j = end;

		// select the middle index as pivote
		int pivote = (i+j)/2;

		// Swap the pivoted with end
		swap(arr,pivote,j);
		j--;

		// partitioning
		while (i <= j) {

			if (arr[i] <= arr[end]) {
				i++;
				continue;
			}

			if (arr[j] >= arr[end]) {
				j--;
				continue;
			}

			swap(arr,i,j);
			j--;
			i++;
		}

		// Swap pivoted to its correct position
		swap(arr, j+1, end);
		return j + 1;
	}


	@Override
	protected void compute()
	{
		if (start < end){
            int p = partition(start, end, arr);

		// Divide array
		    QuickSortMutliThreading leftTask = new QuickSortMutliThreading(start,p - 1,arr);

		    QuickSortMutliThreading rightTask = new QuickSortMutliThreading(p + 1,end,arr);

		// Left subproblem as separate thread
		    leftTask.fork();
		    rightTask.fork();

		// Wait untill left thread complete
		    leftTask.join();
            rightTask.join();
        }
	}

	// Driver Code: testing purpose, not the complete verison
	public static void main(String args[])
	{
		int[] arr = { 17,19,65,54,57,24, 64, 95, 82, 12, 32, 63,22,10,1,2,8 };

		ForkJoinPool pool = ForkJoinPool.commonPool();

		// Start the thread in fork
		pool.invoke(new QuickSortMutliThreading(0, arr.length - 1, arr));

		// Print shorted elements
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
