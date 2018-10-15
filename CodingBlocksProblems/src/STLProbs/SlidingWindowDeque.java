package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SlidingWindowDeque {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		String[] inputString = br.readLine().split("\\s");
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = Integer.parseInt(inputString[i]);
		}
		
		String ks = br.readLine();
		int k = Integer.parseInt(ks);
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		int i=0;
		
		// Set the sliding window for first k elements
		for(i=0;i<k;i++) {
			while(!queue.isEmpty() && array[queue.getLast()] <=array[i])
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}
		
		//Slide window for remaining n-k elements
		
		for(;i<n;i++)
		{
			System.out.print(array[queue.getFirst()]);
			
			while(!queue.isEmpty() && queue.getFirst()<=i-k)
			{
				queue.removeFirst();
			}
			
			while(!queue.isEmpty() && array[queue.getLast()] <=array[i])
			{
				queue.removeLast();
			}
			queue.addLast(i);
		}
		System.out.print(array[queue.getFirst()]+" ");
		
		
	}

}
