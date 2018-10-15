package treeGraphQuestions;

public class CheckSubtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = createTreeFromArray(array1);
		TreeNode t2 = createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 1, 5};
		TreeNode t3 = createTreeFromArray(array1);
		TreeNode t4 = createTreeFromArray(array3);

		if (containsTree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}

	}
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}
	
	public static boolean checkTree(TreeNode root1,TreeNode root2)
	{
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		
		MakePreOrderString(root1,str1);
		MakePreOrderString(root2,str2);
		
		if(str1.indexOf(str2.toString())!=-1)
		{
			return true;
		}
		return false;
	}
	
	
	public static void MakePreOrderString(TreeNode root,StringBuilder str)
	{
		if(root==null)
		{
			str.append("X");
			return;
		}
		
		str.append(root.data);
		MakePreOrderString(root.left,str);
		MakePreOrderString(root.right,str);
		
	}
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true; // The empty tree is a subtree of every tree.
		}
		return subTree(t1, t2);
	}
	
	/* Checks if the binary tree rooted at r1 contains the binary tree 
	 * rooted at r2 as a subtree somewhere within it.
	 */
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false; // big tree empty & subtree still not found.
		} else if (r1.data == r2.data && matchTree(r1,r2)) {
			return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2); 
	}
	
	public static boolean matchTree(TreeNode root1,TreeNode root2)
	{
		if(root1==null && root2==null)
		{
			return true; // nothing left in both trees
		}
		else if(root1==null || root2==null)
		{
			return false; // one tree is empty and other is not
		}
		else if(root1.data!=root2.data)
		{
			return false; // data does not match 
		}
		else {
			return matchTree(root1.left,root2.left) && matchTree(root1.right,root2.right);
		}
	}
	
	

}
