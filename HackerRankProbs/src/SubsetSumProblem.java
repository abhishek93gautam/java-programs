import java.util.ArrayList;

public class SubsetSumProblem {

	//Count number of subsets of a set whose sum is greater than a given value
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("Number of subsets : "+countSubsets(list,4));

	}
	
	static int countSubsets(ArrayList<Integer> list,int sum)
	{
		int count = 0;
		int size = (int)Math.pow(2,list.size());
		for(int i=0;i<size;i++)
		{
			if(countSubsetsHelper(list,i,sum))
			{
				count++;
			}
		}
		return count;
	}
	
	static boolean countSubsetsHelper(ArrayList<Integer> list,int i,int sum)
	{
		int s=0;
		int index = 0;
		for(int j=i;j>0;j>>=1)
		{
			if((j&1)==1)
			{
				s+=list.get(index);
			}
			index++;
		}
		if(s > sum)
		{
			return true;
		}
		
		return false;
	}
}
