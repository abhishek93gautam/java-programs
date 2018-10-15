package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexZeroToBeReplaced {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("\\s");
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(str[i]);
		}
		
		int start = 0;
		int end = 0;
		int maxIndex = -1;
		int lastZeroIndex = -1;
		int maxCount = 0;
		
		while(end < n)
		{
			while(end<n && arr[end]==1)
			{
				end++;
			}
			
			// If this not the first zero 
			if(maxCount< end-start && lastZeroIndex!=-1)
			{
				maxCount = end-start;
				maxIndex = lastZeroIndex;
			}
			
			start = lastZeroIndex+1;
			lastZeroIndex = end;
			end++;
		}
		
		if(maxCount< end-start && lastZeroIndex!=-1)
		{
			maxCount = end-start;
			maxIndex = lastZeroIndex;
		}
		
		System.out.print("Max Index: "+maxIndex+" MaxCount: "+maxCount);
	}

}
