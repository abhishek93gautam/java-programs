package SortingAndSearching;

public class SortedSearchNoSIze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
		Listy list = new Listy(array);
		for (int a : array) {
			System.out.print(search(list, a)+" ");
		}
		System.out.println(search(list, 19));

	}
	
	static int search(Listy list,int x)
	{
		int index = 1;
		while(list.elementAt(index)!=-1 && list.elementAt(index)<x)
		{
			index*=2;
		}
		return binarySearch(list,x,index/2,index);
	}
	
	static int binarySearch(Listy list,int x,int start,int end)
	{
		int mid;
		int low = start;
		int high = end;
		while(low<=high)
		{
			mid = (low+high)/2;
			int middle = list.elementAt(mid);
			if(middle > x || middle==-1)
			{
				high = mid-1;
			}
			else if(middle<x)
			{
				low = mid+1;
			}
			else
			{
				return mid;
			}
			
		}
		return -1;
	}

}

class Listy {
	int[] array;
	
	public Listy(int[] arr) {
		array = arr.clone();
	}
	
	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}
}
