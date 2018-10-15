import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTripletsWithSmallerSum {

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
		Arrays.sort(arr);
		
		int sum = Integer.parseInt(br.readLine());
		int result = countTripletsLessThanSum(arr,n,sum);
		
		System.out.print(result);
	}
	
	static int countTripletsLessThanSum(int[] arr,int n,int sum)
	{
		int count=0;
		for(int i=0;i<n-2;i++)
		{
			int j = i+1;
			int k = n-1;
			
			while(j<k)
			{
				if(arr[i]+arr[j]+arr[k]>=sum)
				{
					k--;
				}
				else {
					count += k-j;
					j++;
				}
			}
		}
		return count;
	}

}
