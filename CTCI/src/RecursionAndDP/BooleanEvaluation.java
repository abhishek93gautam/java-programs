package RecursionAndDP;

import java.util.HashMap;

public class BooleanEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expression = "0^0|1&1^1|0|1";
		String expression = "1^0|0|1";
		boolean result = false;
		
		System.out.println("Recursion "+countEval(expression, result));
		System.out.println("Recursion with DP "+countEvalDP(expression, result));
		//System.out.println(count);
	}
	
	static boolean stringToBool(String c)
	{
		return c.equals("1")? true:false;
	}
	
	static int countEval(String s,boolean result)
	{
		if(s.length()==0) {
			return 0;
		}
		
		if(s.length()==1)
		{
			return stringToBool(s)==result?1:0;
		}
		int ways=0;
		for(int i=1;i<s.length();i+=2)
		{
			char c = s.charAt(i);
			String left = s.substring(0,i);
			String right = s.substring(i+1,s.length());
			
			//Evaluate each side of each result
			int leftTrue = countEval(left,true);
			int leftFalse = countEval(left,false);
			int rightTrue = countEval(right,true);
			int rightFalse = countEval(right,false);
			int total = (leftTrue+leftFalse) * (rightTrue+rightFalse);
			
			int totalTrue = 0;
			if(c=='^')
			{
				totalTrue = leftTrue*rightFalse + leftFalse*rightTrue;
			}
			else if(c=='&')
			{
				totalTrue = leftTrue*rightTrue;
			}
			else if(c=='|')
			{
				totalTrue = leftFalse*rightTrue + leftTrue*rightFalse + leftTrue*rightTrue;
			}
			
			int subWays = result?totalTrue : total-totalTrue;
			ways+=subWays;
		}
		
		return ways;
	}
	
	public static int countEvalDP(String s, boolean result) {
		return countEvalDP(s, result, new HashMap<String, Integer>());
	}
	
	static int countEvalDP(String s,boolean result,HashMap<String,Integer> map)
	{
		if(s.length()==0) {
			return 0;
		}
		
		if(s.length()==1)
		{
			return stringToBool(s)==result?1:0;
		}
		if(map.containsKey(result+s))
		{
			return map.get(result+s);
		}
		int ways=0;
		for(int i=1;i<s.length();i+=2)
		{
			char c = s.charAt(i);
			String left = s.substring(0,i);
			String right = s.substring(i+1,s.length());
			
			//Evaluate each side of each result
			int leftTrue = countEval(left,true);
			int leftFalse = countEval(left,false);
			int rightTrue = countEval(right,true);
			int rightFalse = countEval(right,false);
			int total = (leftTrue+leftFalse) * (rightTrue+rightFalse);
			
			int totalTrue = 0;
			if(c=='^')
			{
				totalTrue = leftTrue*rightFalse + leftFalse*rightTrue;
			}
			else if(c=='&')
			{
				totalTrue = leftTrue*rightTrue;
			}
			else if(c=='|')
			{
				totalTrue = leftFalse*rightTrue + leftTrue*rightFalse + leftTrue*rightTrue;
			}
			
			int subWays = result?totalTrue : total-totalTrue;
			ways+=subWays;
		}
		map.put(result+s, ways);
		return ways;
	}

}
