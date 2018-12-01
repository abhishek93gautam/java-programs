package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class DpWithBitMaskCapProb {

	static final int MOD = 1000000007; 
    // for input 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      
    // capList[i]'th vector contains the list of persons having a cap with id i 
    // id is between 1 to 100 so we declared an array of 101 vectors as indexing 
    // starts from 0. 
    static Vector<Integer> capList[] = new Vector[101]; 
      
       
    // dp[2^10][101] .. in dp[i][j], i denotes the mask i.e., it tells that 
    // how many and which persons are wearing cap. j denotes the first j caps 
    // used. So, dp[i][j] tells the number ways we assign j caps to mask i 
    // such that none of them wears the same cap 
    static int dp[][] = new int[1025][101]; 
       
    // This is used for base case, it has all the N bits set 
    // so, it tells whether all N persons are wearing a cap. 
    static int allmask; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n;
		// initializing vector array 
        for (int i = 0; i < capList.length; i++) 
            capList[i] = new Vector(); 
          
          
        n = Integer.parseInt(br.readLine()); 
        countWays(n);

	}
	
	static void countWays(int n) throws IOException
	{
		String str; 
        String split[]; 
        int x; 
                
        for (int i=0; i<n; i++) 
        { 
            str = br.readLine(); 
            split = str.split(" "); 
            
            // while there are words in the split[] 
            for (int j = 0; j < split.length; j++) { 
                 // add the ith person in the list of cap if with id x 
                x = Integer.parseInt(split[j]); 
                capList[x].add(i); 
            } 
            
        } 
        
        // All mask is used to check of all persons 
        // are included or not, set all n bits as 1 
        allmask = (1 << n) - 1; 
        
        for (int[] is : dp) { 
            for (int i = 0; i < is.length; i++) { 
                is[i] = -1; 
            } 
        } 
       
        // Call recursive function count ways 
        System.out.println(countWaysUtil(0, 1));
	}
	
	static int countWaysUtil(int mask,int i)
	{
		//all persons are wearing a cap and we don't need to check more
		if(allmask==mask)
		{
			return 1;
		}
		
		// No more caps
		if(i>100)
		{
			return 0;
		}
		
		// If already computed then return
		if(dp[mask][i]!=-1)
		{
			return dp[mask][i];
		}
		
		//count ways when this ith cap is not included in solution
		int ways = countWaysUtil(mask,i+1);
		
		//if included then check which person is wearing this cap and then recurse 
		int size = capList[i].size();
		for(int j=0;j<size;j++)
		{
			// if that person is already wearing a cap then continue
			if((mask & (1<<capList[i].get(j)))!=0)
				continue;
			else {
				ways+= countWaysUtil(mask|(1<<capList[i].get(j)),i+1);
			}
			ways%=MOD;
			
		}
		dp[mask][i] = ways;
		return ways;
		
	}
}
