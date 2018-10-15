package linkedListQuestions;

public class LoopDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		//nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = FindBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}

	}
	
	static LinkedListNode FindBeginning(LinkedListNode head)
	{
		LinkedListNode slow=head;
		LinkedListNode fast=head;
		
		//Find the meeting point
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) //Collision
			{
				break;
			}
		}
		
		// If no meeting point and therefore no loop
		if(fast==null || fast.next==null)
		{
			return null;
		}
		
		// Move slow to head. Keep fast at meeting point. Each are k steps from start of loop.
		// If they move at same pace they will meet at start of loop
		slow=head;
		while(slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		//Both now points to start of the loop
		return fast;
	}

}
