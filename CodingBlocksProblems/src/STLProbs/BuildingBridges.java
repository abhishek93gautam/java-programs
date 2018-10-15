package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BuildingBridges {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Points[] points = new Points[n];
		String[] str = br.readLine().split("\\s");
		String[] str1 = br.readLine().split("\\s");
		for(int i=0;i<n;i++)
		{
			points[i] = new Points(Integer.parseInt(str[i]),Integer.parseInt(str1[i]));
		}
		
		Arrays.sort(points);
		
		int res=0;
		int[] dp = new int[n];
		for(int i=0;i<n;i++)
		{
			dp[i]=1;
		}
		
		//Use LIS
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(points[i].second >= points[j].second && dp[i]<dp[j]+1)
				{
					dp[i]=dp[j]+1;
				}
			}
		}
		
		for(int i=0; i<n;i++)
		{
			if(res < dp[i])
			{
				res = dp[i];
			}
		}
		
		System.out.print(res);
	}

}

class Points implements Comparable<Points>
{
	int first;
	int second;
	Points(int first,int second)
	{
		this.first=first;
		this.second = second;
	}
	
	public int compareTo(Points b)
	{
		return this.first - b.first;
	}
}
