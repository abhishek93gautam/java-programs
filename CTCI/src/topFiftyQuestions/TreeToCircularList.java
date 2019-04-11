package topFiftyQuestions;

public class TreeToCircularList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		Node leftChild1 = new Node(2);
		Node rightChild1 = new Node(3);
		Node leftOfLeft = new Node(4);
		Node rightOfLeft = new Node(5);
		Node leftOfRight = new Node(6);
		Node rightOfRight = new Node(7);
		
		leftChild1.left = leftOfLeft;
		leftChild1.right = rightOfLeft;
		
		rightChild1.left = leftOfRight;
		rightChild1.right = rightOfRight;
		
		root.left = leftChild1;
		root.right = rightChild1;
		
		root = treeToList(root);
		System.out.println(root.right.data);

	}
	
	static Node concatenate(Node a,Node b) {
		if(a==null) {
			return b;
		}
		
		if(b==null) {
			return a;
		}
		
		Node aEnd = a.left;
		Node bEnd = b.left;
		
		a.left = bEnd;
		bEnd.right = a;
		aEnd.right = b;
		b.left = aEnd;
		
		return a;
	}

	static Node treeToList(Node n) {
		if(n==null) {
			return n;
		}
		
		Node leftList = treeToList(n.left);
		Node rightList = treeToList(n.right);
		
		// To make the current node points to itself on left and right 
		n.left = n;
		n.right = n;
		
		
		n = concatenate(leftList,n);
		n = concatenate(n,rightList);
		
		return n;
		
	}

}

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
	
}