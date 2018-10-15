package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumOfAllMinimumRanges {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		String[] inputString = br.readLine().split("\\s");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(inputString[i]);
		}
		
		String ks = br.readLine();
		int k = Integer.parseInt(ks);
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		int i=0;
		//ArrayList<Integer> resultList = new ArrayList<Integer>();
		int max = 0;
		for(i=0;i<k;i++)
		{
			while(!queue.isEmpty() && arr[i] < arr[queue.getLast()])
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}
		max = arr[queue.getFirst()];
		
		for(;i<n;i++)
		{
			while(!queue.isEmpty() && queue.getFirst()<=i-k)
			{
				queue.removeFirst();
			}
			
			while(!queue.isEmpty() && arr[i] < arr[queue.getLast()])
			{
				queue.removeLast();
			}
			
			queue.addLast(i);
			if(max < arr[queue.getFirst()])
			{
				max = arr[queue.getFirst()];
			}
		}
		
		Integer res = max;
		System.out.print(res+" ");
		

	}

}
