package STLProbs;

public class WineAndMaximumPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[] {2,3,5,1,4};
		System.out.println("Top-down dp: "+getMaxPriceTopDown(prices));

		System.out.println("Bottom up dp: "+getMaxPriceBottomUp(prices));

	}
	
	static int getMaxPriceTopDown(int[] prices)
	{
		int[][] dp = new int[prices.length+1][prices.length+1];
		return getMaxPriceTopDownHelper(prices,0,prices.length-1,dp,1);
	}
	
	static int getMaxPriceTopDownHelper(int[] prices,int start,int end,int[][] dp,int year)
	{
		if(start>end)
		{
			return 0;
		}
		
		if(dp[start][end]==0)
		{
			dp[start][end]= Math.max(prices[start]*year+getMaxPriceTopDownHelper(prices,start+1,end,dp,year+1), prices[end]*year + getMaxPriceTopDownHelper(prices,start,end-1,dp,year+1)); 
		}
		
		return dp[start][end];
	}
	
	static int getMaxPriceBottomUp(int[] prices)
	{
		int N = prices.length;
		int[][] dp=new int[N+1][N+1];
		for(int i=N;i>=1;i--)
		{
			for(int j=1;j<=N;j++)
			{
				if(i>j)
				{
					dp[i][j]=0;
				}
				else {
					int year = N-(j-i);
					dp[i][j] = Math.max(prices[i-1]*year + ((i+1<N+1)?dp[i+1][j]:0), prices[j-1]*year + ((j-1>=0)?dp[i][j-1]:0)); 
				}
			}
		}
		
		return dp[1][N];
	}

}
