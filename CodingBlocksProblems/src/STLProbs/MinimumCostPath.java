package STLProbs;

public class MinimumCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] calories = new int[][] {{100,100,100},{100,1,100},{100,100,100}};
		
		System.out.println("Rows : "+cost.length+" Columns :"+cost[0].length);
		
		int minCost = minimumCost(cost,3,3);
		
		System.out.println(minCost);
		System.out.println("Number of ways to reach cell "+numWays(3, 3));
		System.out.println("Max Calories burnt by boy and girl combined "+maxCaloriesBurnt(calories));

	}
	
	// Minimum cost to reach the last cell
	static int minimumCost(int[][] cost,int row,int col)
	{
		int[][] dp = new int[cost.length][cost[0].length];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j] = cost[0][0];
				}
				else if(i==0)
				{
					dp[i][j] = dp[0][j-1] + cost[0][j];
				}
				else if(j==0)
				{
					dp[i][j] = dp[i-1][0] + cost[i][0];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + cost[i][j];
				}
				System.out.print(dp[i][j]+" ");
				
			}
			System.out.println();
		}
		
		return dp[row-1][col-1];
	}
	
	// Number of ways to reach a particular cell
	static int numWays(int row,int col)
	{
		int[][] dp=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j] = 1;
				}
				else if(i==0)
				{
					dp[i][j] = 1;
				}
				else if(j==0)
				{
					dp[i][j]=1;
				}
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[row-1][col-1];	
	}
	
	// Maximum calories burnt for boy and girl combined
	static int maxCaloriesBurnt(int[][] calories)
	{
		// 4 matrices - 2 for boy one from 0,0 to i,j and one from row-1,col-1 to i-j, same for girl
		int rows=calories.length;
		int cols = calories[0].length;
		int[][] boy_start = new int[calories.length][calories[0].length];
		int[][] boy_end = new int[calories.length][calories[0].length];
		int[][] girl_start = new int[calories.length][calories[0].length];
		int[][] girl_end = new int[calories.length][calories[0].length];
		
		// Make first matrix - boy start
		boy_start[0][0] = calories[0][0];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(i==0 || j==0)
				{
					if(i==0 && j!=0)
					{
						boy_start[i][j] = calories[i][j]+boy_start[i][j-1];
					}
					else if(j==0 && i!=0)
					{
						boy_start[i][j] = calories[i][j]+boy_start[i-1][j];
					}
					
				}
				else {
					boy_start[i][j] = calories[i][j] + Math.max(boy_start[i-1][j], boy_start[i][j-1]);
				}
			}
		}

		
		// Make second matrix - boy end
		boy_end[rows-1][cols-1] = calories[rows-1][cols-1];
		for(int i=rows-1;i>=0;i--)
		{
			for(int j=cols-1;j>=0;j--)
			{
				if(i==rows-1 || j==cols-1)
				{
					if(i==rows-1 && j!=cols-1)
					{
						boy_end[i][j] = calories[i][j] + boy_end[i][j+1];
					}
					else if(j==cols-1 && i!=rows-1)
					{
						boy_end[i][j] = calories[i][j] + boy_end[i+1][j];
					}
					
				}
				else {
					boy_end[i][j] = calories[i][j] + Math.max(boy_end[i+1][j], boy_end[i][j+1]);
				}
			}
		}
		// Make third matrix - girl start
		girl_start[rows-1][0] = calories[rows-1][0];
		for(int i=rows-1;i>=0;i--)
		{
			for(int j=0;j<cols;j++)
			{
				if(i==rows-1 || j==0)
				{
					if(i==rows-1 && j!=0)
					{
						girl_start[i][j] = calories[i][j] + girl_start[i][j-1];
					}
					else if(j==0 && i!=rows-1)
					{
						girl_start[i][j] = calories[i][j] + girl_start[i+1][j];
					}
				}
				else {
					girl_start[i][j] = calories[i][j] + Math.max(girl_start[i][j-1], girl_start[i+1][j]);
				}
			}
		}
		
		// Make fourth matrix - girl end
		girl_end[0][cols-1] = calories[0][cols-1];
		for(int i=0;i<rows;i++)
		{
			for(int j=cols-1;j>=0;j--)
			{
				if(i==0 || j==cols-1)
				{
					if(i==0 && j!=cols-1)
					{
						girl_end[i][j] = calories[i][j] + girl_end[i][j+1];
					}
					else if(j==cols-1 && i!=0)
					{
						girl_end[i][j] = calories[i][j] + girl_end[i-1][j];
					}
				}
				else {
					girl_end[i][j] = calories[i][j] + Math.max(girl_end[i-1][j], girl_end[i][j+1]);
				}
			}
		}
		
		int ans = 0;
		// Combine all 4 matrices to get max
		for(int i=1;i<rows-1;i++)
		{
			for(int j=1;j<cols-1;j++)
			{
				int ans1 = boy_start[i-1][j] + boy_end[i+1][j] + girl_start[i][j-1] + girl_end[i][j+1];
				int ans2 = boy_start[i][j-1] + boy_end[i][j+1] + girl_start[i+1][j] + girl_end[i-1][j];
				ans = Math.max(ans, Math.max(ans1, ans2));
			}
		}
		return ans;
	}
	
	static void printMatrix(int[][] matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
