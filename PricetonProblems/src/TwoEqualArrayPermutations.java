import java.io.*;

public class TwoEqualArrayPermutations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		
		int[] arr1 = new int[str1.length];
		int[] arr2 = new int[str2.length];
		
		for(int i=0;i<str1.length;i++) {
			arr1[i] = Integer.parseInt(str1[i]);
		}
		
		for(int i=0;i<str2.length;i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		
		boolean checkPer = CheckPermutations(arr1,arr2);
		System.out.println(checkPer);

	}
	
	static boolean CheckPermutations(int[] arr1,int[] arr2) {
		
		if(arr1.length!=arr2.length) {
			return false;
		}
		int xor1 = 0;
		int xor2 = 0;
		
		for(int i=0;i<arr1.length;i++) {
			xor1^=arr1[i];
		}
		for(int i=0;i<arr2.length;i++) {
			xor2^=arr2[i];
		}
		
		System.out.println(xor1 +"  "+xor2);
		if(xor1==xor2) {
			return true;
		}
		return false;
	}

}
