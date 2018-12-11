package RecursionAndDP;

public class Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denoms = {3,2,1};
		int ways = makeChange(4, denoms);
		System.out.println(ways);
		int ways1 = makeChangeTopDown(4, denoms,denoms.length-1);
		System.out.println(ways1);
	}
	
	public static int makeChange(int n, int[] denoms) {
		int[][] map = new int[n + 1][denoms.length];
		return makeChange(n, denoms, 0, map);
	}
	
	public static int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) { // retrieve value
			return map[amount][index];
		}
		if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			// go to next denom, assuming i coins of denomAmount
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}	
	
	public static int makeChangeTopDown(int amount,int[] denoms,int index)
	{
		int[][] dp = new int[amount+1][denoms.length+1];
		return makeChangeTopDownHelper(amount,denoms,index,dp);
	}
	
	public static int makeChangeTopDownHelper(int amount,int[] denoms,int index,int[][] dp)
	{
		if(amount<0)
		{
			return 0;
		}
		if(amount==0)
		{
			return 1;
		}
		if(index<0)
		{
			return 0;
		}
		
		if(dp[amount][index]==0)
		{
			dp[amount][index]=makeChangeTopDownHelper(amount-denoms[index],denoms,index,dp)+makeChangeTopDownHelper(amount,denoms,index-1,dp);
		}
		return dp[amount][index];
	}

}
