package treeGraphQuestions;

import java.util.Random;

public class RandomNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			Tree tree = new Tree();
			int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array) {
				tree.insertInOrder(x);
			}
			int d = tree.getRandomNode().data;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}

}

class TreeNodeRandom
{
	public int data;
	public TreeNodeRandom left;
	public TreeNodeRandom right;
	private int size;
	
	public TreeNodeRandom(int d)
	{
		this.data = d;
		size=1;
	}
	
	public void insertInOrder(int d)
	{
		if(d<=data)
		{
			if(left==null)
			{
				left=new TreeNodeRandom(d);
			}
			else {
				left.insertInOrder(d);
			}
		}
		else {
			if(right==null)
			{
				right=new TreeNodeRandom(d);
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	public int data() {
		return data;
	}
	
	
	public TreeNodeRandom find(int d)
	{
		if(d==data)
		{
			return this;
		}
		else if(d<=data)
		{
			return left!=null ? left.find(d) : null;
		}
		else{if(d>data)
		{
			return right!=null ? right.find(d) : null; 
		}
		return null;
		}
	}
	
	public TreeNodeRandom getIthNode(int i)
	{
		int leftSize = left==null?0 : left.size();
		Random random = new Random();
		
		int index = random.nextInt(size);
		if(index < leftSize)
		{
			return left.getIthNode(i);
		}
		else if(index == leftSize)
		{
			return this;
		}
		else {
			return right.getIthNode(i-(leftSize));
		}
	}
	
}


class Tree {
	TreeNodeRandom root = null;
	
	public void insertInOrder(int value) {
		if (root == null) {
			root = new TreeNodeRandom(value);
		} else {
			root.insertInOrder(value);
		}
	}
	
	public int size() {
		return root == null ? 0 : root.size();
	}
	
	public TreeNodeRandom getRandomNode() {
		if (root == null) return null;
		
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
}
