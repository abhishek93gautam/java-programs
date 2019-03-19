package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroMatrix {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] matrix = new boolean[n][n];
		String[][] str = new String[n][n];
		for(int i=0;i<n;i++) {
			str[i] = br.readLine().split(" ");
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = Boolean.parseBoolean(str[i][j]);
			}
		}
		
		printZeroMatrix(matrix);

	}
	
	static void printZeroMatrix(boolean[][] matrix) {
		boolean firstRow = false;
		boolean firstColumn = false;
		
		
		//check for true in first row
		for(int j=0;j<matrix[0].length;j++) {
			firstRow |= matrix[0][j];
		}
		
		//check for true in first column
		for(int i=0;i<matrix.length;i++) {
			firstColumn |= matrix[i][0];
		}
		
		// make first element of row and column to be true as true
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][j]) {
					matrix[i][0] = true;
					matrix[0][j] = true;
				}
			}
		}
		
		// make inside rows columns as true
		for(int i=1;i<matrix.length;i++) {
			if(matrix[i][0]) {
				for(int j=1;j<matrix[i].length;j++) {
					matrix[i][j] = true;
				}
			}
		}
		
		for(int j=1;j<matrix[0].length;j++) {
			if(matrix[0][j]) {
				for(int i=1;i<matrix.length;i++) {
					matrix[i][j] = true;
				}
			}
		}
		
		if(firstRow) {
			for(int j=0;j<matrix[0].length;j++) {
				matrix[0][j] = true;
			}
		}
		
		if(firstColumn) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0] = true;
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
