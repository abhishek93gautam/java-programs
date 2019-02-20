package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SummingPieces {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		long MOD = 1000000007;
		
		//It will hold the powers of 2 starting from 0
		long[] powers = new long[n+1];
		powers[0] = 1;
		for(int i=1;i<=n;i++) {
			powers[i] = (2*powers[i-1])%MOD;
		}
		
		long[] multiply_array = new long[n];
		multiply_array[0] = multiply_array[n-1]=(powers[n]-1+MOD)%MOD;
		int start=n-2;
		for(int i=1;i<=n/2;i++) {
			multiply_array[i] = (powers[start]-powers[i-1]+MOD)%MOD;
			multiply_array[i] = (multiply_array[i-1]+multiply_array[i])%MOD;
			multiply_array[n-i-1] = multiply_array[i];
			start=start-1;
		}
		long ans = 0;
		for(int i=0;i<n;i++) {
			ans = (ans+(multiply_array[i]*arr[i])%MOD)%MOD;
		}
		System.out.println(ans);
	}
	
	static void printArray(long[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
