package stackQueuesQuestions;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin2 stack2 = new StackWithMin2();
		int[] array = {2, 1, 3, 1};
		for (int value : array) {
			stack2.push(value);
			System.out.print(value + ", ");
		}
		
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack2.pop());
			System.out.println("New min is " + stack2.min());
	
		}
	}
}
class StackWithMin2 extends Stack<Integer>
{
	Stack<Integer> s2;
	public StackWithMin2()
	{
		s2=new Stack<Integer>();
	}
	
	public void push(int value)
	{
		if(value<=min())
		{
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop()
	{
		int value=super.pop();
		if(value==min())
		{
			s2.pop();
		}
		return value;
	}
	
	public int min()
	{
		if(s2.isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		else {
			return s2.peek();
		}
		
	}
	
}

