package RecursionAndDP;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i<=3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());	
		ArrayList<ArrayList<Integer>> subsets2 = getSubsetsByBits(list);
		System.out.println(subsets2.toString());

	}
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list,int index)
	{
		ArrayList<ArrayList<Integer>> allSubsets;
		if(list.size() == index)
		{
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		}
		else {
			allSubsets = getSubsets(list,index+1);
			int item = list.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets= new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> set : allSubsets)
			{
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(set);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		
		return allSubsets;
	}
	
	static ArrayList<ArrayList<Integer>> getSubsetsByBits(ArrayList<Integer> list)
	{
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1<<list.size();
		
		for(int i=0;i<max;i++)
		{
			ArrayList<Integer> subset = convertIntToSet(i,list);
			allSubsets.add(subset);
		}
		
		return allSubsets;
	}
	
	static ArrayList<Integer> convertIntToSet(int k,ArrayList<Integer> list)
	{
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int i=k;i>0;i>>=1)
		{
			if((i&1)==1)
			{
				subset.add(list.get(index));
			}
			index++;
		}
		return subset;
	}
}
