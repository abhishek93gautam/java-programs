package topFiftyQuestions;
import java.util.*;

public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(3);
		stk.push(2);
		stk.push(1);
		stk.push(9);
		stk.push(7);
		System.out.println("Original stack: "+stk);
		ReverseStack(stk);
		System.out.println("Reversed stack: "+stk);

	}
	
	static Stack<Integer> ReverseStack(Stack<Integer> stk) {
		if(stk.isEmpty()) {
			return stk;
		}
		int x = stk.pop();
		ReverseStack(stk);
		ReverseStackHelper(stk,x);
		return stk;
	}
	
	static void ReverseStackHelper(Stack<Integer> stk,int x) {
		if(stk.isEmpty()) {
			stk.push(x);
			return;
		}
		int temp = stk.pop();
		ReverseStackHelper(stk,x);
		stk.push(temp);
		
	}


}
