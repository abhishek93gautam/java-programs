package treeGraphQuestions;

import java.util.Stack;

public class FirstCommonAncestor {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(4);
		TreeNode n7 = root.find(10);
		TreeNode ancestor = commonAncestorNew(root,n3, n7);
		System.out.println(ancestor!=null?ancestor.data:"One of nodes not found in tree");
		
		// LCA with path approach
		Integer lca = LCAViaPath(root,4,10);
		if(lca!=null)
		{
			System.out.println(lca);
		}
		else {
			System.out.println("No lca found");
		}
	}
	
	
	// With links to Parents
	/*public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int delta = depth(p) - depth(q); // get difference in depths
		TreeNode first = delta > 0 ? q : p; // get shallower node
		TreeNode second = delta > 0 ? p : q; // get deeper node
		second = goUpBy(second, Math.abs(delta)); // move shallower node to depth of deeper
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null ? null : first;
	}
	
	public static TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}
	
	public static int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}	
	*/
	
	// Without links to parents - Not optimized
	/*public static TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q)
	{
		//Error check - if one node is not in the tree
		if(!covers(root,p) || !covers(root,q))
		{
			return null;
		}
		return ancestorHelper(root,p,q);
	}
	
	public static TreeNode ancestorHelper(TreeNode root,TreeNode p,TreeNode q)
	{
		if(root==null || root == p || root==q)
		{
			return root;
		}
		
		boolean pisOnLeft = covers(root.left,p);
		boolean qisOnLeft = covers(root.left,q);
		if(pisOnLeft!=qisOnLeft) // Nodes are on different side
		{
			return root;
		}
		TreeNode childSide = pisOnLeft ? root.left : root.right;
		return ancestorHelper(childSide,p,q);
	}
	
	public static boolean covers(TreeNode root,TreeNode node)
	{
		if(root==null)
		{
			return false;
		}
		if(root==node)
		{
			return true;
		}
		return covers(root.left,node) || covers(root.right,node); 
	}*/
	
	// Without links to parents -  optimized version
	public static TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q)
	{
		//Error check - if one node is not in the tree
		if(!covers(root,p) || !covers(root,q))
		{
			return null;
		}
		return ancestorHelper(root,p,q);
	}
	
	public static TreeNode ancestorHelper(TreeNode root,TreeNode p,TreeNode q)
	{
		if(root==null)
		{
			return null;
		}
		if(root==p && root==q)
		{
			return root;
		}
		
		TreeNode x= ancestorHelper(root.left,p,q);
		if(x!=null && x!=p && x!=q) //Already found ancestor
		{
			return x;
		}
		
		TreeNode y = ancestorHelper(root.right,p,q);
		if(y!=null && y!=p && y!=q)
		{
			return y;
		}
		
		if(x!=null && y!=null) // p and q found in different subtree
		{
			return root; //this is common ancestor
		}
		else if(root==p || root==q)
		{
			return root;
		}
		else {
			return x==null?y:x;
		}
		
	}
	
	public static boolean covers(TreeNode root,TreeNode node)
	{
		if(root==null)
		{
			return false;
		}
		if(root==node)
		{
			return true;
		}
		return covers(root.left,node) || covers(root.right,node); 
	}
	
	
	// This function has a limit - both nodes must be present in the tree
	public static TreeNode commonAncestorNew(TreeNode root,TreeNode p,TreeNode q)
	{
		if(root==null)
		{
			return null;
		}
		if(root==p || root==q)
		{
			return root;
		}
		
		TreeNode left = commonAncestorNew(root.left,p,q);
		TreeNode right = commonAncestorNew(root.right,p,q);
		
		if(left!=null && right!=null)
		{
			return root;
		}
		
		return left!=null?left:right;
	}
	
	public static Stack<Integer> pathToX(TreeNode root,int p)
	{
		if(root==null)
		{
			return null;
		}
		if(root.data==p)
		{
			return new Stack<Integer>();
		}
		
		Stack<Integer> leftPath = pathToX(root.left,p);
		if(leftPath!=null)
		{
			leftPath.add(root.data);
			return leftPath;
		}
		
		Stack<Integer> rightPath = pathToX(root.right,p);
		if(rightPath!=null)
		{
			rightPath.add(root.data);
			return rightPath;
		}
		
		return null;
	}
	
	public static Integer LCAViaPath(TreeNode root,int j,int k)
	{
		Stack<Integer> pathToJ = pathToX(root,j);
		Stack<Integer> pathToK = pathToX(root,k);
		
		Integer LCA = null;
		if(pathToJ!=null && pathToK!=null)
		{
			while(!pathToJ.isEmpty() && !pathToK.isEmpty())
			{
				int jPop = pathToJ.pop();
				int kPop = pathToK.pop();
				if(jPop == kPop)
				{
					LCA = jPop;
				}
				else {
					break;
				}
			}
		}
		
		return LCA;
		
	}
}
