package stackQueuesQuestions;


public class ThreeInOne {

	/**
	 * @param args
	 * @throws FullStackException 
	 */
	public static void main(String[] args) throws FullStackException {
		// TODO Auto-generated method stub
		FixedMultiStack stacks = new FixedMultiStack(4);
		printStacks(stacks);
		stacks.push(0, 10);
		printStacks(stacks);
		stacks.push(1, 20);
		printStacks(stacks);
		stacks.push(2, 30);
		printStacks(stacks);
		
		stacks.push(1, 21);
		printStacks(stacks);
		stacks.push(0, 11);
		printStacks(stacks);
		stacks.push(0, 12);
		printStacks(stacks);
		
		stacks.pop(0);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		
		stacks.push(0, 13);
		printStacks(stacks);
		stacks.push(1, 22);
		printStacks(stacks);
		
		stacks.push(2, 31);
		printStacks(stacks);
		stacks.push(2, 32);
		printStacks(stacks);
	}
	
	public static void printStacks(FixedMultiStack stacks) {
		System.out.println(arrayToString(stacks.getValues()));
	}
	public static String arrayToString(int[] array) {
		if (array == null) return "";
		return arrayToString(array, 0, array.length - 1);
	}
	
	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			int v = array[i];
			sb.append(v + ", ");
		}
		return sb.toString();
	}	

}

class FixedMultiStack
{
	private int numberOfStacks=3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize)
	{
		this.stackCapacity=stackSize;
		this.values=new int[stackSize*numberOfStacks];
		this.sizes=new int[numberOfStacks];
	}
	
	//Push value on to the stack
	public void push(int stackNum,int value) throws FullStackException
	{
		//check that we have extra space for new element
		if(isFull(stackNum))
		{
			throw new FullStackException();
		}
		
		// Increment the stack pointer and update the value
		sizes[stackNum]++;
		values[indexOfTop(stackNum)]=value;
	}
	
	//Return the index of the top of the stack
	public int indexOfTop(int stackNum)
	{
		int offset=stackNum*stackCapacity;
		int size=sizes[stackNum];
		return offset+size-1;
	}
	
	// Returns if the stack is full
	public boolean isFull(int stackNum)
	{
		return sizes[stackNum]==stackCapacity;
	}
	
	//Returns if the stack is empty
	public boolean isEmpty(int stackNum)
	{
		return sizes[stackNum]==0;
	}
	// Return top element
	public int peek(int stackNum) throws FullStackException
	{
		if(isEmpty(stackNum))
		{
			throw new FullStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
	//Pop item from top stack
	public int pop(int stackNum) throws FullStackException
	{
		if(isEmpty(stackNum))
		{
			throw new FullStackException();
		}
		int topIndex=indexOfTop(stackNum);
		int value=values[topIndex]; // Get Value
		values[topIndex]=0;
		sizes[stackNum]--;
		return value;
	}
	
	public int[] getValues() {
		return values;
	}
	
	public int[] getStackValues(int stackNum) {
		int[] items = new int[sizes[stackNum]];
		for (int i = 0; i < items.length; i++) {
			items[i] = values[stackNum * stackCapacity + i];
		}
		return items;
	}
	
}
class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}

