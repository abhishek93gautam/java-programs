package stackQueuesQuestions;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> input=new Stack<Integer>();
		input.push(12);
		input.push(10);
		input.push(13);
		input.push(8);
		input.push(7);
		
		Sort(input);
		
		while(!input.isEmpty())
		{
			System.out.print(input.pop()+" ");
		}
	}
	
	public static void Sort(Stack<Integer> s)
	{
		Stack<Integer> r=new Stack<Integer>();
		while(!s.isEmpty())
		{
			//Insert each element in s into sorted order in r
			int tmp=s.pop();
			while(!r.isEmpty() && r.peek()>tmp)
			{
				s.push(r.pop());
			}
			r.push(tmp);
		}
		while(!r.empty())
		{
			s.push(r.pop()); //Copy elements from r back
		}
	}

}
