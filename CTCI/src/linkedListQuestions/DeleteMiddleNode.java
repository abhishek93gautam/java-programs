package linkedListQuestions;

public class DeleteMiddleNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		DeleteNode(head.next.next.next);
		System.out.println(head.printForward());

	}
	
	public static boolean DeleteNode(LinkedListNode n)
	{
		if(n==null || n.next==null)
		{
			return false;
		}
		
		LinkedListNode next=n.next;
		n.data=next.data;
		n.next=next.next;
		
		return true;
	}

}

