package treeGraphQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimalTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3,4,5,6,7,8,9,10};
		
		TreeNode root=TreeNode.createMinimalBST(array);
		
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());

	}

}

class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	private int size=0;
	public TreeNode(int data)
	{
		this.data=data;
		size=1;
	}
	
	private void setLeftChild(TreeNode left)
	{
		this.left=left;
		if(left!=null)
		{
			left.parent=this;
		}
	}
	
	private void setRightChild(TreeNode right)
	{
		this.right=right;
		if(right!=null) {
			right.parent=this;
		}
	}
	
	public void insertInOrder(int d)
	{
		if(d<=data)
		{
			if(left==null)
			{
				setLeftChild(new TreeNode(d));
			}
			else {
				left.insertInOrder(d);
			}
		}
		else {
			if(right==null)
			{
				setRightChild(new TreeNode(d));
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size()
	{
		return size;
	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
	
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}
		return true;
	}
	
	public int height()
	{
		int leftHeight= left!=null? left.height():0;
		int rightHeight= right!=null?right.height():0;
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d)
	{
		if(d==data)
		{
			return this;
		}
		else if(d<=data)
		{
			return left!=null?left.find(d):null;
		}
		else if(d>data)
		{
			return right!=null?right.find(d):null;
		}
		
		return null;
	}
	
	public static TreeNode createMinimalBST(int[] array)
	{
		return createMinimalBST(array,0,array.length-1);
	}
	
	private static TreeNode createMinimalBST(int[] array,int start,int end) {
		if(end<start)
		{
			return null;
		}
		
		int mid=(start+end)/2;
		TreeNode n=new TreeNode(array[mid]);
		n.left=createMinimalBST(array,start,mid-1);
		n.right=createMinimalBST(array,mid+1,end);
		if(n.left!=null)
		{
			n.left.parent=n;
		}
		if(n.right!=null)
		{
			n.right.parent=n;
		}
		
		return n;
	}
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
