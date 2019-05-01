import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubArraySumModulo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		long[] res = new long[q];
		for(int i=0;i<q;i++){
			int n = sc.nextInt();
			long m = sc.nextLong();
			
			// Fill the elements array
			Element[] arr = new Element[n];
			for(int j=0;j<n;j++){
				arr[j] = new Element();
				arr[j].first=sc.nextLong();
				arr[j].second = j+1;
			}
			
			// Taking prefix sum mod m and sorting the elements array
			arr[0].first = arr[0].first % m;
			long max = arr[0].first;
			for(int k=1;k<n;k++) {
				arr[k].first = (arr[k].first+arr[k-1].first+m)%m;
				if(max<arr[k].first) {
					max = arr[k].first;
				}
			}
			Arrays.sort(arr);
			
			long min = Long.MAX_VALUE;
			for(int z=0;z<n-1;z++) {
				if(arr[z].second>arr[z+1].second) {
					if(arr[z+1].first-arr[z].first<min) {
						min = arr[z+1].first-arr[z].first;
					}
				}
			}
			//PrintArray(arr);
			System.out.println(Math.max(max, m-min));
 
		}

	}
	
	static void PrintArray(Element[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i].first + " ");
		}
	}

}

class Element implements Comparable<Element>{
	long first;
	int second;
	public int compareTo(Element b) {
		if(this.first>b.first) {
			return 1;
		}
		else if(this.first<b.first) {
			return -1;
		}
		else {
			return 0;
		}
		
		
	} 
}
