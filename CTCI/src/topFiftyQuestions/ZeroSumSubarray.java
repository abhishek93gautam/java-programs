package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZeroSumSubarray {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[temp.length];
		
		for(int i=0;i<temp.length;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int len = MaxLengthOfZeroSubarray(arr);
		System.out.println(len);
	}
	
	//returns the maximum length of sub array with length 0
	static int MaxLengthOfZeroSubarray(int[] arr){
		HashMap<Integer,Integer> map = new HashMap();
		int sum = 0;
		int max_len=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			
			if(arr[i]==0 && max_len==0) {
				max_len=1;
			}
			
			Integer prev = map.get(sum);
			if(prev!=null) {
				max_len = Math.max(max_len, i-prev);
			}
			else {
				map.put(sum,i);
			}
		}
		
		return max_len;
	}

}
