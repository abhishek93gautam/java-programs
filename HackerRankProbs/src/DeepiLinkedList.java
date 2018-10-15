
public class DeepiLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListDemo lld=new LinkedListDemo();
		for(int i=0;i<10;i++)
		{
			lld.insertAtEnd(new ListNode(i));
		}
		ListNode head=KtoLast(lld.head,3);
		System.out.println(head.data);
		lld.displayLL();
	}
	public static ListNode KtoLast(ListNode head,int k)
	{
		
		ListNode p1=head;
		ListNode p2=head;
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

class ListNode{
	int data;
	ListNode next;
	ListNode(int data){
		this.data=data;
	}
	public ListNode getNext(ListNode node){
		return node.next;
	}
	public void display(){
		System.out.println(data);
	}
}

class LinkedListDemo {
	ListNode head;
	LinkedListDemo(){
		head=null;
	}
	public ListNode getHead(){
		return head;
	}
	
	public void insertAtBegin(ListNode node){
		node.next=head;
		head=node;
	}
	
	public void insertAtEnd(ListNode node){
		if(head==null){
			head=node;
		}
		else{
			ListNode p=head;
			while(p.next!=null){
				p=p.next;
			}
			
			p.next=node;
		}
	}
	public void insertAfterVal(ListNode node, int  val){
		if(containsCheck(val)){
			ListNode p=head;
			while(p.data!=val){
				p=p.next;
			}
			
			node.next=p.next;
			p.next=node;
			System.out.println("Value inserted after "+ val);
		}
		else{
			System.out.println("Value not present");
		}
	}
	public void removeAtBegin(){
		if(head==null)
			System.out.println("No node preset");
		else{
			head=head.next;
			System.out.println("Removed the first one");
			
		}
	}
	public void removeAtEnd(){
		if(head==null)
			System.out.println("No node present");
		else{
			ListNode p=head;
			if(p.next==null)
				head=null;
			else{
				while(p.next.next!=null){
					p=p.next;
				}
				p.next=null;
				System.out.println("Removed the last one");
			}
		}
		
	}
	public void removeWithVal(int val){
		if(containsCheck(val)){
			ListNode p=head;
			if(p.data==val){
				p=p.next;
				head=p;
			}
			else{
				while(p.next.data!=val)
					p=p.next;
				p.next=p.next.next;
			}
			System.out.println("Value removed "+ val);
		}
		else{
			System.out.println("Value not present");
		}
	}
	public boolean containsCheck(int  val){
		if(head==null){
			return false;
		}
		else{
			ListNode p=head;
			while(p.data!=val && p.next!=null){
				p=p.next;
			}
			if(p.data==val)
				return true;
			else
				return false;
		}
	}
	public void displayLL(){
		ListNode p=head;
		while(p.next!=null){
			System.out.print(p.data + "->");
			p=p.next;
		}
		System.out.print(p.data);
	}
	
}
