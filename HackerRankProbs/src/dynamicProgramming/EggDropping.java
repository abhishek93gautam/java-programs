package dynamicProgramming;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(EggDropBottomUp(2, 10));
	}
	
	public static int BruteForceEggDrop(int eggs,int floors)
	{
		if(floors==0)
		{
			return 0;
		}
		if(floors==1)
		{
			return 1;
		}
		if(eggs==1)
		{
			return floors;
		}
		
		int maxDrops=Integer.MAX_VALUE;
		for(int i=1;i<=floors;i++)
		{
			int breaks = BruteForceEggDrop(eggs-1, i-1);
			int doesntBreak = BruteForceEggDrop(eggs, floors-i);
			
			maxDrops = Math.min(maxDrops, Math.max(breaks, doesntBreak));
		}
		return maxDrops+1;
		
	}
	
	public static int TopDownEggDrop(int eggs,int floors)
	{
		int[][] dp=new int[eggs+1][floors+1];
		return TopDownEggDropHelper(eggs,floors,dp);
	}
	
	public static int TopDownEggDropHelper(int eggs,int floors,int[][] dp)
	{
		if(floors==0)
		{
			return 0;
		}
		if(floors==1)
		{
			return 1;
		}
		if(eggs==1)
		{
			return floors;
		}
		
		if(dp[eggs][floors]==0)
		{
			int maxDrops=Integer.MAX_VALUE;
			for(int i=1;i<=floors;i++)
			{
				int breaks = TopDownEggDropHelper(eggs-1, i-1,dp);
				int dontBreak = TopDownEggDropHelper(eggs, floors-i, dp);
				maxDrops=Math.min(maxDrops, Math.max(breaks, dontBreak));
			}
			dp[eggs][floors]=maxDrops+1;
		}
		return dp[eggs][floors];
	}
	
	public static int EggDropBottomUp(int eggs,int floors)
	{
		int[][] dp=new int[eggs+1][floors+1];
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				if(j==1)
				{
					dp[i][j]=1;
				}
				else if(i==1)
				{
					dp[i][j]=j;
				}
				else {
					int maxDrops=Integer.MAX_VALUE;
					for(int k=1;k<=j;k++)
					{
						int breaks= dp[i-1][k-1];
						int dontBreak = dp[i][j-k];
						maxDrops=Math.min(maxDrops, Math.max(breaks, dontBreak));
					}
					
					
					dp[i][j]=maxDrops+1;
				}
			}
		}
		return dp[eggs][floors];
	}

}
