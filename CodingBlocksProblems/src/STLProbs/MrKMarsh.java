package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MrKMarsh {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int m = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		
		boolean[][] land = new boolean[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		String[] input = new String[m];
		for(int i=0;i<m;i++) {
			input[i] = br.readLine();
		}
		
		//Taking land input and filling the left matrix
		for(int i=0;i<m;i++) {
			int spaces = 0;
			for(int j=0;j<n;j++) {
				if(input[i].charAt(j)=='.') {
					land[i][j] = true;
					left[i][j] = spaces++;
				}
				else {
					land[i][j] = false;
					left[i][j] = -1;
					spaces = 0;
				}
			}
		}
		
		//filling the right matrix
		for(int i=0;i<m;i++) {
			int spaces=0;
			for(int j=n-1;j>=0;j--) {
				if(land[i][j]) {
					right[i][j]=spaces++;
				}
				else {
					right[i][j]=-1;
					spaces=0;
				}
			}
		}
		
		//filling the up matrix
		for(int j=0;j<n;j++) {
			int spaces=0;
			for(int i=0;i<m;i++) {
				if(land[i][j]) {
					up[i][j]=spaces++;
				}
				else {
					up[i][j] = -1;
					spaces=0;
				}
			}
		}
		
		//filling the down matrix
		for(int j=0;j<n;j++) {
			int spaces=0;
			for(int i=m-1;i>=0;i--) {
				if(land[i][j]) {
					down[i][j]=spaces++;
				}
				else {
					down[i][j] = -1;
					spaces=0;
				}
			}
		}
		int maxPerimeter = 0;
		for(int i=0;i<m-1;i++) {
			for(int j=0;j<n-1;j++) {
				
				if(!land[i][j]) {
					continue;
				}
				
				for(int x=i+down[i][j];x>=i+1;x--) {
					for(int y=j+right[i][j];y>=j+1;y--) {
						
						int side1 = x-i;
						int side2 = y-j;
						if(side1+side2<=maxPerimeter) {
							break;
						}
						
						if(land[x][y] && left[x][y]>=side2 && up[x][y]>=side1) {
							if(side1+side2>maxPerimeter) {
								maxPerimeter = side1+side2;
							}
						}
						
					}
				}
			}
		}
		if(maxPerimeter==0) {
			System.out.println("impossible");
		}
		else {
			System.out.println(2*maxPerimeter);
		}
	}
//	
//	static void Print(int[][] matrix) {
//		for(int i=0;i<matrix.length;i++) {
//			for(int j=0;j<matrix[0].length;j++) {
//				System.out.print(matrix[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
