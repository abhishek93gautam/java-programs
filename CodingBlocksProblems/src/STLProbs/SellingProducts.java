package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SellingProducts {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[str.length];
		int m = Integer.parseInt(br.readLine());
		int max = 0;
		for(int i=0;i<str.length;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		
		//Count the frequency of elements
		int count[] = new int[1000000];
		MinimumHeap heap = new MinimumHeap(1000001);
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]+=1;
		}
		
		for(int i=0;i<count.length;i++) {
			if(count[i]>0) {
				heap.insert(count[i]);
			}
		}
		
		while(m>=heap.getMin()) {
			m=m-heap.extractMin();
		}
		
		System.out.println(heap.size());
	}

}
class MinimumHeap{
	private int size;
	private int[] harr;
	private int capacity;
	
	public MinimumHeap(int capacity) {
		// TODO Auto-generated constructor stub
		this.size=0;
		this.capacity=capacity;
		this.harr=new int[this.capacity];
	}
	
	private int parent(int i) {
		return (i-1)/2;
	}
	
	private int leftChild(int i) {
		return (2*i+1);
	}
	
	private int rightChild(int i) {
		return (2*i+2);
	}
	public int size() {
		return this.size;
	}
	public void insert(int element) {
		if(size==capacity) {
			System.out.println("Overflow");
			return;
		}
		
		size++;
		int i = size-1;
		harr[i]=element;
		
		while(i!=0 && harr[parent(i)]>harr[i]) {
			swap(i,parent(i));
			i = parent(i);
		}
		
	}
	
	public int extractMin() {
		if(size<=0) {
			System.out.println("Underflow");
			return Integer.MIN_VALUE;
		}
		if(size==1) {
			size--;
			return harr[0];
		}
		
		int popped = harr[0];
		harr[0] = harr[size-1];
		size--;
		MinHeapify(0);
		return popped;
	}
	
	public void MinHeapify(int i) {
		int l = leftChild(i);
		int r = rightChild(i);
		int smallest = i;
		
		if(l<size && harr[l]<harr[i]) {
			smallest = l;
		}
		
		if(r<size && harr[r]<harr[smallest]) {
			smallest = r;
		}
		
		if(smallest!=i) {
			swap(i,smallest);
			MinHeapify(smallest);
		}
	}
	
	public int getMin() {
		return harr[0];
	}
	public void swap(int a,int b) {
		int temp=harr[a];
		harr[a]=harr[b];
		harr[b] = temp;
	}
}
