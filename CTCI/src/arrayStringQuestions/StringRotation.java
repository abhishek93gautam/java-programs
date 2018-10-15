package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String s1= br.readLine();
			String s2=br.readLine();
			boolean result=IsRotation(s1,s2);
			System.out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	static boolean IsRotation(String s1,String s2)
	{
		if(s1.length()==0 || s2.length()==0 || s1.length()!=s2.length())
		{
			return false;
		}
		String s1s1=s1+s1;
		
		return isSubstring(s1s1,s2);
	}
	
	static boolean isSubstring(String big,String small)
	{
		if(big.indexOf(small)>=0)
		{
			return true;
		}
		else{
			return false;
		}
	}
}
