package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class KStepsFromSortedArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		String[] str1 = br.readLine().split("\\s");
		int[] arr= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(str1[i]);
		}
		
		MinHeap minHeap = new MinHeap(k);
		
		for(int j=0;j<=k;j++)
		{
			minHeap.Add(arr[j]);
		}
		
		for(int i=k+1,index=0;index<n;i++,index++)
		{
			if(i<n)
			{
				arr[index] = minHeap.ReplaceElement(arr[i]);
			}
			else {
				arr[index] = minHeap.poll();
			}
		}
		
		//Print the array
		for(int z=0;z<n;z++)
		{
			System.out.print(arr[z]+" ");
		}
		
	}

}

class MinHeap{
	
	private Vector<Integer> A;
	
	public MinHeap()
	{
		A = new Vector();
	}
	
	public MinHeap(int capacity)
	{
		A = new Vector(capacity);
	}
	
	// return the parent of i
	private int Parent(int i)
	{
		if(i==0)
		{
			return 0;
		}
		return (i-1)/2;
	}
	
	//returns the left of i
	private int Left(int i)
	{
		return (2*i)+1;
	}
	
	//returns the right of i
	private int Right(int i)
	{
		return (2*i)+2;
	}
	
	public int size()
	{
		return A.size();
	}
	private void swap(int x,int y)
	{
		Integer temp = A.get(x);
		A.setElementAt(A.get(y), x);
		A.setElementAt(temp, y);
	}
	
	private void HeapifyDown(int i)
	{
		int left = Left(i);
		int right = Right(i);
		
		int smallest = i;
		
		//compare with left
		if(left < size() && A.get(left) < A.get(i))
		{
			smallest = left;
		}
		
		//compare with right
		if(right < size() && A.get(right) < A.get(smallest))
		{
			smallest =right;
		}
		
		if(smallest!=i)
		{
			swap(smallest,i);
			HeapifyDown(smallest);
		}
		
		
	}
	
	private void HeapifyUp(int i)
	{
		if(i>0 && A.get(Parent(i))>A.get(i))
		{
			swap(i,Parent(i));
			HeapifyUp(Parent(i));
		}
		
		
	}
	
	public int ReplaceElement(int element)
	{
		int root = A.get(0);
		A.setElementAt(element, 0);
		if(root<element)
		{
			HeapifyDown(0); 
		}
		return root;
		
		
	}
	
	public void Add(Integer element)
	{
		A.addElement(element);
		int index = size()-1;
		HeapifyUp(index);
	}
	
	public Integer poll()
	{
		try {
			if(size()==0)
			{
				throw new Exception("Index out of range");
			}
			
			int root = A.firstElement();
			A.setElementAt(A.lastElement(), 0);
			A.remove(size()-1);
			HeapifyDown(0);
			
			return root;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return null;
		}
	}
	
}
