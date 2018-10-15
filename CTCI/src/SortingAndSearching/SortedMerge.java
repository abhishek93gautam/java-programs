package SortingAndSearching;

public class SortedMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int m=5;
		int[] a =new int[n+m];
		int[] b= new int[m];
		
		for(int i=1;i<=n;i++)
		{
			a[i-1]=i*2;
		}
		
		for(int j=1;j<=m;j++)
		{
			b[j-1]=j;
		}
		
		for(int i=0;i<n+m;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		for(int i=0;i<m;i++)
		{
			System.out.print(b[i]+" ");
		}
		MergeSortedArrays(a,b,n,m);
		System.out.println();
		for(int i=0;i<n+m;i++)
		{
			System.out.print(a[i]+" ");
		}
		

	}
	
	public static void MergeSortedArrays(int[] a,int[] b,int n,int m)
	{
		//start merge from the last
		// if any element is left in second array just copy them to first array
		int i = n-1;
		int j=m-1;
		int index = n+m-1;
		while(j>=0)
		{
			if(i>=0 && a[i]>b[j])
			{
				a[index]=a[i];
				i--;
			}
			else {
				a[index]=b[j];
				j--;
			}
			index--;
		}
		
	}
}
