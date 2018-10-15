package treeGraphQuestions;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(5);
		int[] array = {2,6,3,1};
		for (int a : array) {
			node.insertInOrder(a);
		}
		ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
	{
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if(node==null)
		{
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		//Recurse on left and right subtrees
		ArrayList<LinkedList<Integer>> leftSeq= allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		//weave together lists from left and right sides
		
		for(LinkedList<Integer> left : leftSeq)
		{
			for(LinkedList<Integer> right : rightSeq)
			{
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weavedLists(left,right,weaved,prefix);
				result.addAll(weaved);
			}
		}
		
		return result;
		
	}
	
	//Weave lists together in all possible ways.
	//Algorithm works by removing the head from one list,recursing,and 
	//doing the same with other list
	static void weavedLists(LinkedList<Integer> first,LinkedList<Integer> second,ArrayList<LinkedList<Integer>> results,LinkedList<Integer> prefix)
	{
		//one of the list is empty 
		// add remainder to a cloned prefix and store result
		if(first.size()==0 || second.size()==0)
		{
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		// Recurse with head of first added to the prefix 
		// Removing the head with damage the first list 
		//So put it backwards where we found it
		
		int headFirst =first.removeFirst();
		prefix.addLast(headFirst);
		
		weavedLists(first,second,results,prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		//Do the same thing with second
		int headSecond =second.removeFirst();
		prefix.addLast(headSecond);
		
		weavedLists(first,second,results,prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

}
