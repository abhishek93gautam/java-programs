package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String first= br.readLine();
			String result=Compresser(first);
			System.out.print(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String Compresser(String input)
	{
		String result="";
		int count=0;
		//traverse the input 
		for(int i=0;i<input.length();i++)
		{
			count++;
			if(i+1>=input.length() || input.charAt(i+1)!=input.charAt(i))
			{
				result+=""+input.charAt(i)+count;
				count=0;
			}
		}
		
		return input.length()<result.length()?input:result;
	}

}
