package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsUnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s= br.readLine();
			boolean result=isUniqueCharacters(s);
			System.out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		

	}
	static boolean isUniqueCharacters(String str)
	{
		if(str.length()>128)
			return false;
		
		boolean[] char_set=new boolean[128];
		for(int i=0;i<str.length();i++)
		{
			int val=str.charAt(i);
			if(char_set[val])
			{
				return false;
			}
			char_set[val]=true;
		}
		return true;
	}

}
