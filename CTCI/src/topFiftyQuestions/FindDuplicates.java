package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindDuplicates {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		ArrayList<Integer> result = findDuplicates(arr);
		System.out.println(result);
	}
	
	//[2,1,2,1]
	static ArrayList<Integer> findDuplicates(int[] arr)
	{
		Set<Integer> resultSet = new HashSet<>();
		
		for(int i=0;i<arr.length;i++)
		{
			int index = Math.abs(arr[i])-1;
			
			if(arr[index]<0)
			{
				resultSet.add(Math.abs(arr[i]));
			}
			else {
				arr[index] = -arr[index];
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Math.abs(arr[i]);
		}
		
		return new ArrayList<Integer>(resultSet);
	}

}
