package treeGraphQuestions;

import java.util.HashMap;

public class PathsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);	
		System.out.println(countPathsWithSum(root, 0));
		*/
		
		TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, 0));
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(0);
//		root.right.left = new TreeNode(0);
//		root.right.left.right = new TreeNode(0);
//		root.right.right = new TreeNode(0);
//		System.out.println(countPathsWithSum(root, 0));
//		System.out.println(countPathsWithSum(root, 4));
	}
	
//	public static int countPathsWithSum(TreeNode root,int targetSum)
//	{
//		if(root==null)
//		{
//			return 0;
//		}
//		
//		int pathsFromRoot = countPathsWithSumFromNode(root,targetSum,0);
//		int pathsOnLeft = countPathsWithSum(root.left,targetSum);
//		int pathsOnRight = countPathsWithSum(root.right, targetSum);
//		
//		return pathsFromRoot + pathsOnLeft + pathsOnRight;
//		
//	}
	
	public static int countPathsWithSum(TreeNode root,int targetSum)
	{
		return countPathsWithSum(root, targetSum,0,new HashMap<Integer,Integer>());
		
	}
	public static int countPathsWithSum(TreeNode root,int targetSum,int runningSum,HashMap<Integer,Integer> pathCount)
	{
		if(root==null)
		{
			return 0;
		}
		
		//Count paths with sum ending at current node
		runningSum +=root.data;
		
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		//If runningSum equals targetSum then one additional path starts at root. Add this in path
		if(runningSum==targetSum)
		{
			totalPaths++;
		}
		
		//Increment pathCount , recurse , then decrement pathCount
		incrementHashTable(pathCount, sum, 1);
		totalPaths+= countPathsWithSum(root.left,targetSum,runningSum,pathCount);
		totalPaths+= countPathsWithSum(root.right,targetSum,runningSum,pathCount);
		incrementHashTable(pathCount, sum, -1);
		return totalPaths;
	}
	
	public static void incrementHashTable(HashMap<Integer,Integer> hashTable,int key,int delta)
	{
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if(newCount == 0 ) // Remove when zero to reduce space usage
		{
			hashTable.remove(key);
		}
		else {
			hashTable.put(key, newCount);
		}
	}
	public static int countPathsWithSumFromNode(TreeNode root,int targetSum,int currentSum)
	{
		if(root==null)
		{
			return 0;
		}
		currentSum += root.data;
		
		int totalPaths = 0;
		if(currentSum == targetSum)
		{
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(root.left, targetSum, currentSum); // Go left
		totalPaths += countPathsWithSumFromNode(root.right, targetSum, currentSum); // Go right
		
		return totalPaths;
	}

}
