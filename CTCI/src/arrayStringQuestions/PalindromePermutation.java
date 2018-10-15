package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s= br.readLine();
			boolean result=IsPermutationOfPalindrome(s);
			//Character.valueof(char) returns the ASCII code in integer for character
			int code=(int)Character.valueOf('a');
			System.out.print(result+" "+code);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean IsPermutationOfPalindrome(String str)
	{
		int[] table=buildCharFrequencyTable(str);
		return checkMaxOneOdd(table);
	}
	static boolean checkMaxOneOdd(int[] table)
	{
		boolean foundOdd=false;
		for(int count:table)
		{
			if(count%2==1)
			{
				if(foundOdd)
				{
					return false;
				}
				foundOdd=true;
			}
		}
		return true;
	}
	
	static int[] buildCharFrequencyTable(String str)
	{
		//Character.getNumericValue(char) returns the numeric value of character(if no value returns -1)
		int[] table=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c:str.toCharArray())
		{
			int x=getCharNumber(c);
			if(x!=-1)
			{
				table[x]++;
			}
		}
		
		return table;
	}
	
	static int getCharNumber(Character c)
	{
		int a=Character.getNumericValue('a');
		int z=Character.getNumericValue('z');
		int val=Character.getNumericValue(c);
		if(a<=val && val<=z)
		{
			return val-a;
		}
		return -1;
	}

}
