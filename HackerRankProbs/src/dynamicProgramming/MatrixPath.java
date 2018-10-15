package dynamicProgramming;

public class MatrixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= new int[][]{{-1,2,3},{4,5,-6},{7,8,9}};
		System.out.print(BottomUpMaxPath(arr));
	}
	public static int topDownMaxPath(int[][] arr)
	{
		int[][][] dp =new int[arr.length][arr[0].length][2];
		
		//we will indicate that a value is unset by setting the max to be less than min.
		//if they are set then max should atleast be equal to min
		for(int i=0;i<dp.length;i++)
		{
			for(int j=0;j<dp[0].length;j++)
			{
				dp[i][j][0]= -1;
			}
		}
		
		int[] result=topDownMaxPathHelper(arr,0,0,dp);
		return result[0];
	}
	static int[] topDownMaxPathHelper(int[][] arr,int i,int j,int[][][] dp)
	{
		if(i==arr.length || j==arr[0].length)
		{
			return null;
		}
		
		//Unset if max is less than min
		if(dp[i][j][0] < dp[i][j][1])
		{
			int[] down= topDownMaxPathHelper(arr,i+1,j,dp);
			int[] right=topDownMaxPathHelper(arr,i,j+1,dp);
			
			if(down==null && right==null) {
				return new int[] {arr[i][j],arr[i][j]};
			}
			
			int max=Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			if(down!=null)
			{
				max=Math.max(max, Math.max(arr[i][j]*down[0], arr[i][j]*down[1]));
				min=Math.min(min, Math.min(arr[i][j]*down[0], arr[i][j]*down[1]));
			}
			
			if(right!=null)
			{
				max=Math.max(max, Math.max(arr[i][j]*right[0], arr[i][j]*right[1]));
				min=Math.min(min, Math.min(arr[i][j]*right[0], arr[i][j]*right[1]));
			}
			dp[i][j][0]=max;
			dp[i][j][1]=min;
		}
		
		return new int[] {dp[i][j][0],dp[i][j][1]};
		
		
	}
	
	static int BottomUpMaxPath(int[][] arr)
	{
		int[][][] dp = new int[arr.length][arr[0].length][2];
		
		for(int i=0;i<dp.length;i++)
		{
			for(int j=0;j<dp[0].length;j++)
			{
				//Base case 
				if(i==0 && j==0)
				{
					dp[i][j][0]=arr[i][j];
					dp[i][j][1]=arr[i][j];
					continue;
				}
				
				int min = Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				
				if(i!=0)
				{
					max=Math.max(max, Math.max(arr[i][j]*dp[i-1][j][0], arr[i][j]*dp[i-1][j][1]));
					min=Math.min(min, Math.min(arr[i][j]*dp[i-1][j][0], arr[i][j]*dp[i-1][j][1]));
				}
				
				if(j!=0)
				{
					max=Math.max(max, Math.max(arr[i][j]*dp[i][j-1][0], arr[i][j]*dp[i][j-1][1]));
					min=Math.min(min, Math.min(arr[i][j]*dp[i][j-1][0], arr[i][j]*dp[i][j-1][1]));
				}
				
				dp[i][j][0]=max;
				dp[i][j][1]=min;
			}
			
			
		}
		return dp[arr.length-1][arr[0].length-1][0];
	}
}
