package SortingAndSearching;

public class SparseSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
	     System.out.println(Search(stringList, "flower"));

	}
	
	public static int Search(String[] strings,String str)
	{
		if(strings==null || str==null ||str=="")
		{
			return -1;
		}
		return SearchHelper(strings, str, 0, strings.length);
	}
	
	public static int SearchHelper(String[] strings,String str,int first,int last)
	{
		if(first > last)
		{
			return -1;
		}
		int mid = (first + last)/2;
		
		//if there is empty string at mid, search of nearest non empty string else binary search
		
		while(strings[mid].isEmpty())
		{
			int left = mid -1 ;
			int right = mid+1;
			while(true)
			{
				if(left<first && right>last)
				{
					return -1;
				}
				else if(right<=last && !strings[right].isEmpty())
				{
					mid=right;
					break;
				}
				else if(left>=first && !strings[left].isEmpty())
				{
					mid=left;
					break;
				}
				left--;
				right++;
			}
		}
		
		//binary search if mid is a non empty string  
		if(str.equals(strings[mid]))
		{
			return mid;
		}
		else  if(str.compareTo(strings[mid])>0)
		{
			return SearchHelper(strings, str, mid+1, last);
		}
		else {
			return SearchHelper(strings, str, first, mid-1);
		}
	}
}
