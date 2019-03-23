package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareSubMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][m];
		String[][] str = new String[n][m];
		for(int i=0;i<n;i++) {
			str[i] = br.readLine().split(" ");
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(str[i][j]);
			}
		}
		
		int len = getMaxLenSubSquareMatrix(matrix,n,m);
		System.out.println(len);
	}
	
	static int getMaxLenSubSquareMatrix(int[][] matrix,int n,int m) {
		int max = 1;
		int[][] dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//Corner cases row and columns
				if((i==0 || j==0)) {
					if(matrix[i][j]==1) {
						dp[i][j]=1;
					}
				}
				else if(matrix[i][j]==1){
//					if((matrix[i-1][j]==1 && matrix[i-1][j-1]==1 && matrix[i][j-1]==1 && matrix[i][j]==1) && 
//							(dp[i-1][j]==dp[i-1][j-1] && dp[i-1][j-1]==dp[i][j-1]) ) {
//						dp[i][j] = dp[i-1][j-1]+1;
//						if(dp[i][j]>max) {
//							max = dp[i][j];
//						}
//						
//					}
//					else if((matrix[i-1][j]==1 && matrix[i-1][j-1]==1 && matrix[i][j-1]==1 && matrix[i][j]==1)) {
//						dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j-1], dp[i][j-1]));
//					}
//					else if(matrix[i][j]==1){
//						dp[i][j]=1;
//					}
					dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
					if(dp[i][j]>max) {
						max = dp[i][j];
					}
				}
				
			}
		}
		printMatrix(dp);
		return max;
	}
	static void printMatrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
