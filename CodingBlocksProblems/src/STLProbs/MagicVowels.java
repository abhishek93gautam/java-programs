package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicVowels {
	
	static final int NOT_ELIGIBLE = -1;
	static char[] vowels = {'a','e','i','o','u'};
	static Map<Character,Integer> mapping = new HashMap<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		mapping.put('a', 0);
		mapping.put('e', 1);
		mapping.put('i', 2);
		mapping.put('o', 3);
		mapping.put('u', 4);
		List<Character> result = FindMaxLengthTopDown(s1,new ArrayList<Character>(),0);
		System.out.println(result);
		System.out.println("Max length is : " + result.size());
	}
	
	static boolean IsValidSequence(ArrayList<Character> sublist) {
		for(char vowel : vowels) {
			if(!sublist.contains(vowel)) {
				return false;
			}
		}
		return true;
	}
	static ArrayList<Character> FindMaxLengthTopDown(String input,ArrayList<Character> sublist,int index) {
		
		//Check Sublist is Valid if index reaches length 
		if(index == input.length()) {
			if(IsValidSequence(sublist)) {
				return sublist;
			}
			else {
				return new ArrayList<>();
			}
		}
		else {
			// If sublist is empty
			if(sublist.size()==0) {
				if(input.charAt(index)!='a') {
					return FindMaxLengthTopDown(input,sublist,index+1);
				}
				else {
					sublist.add(input.charAt(index));
					return FindMaxLengthTopDown(input,sublist,index+1);
				}
			}
			
			//If current sublist vowel is same as the current index vowel add it to the sublist 
			else if(mapping.get(sublist.get(sublist.size()-1))==mapping.get(input.charAt(index))) {
				sublist.add(input.charAt(index));
				return FindMaxLengthTopDown(input, sublist, index+1);
				
			}
			
			//If current sublist vowel is one less than the current index vowel
			// We have 2 options
			// 1. Include it in sublist 
			// 2. Don't include 
			// The max of both will be the answer
			else if((mapping.get(sublist.get(sublist.size()-1))+1)==mapping.get(input.charAt(index))) {
				ArrayList<Character> newList = (ArrayList<Character>)sublist.clone();
				newList.add(input.charAt(index));
				
				ArrayList<Character> sub1 = FindMaxLengthTopDown(input,newList,index+1);
				ArrayList<Character> sub2 = FindMaxLengthTopDown(input,sublist,index+1);
				if(sub1.size()>sub2.size()) {
					return sub1;
				}
				else {
					return sub2;
				}
			}
			else {
				return FindMaxLengthTopDown(input, sublist, index+1);
			}
			
		}
		
		
		
		
	}

}
