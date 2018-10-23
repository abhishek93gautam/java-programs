package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> list = generateParens(2);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
		
		ArrayList<String> list1 = generateParensNew(2);
		for (String s : list1) {
			System.out.println(s);
		}
		System.out.println(list1.size());

	}
	
	static HashSet<String> generateParens(int num)
	{
		//Base case 
		HashSet<String> set = new HashSet<String>();
		if(num==0)
		{
			set.add("");
			return set;
		}
		
		//Go with low cases
		HashSet<String> partial = generateParens(num-1);
		for(String s : partial)
		{
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)=='(')
				{
					String newStr = insertBetween(s,j);
					set.add(newStr);
				}
			}
			set.add("()"+s);
		}
		
		return set;
	}
	
	static String insertBetween(String s,int j)
	{
		String first = s.substring(0,j+1);
		String second = s.substring(j+1,s.length());
		
		return first+"()"+second;
	}
	
	static ArrayList<String> generateParensNew(int count)
	{
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParens(list,count,count,str,0);
		return list;
	}
	
	static void addParens(ArrayList<String> list,int leftRem,int rightRem,char[] str,int count)
	{
		if(leftRem<0 || rightRem<leftRem)
		{
			return; //Invalid state
		}
		
		// no more parens left
		if(leftRem==0 && rightRem==0)
		{
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else {
			if(leftRem > 0)
			{
				str[count]='(';
				addParens(list,leftRem-1,rightRem,str,count+1);
			}
			
			if(rightRem>0)
			{
				str[count]=')';
				addParens(list,leftRem,rightRem-1,str,count+1);
			}
		}
	}
}
