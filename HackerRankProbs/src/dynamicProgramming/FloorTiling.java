package dynamicProgramming;

public class FloorTiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(floorTilingBottonUp(5));
	}
	
	public static int floorTilingBruteForce(int n)
	{
		if(n==0 || n==1)
		{
			return 1;
		}
		return floorTilingBruteForce(n-1) + floorTilingBruteForce(n-2);
	}
	
	public static int floorTilingTopDownDP(int n)
	{
		int[] dp=new int[n+1];
		return floorTilingHelperTopDown(n,dp);
	
	}
	
	public static int floorTilingHelperTopDown(int n,int[] dp)
	{
		if(n==0 || n==1)
		{
			return 1;
		}
		
		if(dp[n]>0)
		{
			return dp[n];
		}
		dp[n] = floorTilingHelperTopDown(n-1, dp) + floorTilingHelperTopDown(n-2, dp);
		
		return dp[n];
	}
	
	public static int floorTilingBottonUp(int n)
	{
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}
	
}
