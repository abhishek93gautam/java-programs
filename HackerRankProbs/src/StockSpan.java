import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {10, 4, 5, 90, 120, 80}; 
        int n = price.length; 
        int S[]=new int[n]; 
          
        // Fill the span values in array S[] 
        calculateSpan(price, n, S); 
  
        // print the calculated span values 
        printArray(S);

	}
	static void calculateSpan(int[] price,int n,int[] s)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		s[0]=1;
		
		for(int i=1;i<n;i++)
		{
			while(!stack.isEmpty() && price[i]>=price[stack.peek()])
			{
				stack.pop();
			}
			
			s[i] = stack.isEmpty()?(i+1) : i-stack.peek();
			
			stack.push(i);
		}
	}
	
	static void printArray(int[] s)
	{
		 System.out.print(Arrays.toString(s));
	}

}
