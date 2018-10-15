package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DefenseOfAKingdom {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s");
		int w = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);
		
		int[] x_array=new int[n];
		int[] y_array=new int[n];
		for(int i=0;i<n;i++)
		{
			String[] str = br.readLine().split("\\s");
			x_array[i]=Integer.parseInt(str[0]);
			y_array[i]=Integer.parseInt(str[1]);
		}
		
		Arrays.sort(x_array);
		Arrays.sort(y_array);
		
		int dx = x_array[0];
		int dy = y_array[0];
		
		for(int i=1;i<n;i++)
		{
			dx = Math.max(dx, x_array[i]-x_array[i-1]);
			dy = Math.max(dy, y_array[i]-y_array[i-1]);
		}
		
		dx = Math.max(dx, w+1- x_array[n-1]);
		dy = Math.max(dy, h+1- y_array[n-1]);
		
		System.out.print((dx-1)*(dy-1));
	}

}
