package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotsInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 5;
		boolean[][] maze = randomBooleanMatrix(size, size, 70);
		
		printMatrix(maze);
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
		
		int count = countPathDP(maze);
		int countbtmUp=0;
		countbtmUp = countPathDPBottomUp(maze);
		System.out.println("Top Down "+count+" Bottom up "+ countbtmUp);
	}
	
	static int countPathDP(boolean[][] maze)
	{
		int row = maze.length;
		int col = maze[0].length;
		int[][] dp = new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(!maze[i][j])
				{
					dp[i][j]=-1;
				}
			}
		}
		//sprintMatrix(dp);
		return countPathDPHelper(row-1,col-1,dp);
	}
	
	static int countPathDPBottomUp(boolean[][] maze)
	{
		int row = maze.length;
		int col = maze[0].length;
		int[][] dp = new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(!maze[i][j])
				{
					dp[i][j]=-1;
				}
			}
		}
		//sprintMatrix(dp);
		for(int j=0;j<col;j++) {
			if(dp[0][j]==-1)
			{
				break;
			}
			dp[0][j]=1;
		}
		for(int i=0;i<row;i++) {
			if(dp[i][0]==-1)
			{
				break;
			}
			dp[i][0]=1;
		}
		
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				if(dp[i][j]==-1)
				{
					continue;
				}
				
				if(dp[i][j-1]!=-1)
				{
					dp[i][j]+=dp[i][j-1];
				}
				
				if(dp[i-1][j]!=-1)
				{
					dp[i][j]+=dp[i-1][j];
				}
			}
		}
		if(dp[row-1][col-1]==-1)
		{
			return 0;
		}
		return dp[row-1][col-1];
	}
	
	static int countPathDPHelper(int r,int c,int[][] dp)
	{
		if(r<0 || c<0 || dp[r][c]==-1)
		{
			return 0;
		}
		
		if(r==0 && c==0)
		{
			return 1;
		}
		
		if(dp[r][c]==0)
		{
			dp[r][c] = countPathDPHelper(r-1,c,dp) + countPathDPHelper(r,c-1,dp);
		}
		return dp[r][c];
		
	}
	
	static ArrayList<Point> getPath(boolean[][] maze)
	{
		if(maze==null || maze.length==0)
		{
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if(getPathHelper(maze,maze.length-1,maze[0].length-1,path,failedPoints))
		{
			return path;
		}
		
		return null;
	}
	
	static boolean getPathHelper(boolean[][] maze,int row,int col,ArrayList<Point> path,HashSet<Point> failedPoints)
	{
		if(row<0 || col<0 || !maze[row][col])
		{
			return false;
		}
		
		Point p = new Point(row,col);
		if(failedPoints.contains(p))
		{
			return false;
		}
		
		boolean isOrigin = (row==0) && (col==0);
		if(isOrigin || getPathHelper(maze,row,col-1,path,failedPoints) || getPathHelper(maze,row-1,col,path,failedPoints))
		{
			path.add(p);
			return true;
		}
		failedPoints.add(p);
		return false;
	}
	
	
	public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
		boolean[][] matrix = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomBoolean(percentTrue);
			}
		}
		return matrix;
	}
	
	public static boolean randomBoolean() {
		return randomIntInRange(0, 1) == 0;
	}

	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}

class Point {
	public int row, column;
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
	
	@Override
	 public int hashCode() {
        return this.toString().hashCode();
    }
	
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column)) {
            return true;
        } else {
            return false;
        }
	}
}
