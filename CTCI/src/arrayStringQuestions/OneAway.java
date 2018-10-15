package arrayStringQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneAway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String first= br.readLine();
			String second=br.readLine();
			boolean result=CheckEdits(first,second);
			System.out.print(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static boolean CheckEdits(String first,String second)
	{
		// if strings have length difference greater than 1 then return false
		if(Math.abs(first.length()-second.length())>1)
		{
			return false;
		}
		// bigger string in s2 and smaller in s1
		String s1=first.length()<second.length()?first:second;
		String s2=first.length()<second.length()?second:first;
		
		int index1=0;
		int index2=0;
		boolean foundDifference=false;
		while(index2<s2.length() && index1<s1.length())
		{
			if(s1.charAt(index1)!=s2.charAt(index2))
			{
				if(foundDifference)
				{
					return false;
				}
				foundDifference=true;
				// if there is a replace move the shorter string
				if(s1.length()==s2.length())
				{
					index1++;
				}
			}
			//if characters are equal move the shorter string 
			else{
				index1++;
			}
			//always move the index of bigger string
			index2++;
		}
		return true;
	}

}
