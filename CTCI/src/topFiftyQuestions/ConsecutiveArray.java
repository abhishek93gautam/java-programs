package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConsecutiveArray {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		int[] arr = new int[str1.length];
		for (int i = 0; i < str1.length; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		
		System.out.println(getConsecutiveElementsLength(arr));

	}
	
	static int getConsecutiveElementsLength(int[] arr) {
		HashSet<Integer> set = new HashSet();
		for(int i : arr) {
			set.add(i);
		}
		
		int max = 0;
		for(int i : set) {
			int len = 0;
			
			// If set contains the element on the left, means no need to traverse from current element
			if(set.contains(i-1)) {
				continue;
			}
			
			// traverse all elements to the right of the current element
			while(set.contains(i++)) {
				len++;
			}
			
			if(len>max) {
				max = len;
			}
		}
		return max;
	}

}
