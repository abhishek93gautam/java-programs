package STLProbs;
import java.util.*;
import java.io.*;

public class JackGoesToRapture {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = br.readLine().replaceAll("\\s+$", "").split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);
        LinkedList<LinkedList<Integer>>[] adj = new LinkedList[gNodes+1];
        for(int i=1;i<=gNodes;i++)
        {
            adj[i] = new LinkedList<LinkedList<Integer>>();
        }
        for (int i = 0; i < gEdges; i++) {
            String[] edgesRowItems = br.readLine().split(" ");
            int u = Integer.parseInt(edgesRowItems[0]);
            int v = Integer.parseInt(edgesRowItems[1]);
            int w = Integer.parseInt(edgesRowItems[2]);
            LinkedList<Integer> pair1=new LinkedList<Integer>();
            LinkedList<Integer> pair2=new LinkedList<Integer>();

            pair1.add(v);
            pair1.add(w);
            adj[u].add(pair1);

            pair2.add(u);
            pair2.add(w);

            adj[v].add(pair2);

            
        }

        getCost(adj,gNodes);

	}
	
	public static void getCost(LinkedList<LinkedList<Integer>>[] adj,int gNodes) {
	    // Print your answer within the function and return nothing
	        //long[] distance = new long[gNodes+1];
	        boolean[] visited = new boolean[gNodes+1];
	        HeapNode[] heapNodes = new HeapNode[gNodes+1];
	        for(int i=1;i<=gNodes;i++)
	        {
	            heapNodes[i] = new HeapNode();
	            heapNodes[i].vertex=i;
	            heapNodes[i].distance = Long.MAX_VALUE;
	        }
	        heapNodes[1].distance = 0;
	        MinHeapDijkStra minHeap = new MinHeapDijkStra(gNodes);
	        for(int i=1;i<=gNodes;i++)
	        {
	        	minHeap.insert(heapNodes[i]);
	        }
	        //distance[1] = 0;
	        while(!minHeap.isEmpty()){
	            HeapNode u = minHeap.ExtractMin();
	            int extractedVertex = u.vertex;
	            visited[extractedVertex] = true;
	            for(LinkedList<Integer> neighBor : adj[extractedVertex]){
	                int v = neighBor.get(0);
	                int w = neighBor.get(1);
	                long newDistance = w - heapNodes[extractedVertex].distance;
	                if(newDistance<0){
	                    newDistance = 0;
	                }

	                if(!visited[v] && heapNodes[extractedVertex].distance+newDistance < heapNodes[v].distance ){
	                	decreaseKey(minHeap, heapNodes[extractedVertex].distance+newDistance, v);
	                	heapNodes[v].distance = heapNodes[extractedVertex].distance+newDistance;
	                }
	            }
	        }
	        if(heapNodes[gNodes].distance!=Long.MAX_VALUE){
	            System.out.println(heapNodes[gNodes].distance);
	        }
	        else{
	            System.out.println("NO PATH EXISTS");
	        }

	    }
	    static void decreaseKey(MinHeapDijkStra minHeap,long newKey,int vertex) {
	    	int index = minHeap.indexes[vertex];
	    	HeapNode node = minHeap.mH[index];
	    	node.distance = newKey;
	    	minHeap.bubbleUp(index);
	    }

}

class HeapNode{
	int vertex;
	long distance;
}

class MinHeapDijkStra{
	int capacity;
	int size;
	HeapNode[] mH;
	int[] indexes; // will be used to decrease the distance
	
	public MinHeapDijkStra(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		size=0;
		mH = new HeapNode[this.capacity];
		indexes = new int[this.capacity+1];
		
	}
	public boolean isEmpty() {
		return size==0;
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
	
	public void insert(HeapNode x) {
		if(size==capacity) {
			System.out.println("Overflow");
			return;
		}
		
		size++;
		int idx = size-1;
		mH[idx] = x;
		indexes[x.vertex] = idx;
		bubbleUp(idx);
		
		
	}
	
	public void bubbleUp(int pos) {
		while(pos!=0 && mH[parent(pos)].distance>mH[pos].distance) {
			HeapNode currentNode = mH[pos];
            HeapNode parentNode = mH[parent(pos)];
            
            indexes[currentNode.vertex] = parent(pos);
            indexes[parentNode.vertex] = pos;
			swap(parent(pos),pos);
			pos = parent(pos);
		}
		
	}
	
	public HeapNode ExtractMin() {
		if(size<=0) {
			System.out.println("Underflow");
			return null;
		}
		if(size==1) {
			size--;
			return mH[0];
		}
		HeapNode h = mH[0];
		HeapNode last = mH[size-1];
		indexes[last.vertex]=0;
		mH[0] =last;
		mH[size-1]=null;
		size--;
		MinHeapify(0);
		return h;
		
	}
	
	private void MinHeapify(int pos) {
		int smallest = pos;
		int left = leftChild(pos);
		int right = rightChild(pos);
		
		if(left<size && mH[left].distance < mH[pos].distance) {
			smallest = left;
		}
		
		if(right<size && mH[right].distance < mH[smallest].distance) {
			smallest = right;
		}
		
		if(smallest!=pos) {
			HeapNode smallestNode = mH[smallest];
            HeapNode kNode = mH[pos];

            //swap the positions
            indexes[smallestNode.vertex] = pos;
            indexes[kNode.vertex] = smallest;
			swap(pos,smallest);
			MinHeapify(smallest);
		}
	}
	
	public void swap(int i,int j) {
		HeapNode temp = mH[i];
		mH[i] = mH[j];
		mH[j] = temp;
	}
	
	
}
