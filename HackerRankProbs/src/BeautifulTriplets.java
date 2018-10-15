import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class BeautifulTriplets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);
        //int result = 1;
        //int result = BinarySearch(arr, 0, arr.length-1, 20);
        System.out.print(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
	}
	 // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
    	int count = 0;
    	int start =0;
		int end = arr.length-1;
    	for(int i=0;i<arr.length;i++)
    	{
    		
    		if(BinarySearch(arr,start, end, arr[i]+d)!=-1 && BinarySearch(arr,start, end, arr[i]+2*d)!=-1)
    		{
    			count++;
    		}
    	}
    	return count;
    }
    
    static int BinarySearch(int[] arr,int start,int end,int target)
    {
    	while(start<=end)
    	{
    		int mid = start + (end-start)/2;
    		if(arr[mid]==target)
    		{
    			return mid;
    		}
    		else if(arr[mid]<target)
    		{
    			start = mid+1;
    		}
    		else {
    			end = mid-1;
    		}
    		
    	}
    	return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);
}
