package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeArrays {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int m  = Integer.parseInt(br.readLine());
		
		int[] a = new int[n+m];
 		int[] b = new int[m];
		String[] temp = br.readLine().split(" ");
		String[] temp1 = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0;i<m;i++) {
			b[i] = Integer.parseInt(temp1[i]);
		}
		
		//printArray(a);
		mergeArrays(a,b,n,m);
		printArray(a);

	}
	
	static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static void mergeArrays(int[] a,int[] b,int n,int m) {
		int mergeIndex = n+m-1;
		int aIndex = n-1;
		int bIndex = m-1;
		
		while(aIndex>=0 && bIndex>=0) {
			
			if(a[aIndex] > b[bIndex]) {
				a[mergeIndex] = a[aIndex];
				aIndex--;
			}
			else {
				a[mergeIndex] = b[bIndex];
				bIndex--;
			}
			
			mergeIndex--;
		}
		
		while(bIndex>=0) {
			a[mergeIndex] = b[bIndex];
			bIndex--;
			mergeIndex--;
		}
	}

}
