package stackQueuesQuestions;
import java.util.Stack;
public class QueueViaStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> my_queue = new MyQueue<Integer>();
		my_queue.add(12);
		my_queue.add(13);
		my_queue.add(14);
		my_queue.add(15);
		System.out.println(my_queue.Peek());
	}

}

class MyQueue<T>
{
	Stack<T> stackNewest,stackOldest;
	public MyQueue()
	{
		stackNewest=new Stack<T>();
		stackOldest=new Stack<T>();
	}
	
	public int size()
	{
		return stackNewest.size()+stackOldest.size();
	}
	
	public void add(T value)
	{
		//Push onto stackNewest, which always have new elements at top
		stackNewest.push(value);
	}
	
	//Move elements from stackNewest into stackOldest. This is usually done so that we can do operation 
	//on stackkOldest
	private void shiftStacks()
	{
		if(stackOldest.isEmpty())
		{
			while(!stackNewest.isEmpty())
			{
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T Peek()
	{
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek(); // retrieve the oldest item.
	}
	
	public T pop()
	{
		shiftStacks(); // Ensuring stackOldest has the current elements
		return stackOldest.pop(); // pop the oldest item
	}
}
