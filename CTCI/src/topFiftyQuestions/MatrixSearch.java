package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixSearch {
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
		
		System.out.println(searchElement(matrix,5));
		
	}
	public static boolean searchElement(int[][] matrix,int item){
		if(matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		
		int row = 0;
		int column = matrix[0].length-1;
		
		while(row<matrix.length && column>=0) {
			if(matrix[row][column]==item) {
				return true;
			}
			if(matrix[row][column]<item) {
				row++;
			}
			else {
				column--;
			}
		}
		
		return false;
	}
}
