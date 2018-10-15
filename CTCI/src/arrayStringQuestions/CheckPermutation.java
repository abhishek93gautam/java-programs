package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s1= br.readLine();
			String s2=br.readLine();
			boolean result=checkPermutation(s1,s2);
			System.out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	static boolean checkPermutation(String s1,String s2)
	{
		if(s1.length()!=s2.length())
		{
			return false;
		}
		int[] letters=new int[128];
		char[] s_array=s1.toCharArray();
		for(char c : s_array)
		{
			letters[c]++;
		}
		
		for(int i=0;i<s2.length();i++)
		{
			int c=(int)s2.charAt(i);
			letters[c]--;
			if(letters[c]<0)
			{
				return false;
			}
			
		}
		return true;
	}

}
