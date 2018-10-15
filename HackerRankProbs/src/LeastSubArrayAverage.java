import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeastSubArrayAverage {

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
		int k = Integer.parseInt(br.readLine());
		
		int res_index = 0;
		int min_sum = 0;
		int curr_sum = 0;
		for(int i=0;i<k;i++)
		{
			curr_sum +=arr[i];
		}
		min_sum = curr_sum;
		
		for(int i=k;i<n;i++)
		{
			curr_sum= curr_sum+arr[i] - arr[i-k];
			if(curr_sum<min_sum)
			{
				res_index = i-k+1;
			}
		}
		for(int j=res_index;j<=res_index+k-1;j++)
		{
			System.out.print(arr[j]+" ");
		}
	}

}
