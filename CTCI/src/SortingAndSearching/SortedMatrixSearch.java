package SortingAndSearching;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		printMatrix(matrix);
		//System.out.println(findElement(matrix, 100));
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				System.out.println(v + ": " + findElement(matrix, v));
			}
		}

	}
	static void printMatrix(int[][] matrix) {
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
	
	static boolean findElement(int[][] matrix,int element)
	{
		int row = 0;
		int column=matrix[0].length-1;
		while(row<matrix.length && column>=0)
		{
			if(matrix[row][column]==element)
			{
				return true;
			}
			else if(matrix[row][column]>element)
			{
				column--;
			}
			else {
				row++;
			}
		}
		return false;
	}

}
