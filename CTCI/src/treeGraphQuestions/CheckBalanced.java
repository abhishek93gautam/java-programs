package treeGraphQuestions;

public class CheckBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root)
	{
		return checkHeight(root)!=Integer.MIN_VALUE;
	}
	
	public static int checkHeight(TreeNode root)
	{
		if(root==null)
		{
			return -1;
		}
		
		int leftHeight=checkHeight(root.left);
		if(leftHeight==Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		
		int rightHeight=checkHeight(root.right);
		if(rightHeight==Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		}
		
		if(Math.abs(leftHeight-rightHeight)>1)
		{
			return Integer.MIN_VALUE;
		}
		else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
}


