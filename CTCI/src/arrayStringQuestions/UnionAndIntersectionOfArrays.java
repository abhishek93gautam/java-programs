package arrayStringQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionAndIntersectionOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,4,5,1,6,8,9,10};
		int[] b = {4,5,1,6,0,14,20};
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		ArrayList<Integer> common = getCommon(a,b);
		ArrayList<Integer> aNotB = getANotB(a,b);
		ArrayList<Integer> bNotA = getBNotA(a,b);
		System.out.println(common);
		System.out.println(aNotB);
		System.out.println(bNotA);
		

	}
	
	static ArrayList<Integer> getCommon(int[] a,int[] b){
		ArrayList<Integer> result = new ArrayList();
		int i=0;
		int j=0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				i++;
			}
			else if(a[i]>b[j]) {
				j++;
			}
			else {
				result.add(a[i]);
				i++;
				j++;
			}
		}
		
		return result;
	}
	
	static ArrayList<Integer> getANotB(int[] a,int[] b){
		ArrayList<Integer> result = new ArrayList();
		int i=0;
		int j=0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				result.add(a[i]);
				i++;
			}
			else if(a[i]>b[j]) {
				j++;
			}
			else {
				i++;
				j++;
			}
		}
		while(i<a.length) {
			result.add(a[i]);
			i++;
		}
		return result;
	}
	static ArrayList<Integer> getBNotA(int[] a,int[] b){
		ArrayList<Integer> result = new ArrayList();
		int i=0;
		int j=0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				i++;
			}
			else if(a[i]>b[j]) {
				result.add(b[j]);
				j++;
			}
			else {
				i++;
				j++;
			}
		}
		while(j<b.length) {
			result.add(b[j]);
			j++;
		}
		return result;
	}
	

}
