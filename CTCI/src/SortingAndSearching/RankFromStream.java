package SortingAndSearching;

public class RankFromStream {
	public static RankNode root =null;
	public static void track(int number)
	{
		if(root==null)
		{
			root = new RankNode(number);
		}
		else {
			root.insert(number);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//int[] list = randomArray(size, -100, 100);
		int[] list = {20,15,25,10,23,5,13,24}; 
		int size = list.length;
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}
		
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = root.getRank(list[i]);
			System.out.print(rank1+" ");
		}
	}

}

class RankNode
{
	public int left_size=0;
	public RankNode left,right;
	public int data = 0;
	public RankNode(int d)
	{
		data = d;
	}
	
	public void insert(int d)
	{
		if(d<=data)
		{
			if(left!=null)
			{
				left.insert(d);
			}
			else {
				left = new RankNode(d);
			}
			left_size++;
		}
		else {
			if(right!=null)
			{
				right.insert(d);
			}
			else {
				right=new RankNode(d);
			}
		}
	}
	
	public int getRank(int d) {
		if (d == data) {
			return left_size;
		} else if (d < data) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(d);
			}
		} else {
			int right_rank = right == null ? -1 : right.getRank(d);
			if (right_rank == -1) {
				return -1;
			} else {
				return left_size + 1 + right_rank;
			}
		}
	}
	
}
