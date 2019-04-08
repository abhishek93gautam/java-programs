package codeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BathroomStalls {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		PriorityQueue<Stall> stalls = new PriorityQueue<>(new StallComparator());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			String[] nk = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			stalls.clear();
			
			stalls.add(new Stall(0,n+1));
			int max = 0;
			int min=0;
			
			for(int j=0;j<k;j++) {
				Stall largest = stalls.poll();
				int middle = (largest.nearestRight+largest.nearestLeft)>>1;
				stalls.add(new Stall(middle,largest.nearestRight));
				stalls.add(new Stall(largest.nearestLeft,middle));
				
				max = Math.max(largest.nearestRight-middle, middle-largest.nearestLeft)-1;
				min = Math.min(largest.nearestRight-middle, middle-largest.nearestLeft)-1;
			}
			sb.append("Case #").append(i + 1).append(": ").append(max).append(" ").append(min).append('\n');
		}
		
		System.out.println(sb);

	}

}


class Stall {
	int nearestLeft;
	int nearestRight;
	
	Stall(int nearestLeft,int nearestRight){
		this.nearestLeft = nearestLeft;
		this.nearestRight = nearestRight;
	}
	
	public String toString() {
        return "{L=" + nearestLeft + ", R=" + nearestRight + "}";
    }
}


class StallComparator implements Comparator<Stall>{
	public int compare(Stall s1,Stall s2) {
		int size1 = s1.nearestRight - s1.nearestLeft;
		int size2 = s2.nearestRight - s2.nearestLeft;
		if(size1!=size2) {
			return size2-size1;
		}
		else {
			return s1.nearestLeft - s2.nearestLeft;
		}
	}
}
