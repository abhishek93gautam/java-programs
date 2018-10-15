package RecursionAndDP;

public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(CountTripleStep(3));

	}
	
	public static int CountTripleStep(int n)
	{
		if(n==0)
		{
			return 1;
		}
		
		if(n<0)
		{
			return 0;
		}
		
		return CountTripleStep(n-1)+CountTripleStep(n-2)+CountTripleStep(n-3);
	}
	
	public static int CountTripleStepTopDownDp(int n)
	{
		int[] dp = new int[n+1];
		CountTripleStepTopDownDpHelper(n, dp);
		return dp[n];
	}
	
	public static int CountTripleStepTopDownDpHelper(int n,int[] dp)
	{
		if(n==0)
		{
			return 1;
		}
		
		if(n<0)
		{
			return 0;
		}
		
		if(dp[n]==0)
		{
			dp[n]=CountTripleStepTopDownDpHelper(n-1, dp)+CountTripleStepTopDownDpHelper(n-2, dp)+CountTripleStepTopDownDpHelper(n-3, dp);
		}
		
		return dp[n];
	}
	
	public static int CountTripleStepBottomUp(int n)
	{
		int[] dp=new int[n+1];
		dp[0]=1;
		//dp[1]=1;
		for(int i=1;i<=n;i++)
		{
			dp[i] = ((i-1)>=0 ? dp[i-1]:0) + ((i-2)>=0 ? dp[i-2]:0) + ((i-3)>=0 ? dp[i-3]:0);
		}
		
		return dp[n];
	}

}
