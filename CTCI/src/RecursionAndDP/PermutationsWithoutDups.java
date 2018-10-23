package RecursionAndDP;

import java.util.ArrayList;

public class PermutationsWithoutDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
		ArrayList<String> list1 = getPermsBySustring("abc");
		System.out.println("There are " + list1.size() + " permutations.");
		for (String s : list1) {
			System.out.println(s);
		}
	}
	
	// Method 1 : By inserting character at places of all permuations of string minus that character 
	// Building from permutations of first n-1 characters
	static ArrayList<String> getPerms(String str)
	{
		if(str==null)
		{
			return null;
		}
		
		ArrayList<String> permutations = new ArrayList<String>();
		//Base case 
		if(str.length()==0)
		{
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word:words)
		{
			for(int j=0;j<=word.length();j++)
			{
				String s = insertCharAt(word,first,j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	static String insertCharAt(String word,char c,int i)
	{
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start+c+end;
	}
	
	// Method-2 : Building from permutations of all n-1 character substrings 
	static ArrayList<String> getPermsBySustring(String str)
	{
		ArrayList<String> permutations = new ArrayList<String>();
		//Base case
		if(str.length()==0)
		{
			permutations.add("");
			return permutations;
		}
		
		for(int i=0;i<str.length();i++)
		{
			String before = str.substring(0,i);
			String after = str.substring(i+1,str.length());
			System.out.println("Before: "+before+" After: "+after);
			ArrayList<String> partials = getPerms(before+after);
			
			//Prepend char i to each permutation
			for(String s : partials)
			{
				permutations.add(str.charAt(i)+s);
			}
		}
		
		return permutations;
	}

}
