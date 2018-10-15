package linkedListQuestions;

public class ReturnKToLast {

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
		LinkedListNode result=KtoLast(head,4);
		System.out.print(result.data);
	}
	public static LinkedListNode KtoLast(LinkedListNode head,int k)
	{
		LinkedListNode p1=head;
		LinkedListNode p2=head;
		for(int i=0;i<k;i++)
		{
			if(p1==null)
			{
				return null;
			}
			p1=p1.next;
		}
		
		while(p1!=null)
		{
			p1=p1.next;
			p2=p2.next;
		}
		return p2;
	}

}


