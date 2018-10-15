package linkedListQuestions;

public class NewSumLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode lA1 = new LinkedListNode(3, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
		
		LinkedListNode list3 = addLists(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());

	}
	
	private static LinkedListNode addLists(LinkedListNode l1,LinkedListNode l2)
	{
		int len1=length(l1);
		int len2=length(l2);
		
		// pad the shorter list with zeroes
		if(len1<len2)
		{
			l1=padList(l1,len2-len1);
		}
		else{
			l2=padList(l2,len1-len2);
		}
		
		//Add Lists
		PartialSum sum=addListHelper(l1,l2);
		
		// If there was a carry left over, insert this at the front otherwise just return the linked list
		if(sum.carry==0)
		{
			return sum.sum;
		}
		else{
			LinkedListNode result=insertBefore(sum.sum,sum.carry);
			return result;
		}
		
	}
	
	static PartialSum addListHelper(LinkedListNode l1,LinkedListNode l2)
	{
		if(l1==null && l2==null)
		{
			PartialSum sum=new PartialSum();
			return sum;
		}
		// add smaller digits recursively
		PartialSum sum=addListHelper(l1.next,l2.next);
		
		// add carry to current data
		int val=sum.carry+l1.data+l2.data;
		
		//Insert sum of current digits
		LinkedListNode final_result=insertBefore(sum.sum,val%10);
		
		//Return sum so far and the carry value
		sum.sum=final_result;
		sum.carry=val/10;
		return sum;
	}
	
	static LinkedListNode padList(LinkedListNode l,int padding)
	{
		LinkedListNode head=l;
		for(int i=0;i<padding;i++)
		{
			head=insertBefore(head,0);
		}
		return head;
	}
	
	static LinkedListNode insertBefore(LinkedListNode list,int data)
	{
		LinkedListNode node=new LinkedListNode(data);
		if(list!=null)
		{
			node.next=list;
		}
		return node;
	}
	
	private static int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

}

class PartialSum
{
	public LinkedListNode sum=null;
	public int carry=0;
}
