package topFiftyQuestions;

import java.util.ArrayList;
import java.util.*;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = {{1},{2,5},{3,6,9,19,100}};
		ArrayList<Integer> res = mergeKarrays(arrays);
		
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}

	}
	
	static ArrayList<Integer> mergeKarrays(int[][] arrays) {
		int k = arrays.length;
		
		PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
		
		//Insert the first elements into priorityQueue
		for(int i=0;i<k;i++) {
			if(arrays[i].length>0) {
				pq.add(new QueueNode(i,0,arrays[i][0]));
			}
		}
		
		ArrayList<Integer> res = new ArrayList();
		while(!pq.isEmpty()) {
			QueueNode node = pq.poll();
			res.add(node.data);
			int newIndex = node.index+1;
			if(newIndex<arrays[node.array].length) {
				pq.add(new QueueNode(node.array,newIndex,arrays[node.array][newIndex]));
			}
		}
		
		return res;
	}

}

class QueueNode implements Comparable<QueueNode>{
	int array;
	int index;
	int data;
	public QueueNode(int array,int index,int data) {
		this.array = array;
		this.index = index;
		this.data = data;
	}
	public int compareTo(QueueNode n) {
		if(this.data>n.data) {
			return 1;
		}
		else if(this.data<n.data) {
			return -1;
		}
		return 0;
	}
}
