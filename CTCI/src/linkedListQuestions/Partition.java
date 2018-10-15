package linkedListQuestions;

public class Partition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {33,9,2,3,10,10389,838,874578,5};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		LinkedListNode h = Partition(head, 6);
		
		/* Print Result */
		System.out.println(h.printForward());
	}

	public static LinkedListNode Partition(LinkedListNode node,int x)
	{
		LinkedListNode beforeStart=null;
		LinkedListNode beforeEnd=null;
		LinkedListNode afterStart=null;
		LinkedListNode afterEnd=null;
		
		//Partition List
		while(node!=null)
		{
			LinkedListNode next=node.next;
			node.next=null;
			if(node.data<x)
			{
				if(beforeStart==null)
				{
					beforeStart=node;
					beforeEnd=beforeStart;
				}
				else{
					beforeEnd.next=node;
					beforeEnd=node;
				}
			}
			else{
				if(afterStart==null)
				{
					afterStart=node;
					afterEnd=afterStart;
				}
				else{
					afterEnd.next=node;
					afterEnd=node;
				}
			}
			node=next;
		}
		if(beforeStart==null)
		{
			return afterStart;
		}
		
		//Merge two lists
		beforeEnd.next=afterStart;
		return beforeStart;
	}
}
