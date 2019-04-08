package topFiftyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumWithoutArithmetic {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		
		int sum = getSum(n1,n2);
		System.out.println(sum);
	}
	
	// Sum of two numbers without using Arithmetic operator
	// xor 2 numbers and adding the carry which is (&)<<1;
	static int getSum(int n1,int n2) {
		if(n2==0) {
			return n1;
		}
		int partialSum = n1^n2;
		int carry = (n1&n2)<<1;
		return getSum(partialSum, carry);
	}

}
