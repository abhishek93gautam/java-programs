package linkedListQuestions;

public class Intersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.data);

	}
	public static LinkedListNode createLinkedListFromArray(int[] vals) {
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
	}
	
	static LinkedListNode findIntersection(LinkedListNode list1,LinkedListNode list2)
	{
		if(list1==null || list2==null)
		{
			return null;
		}
		
		// Get tail and sizes
		Result result1= getTailAndSizes(list1);
		Result result2=getTailAndSizes(list2);
		
		// If different tails by reference then no intersection
		if(result1.tail!=result2.tail)
		{
			return null;
		}
		
		//Set pointers to start of each Linked List
		LinkedListNode shorter=result1.size<result2.size?list1:list2;
		LinkedListNode longer=result1.size<result2.size?list2:list1;
		
		longer=getKthNode(longer,Math.abs(result1.size-result2.size));
		
		while(shorter!=longer)
		{
			shorter=shorter.next;
			longer=longer.next;
		}
		return longer;
	}
	
	static LinkedListNode getKthNode(LinkedListNode head,int k)
	{
		LinkedListNode current=head;
		while(k>0 && current!=null)
		{
			current=current.next;
			k--;
		}
		return current;
	}
	
	static Result getTailAndSizes(LinkedListNode list)
	{
		if(list==null)
		{
			return null;
		}
		int size=1;
		LinkedListNode current=list;
		while(current.next!=null)
		{
			size++;
			current=current.next;
		}
		return new Result(current,size);
	}
}
class Result
{
	public LinkedListNode tail;
	public int size;
	public Result(LinkedListNode tail,int size)
	{
		this.tail=tail;
		this.size=size;
	}
}
