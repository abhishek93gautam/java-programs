package treeGraphQuestions;

public class ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBst = checkIsBST(node);
		System.out.println(isBst);

	}
	
	public static boolean checkIsBST(TreeNode n, Integer min,Integer max)
	{
		if(n==null)
		{
			return true;
		}
		
		if((min!=null && n.data<=min) || (max!=null && n.data>max))
		{
			return false;
		}
		
		if(!checkIsBST(n.left,min,n.data) || !checkIsBST(n.right,n.data,max))
		{
			return false;
		}
		return true;
	}
	
	public static boolean checkIsBST(TreeNode n)
	{
		return checkIsBST(n,null,null);
	}
}
