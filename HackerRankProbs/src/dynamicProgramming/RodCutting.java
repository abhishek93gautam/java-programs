package dynamicProgramming;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,5,8,9,10};
		int length = 2;
		
		System.out.print(RodCuttingBottomUpDpHelper(arr, length));

	}
	static int RodCuttingBruteForce(int[] arr,int length)
	{
		if(length==0) {
			return 0;
		}
		
		int maxlength = 0;
		for(int i=1;i<=length;i++)
		{
			maxlength = Math.max(maxlength, arr[i-1] + RodCuttingBruteForce(arr,length-i));
			
		}
		return maxlength;
	}
	
	static int RodCuttingTopDownDp(int[] arr,int length)
	{
		int[] dp=new int[length+1];
		dp[length]=RodCuttingTopDownDpHelper(arr,length,dp);
		return dp[length];
	}
	
	static int RodCuttingTopDownDpHelper(int[] arr,int length,int[] dp)
	{
		if(length==0)
		{
			return 0;
		}
		if(dp[length]>0)
		{
			return dp[length];
		}
		
		for(int i=1;i<=length;i++)
		{
			dp[length]=Math.max(dp[length], arr[i-1]+RodCuttingTopDownDpHelper(arr,length-i,dp));
		}
		
		return dp[length];
	}
	
	static int RodCuttingBottomUpDpHelper(int[] arr,int length)
	{
		int[] dp=new int[length+1];
		
		for(int i=1;i<dp.length;i++)
		{
			int maxValue=0;
			for(int j=0;j<i;j++)
			{
				maxValue=Math.max(maxValue, arr[i-j-1]+dp[j]);
			}
			
			dp[i]=maxValue;
			
		}
		
		return dp[length];
	}

}
