package treeGraphQuestions;

public class Successor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = InOrderSuccessor(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
	
	public static TreeNode InOrderSuccessor(TreeNode n)
	{
		if(n==null)
		{
			return null;
		}
		
		//found right children - return leftmost node of right subtree
		if(n.right!=null)
		{
			return leftMostChild(n.right);
		}
		else {
			TreeNode q=n;
			TreeNode x=q.parent;
			
			while(x!=null && x.left!=q)
			{
				q=x;
				x=x.parent;
			}
			return x;
		}
		
	}
	
	public static TreeNode leftMostChild(TreeNode n)
	{
		if(n==null)
		{
			return null;
		}
		while(n.left!=null)
		{
			n=n.left;
		}
		return n;
	}

}
