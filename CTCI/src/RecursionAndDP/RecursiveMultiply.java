package RecursionAndDP;

public class RecursiveMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int product = minProduct(6,8);
		System.out.println("Product recursive "+product);
		int product1 = minProductDP(8,8);
		System.out.println("Product recursion with dp "+product1);

		int product2 = minProductPlain(9,8);
		System.out.println("Product without dp "+product2);
	}
	
	static int minProduct(int a,int b)
	{
		int smaller = a<b?a:b;
		int bigger = a<b?b:a;
		
		return minProductHelper(smaller,bigger);
		
	}

	static int minProductHelper(int smaller,int bigger)
	{
		if(smaller==0)
		{
			return 0;
		}
		if(smaller==1)
		{
			return bigger;
		}
		
		int s = smaller>>1;
		
		int side1 = minProduct(s,bigger);
		int side2 = side1;
		if(smaller%2==1)
		{
			side2 = minProduct(smaller-s,bigger);
		}
		
		return side1+side2;
	}
	
	static int minProductDP(int a,int b)
	{
		int smaller = a<b?a:b;
		int bigger = a<b?b:a;
		int[] dp = new int[smaller+1];
		return minProductDPHelper(smaller,bigger,dp);
		
	}

	static int minProductDPHelper(int smaller,int bigger,int[] dp)
	{
		if(smaller==0)
		{
			return 0;
		}
		if(smaller==1)
		{
			return bigger;
		}
		if(dp[smaller]>0)
		{
			return dp[smaller];
		}
		int s = smaller>>1;
		
		int side1 = minProduct(s,bigger);
		int side2 = side1;
		if(smaller%2==1)
		{
			side2 = minProduct(smaller-s,bigger);
		}
		
		dp[smaller] = side1+side2;
 		return dp[smaller];
	}
	
	static int minProductPlain(int a,int b)
	{
		int smaller = a<b?a:b;
		int bigger = a<b?b:a;
		return minProductHelperPlain(smaller,bigger);
		
	}

	static int minProductHelperPlain(int smaller,int bigger)
	{
		if(smaller==0)
		{
			return 0;
		}
		if(smaller==1)
		{
			return bigger;
		}
		int s = smaller>>1;
		
		int side1 = minProductHelperPlain(s,bigger);
		if(smaller%2==0)
		{
			return side1+side1;
		}
		else {
			return side1+side1+bigger;
		}
	}
}
