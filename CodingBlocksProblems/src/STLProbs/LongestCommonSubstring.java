package STLProbs;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class LongestCommonSubstring{

    // Complete the substringDiff function below.
//    static int substringDiff(int k, String s1, String s2) {
//        int n = s1.length();
//        int m = s2.length();
//        int result = 0;
//        int[][] dp = new int[n+1][m+1];
//        int[][] runningLength = new int[n+1][m+1];
//        for(int i=1;i<=n;i++){
//        	char curr = s1.charAt(i-1);
//            for(int j=1;j<=m;j++){
//            	runningLength[i][j] = runningLength[i-1][j-1]+1; 
//                if(curr!=s2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                }
//                else {
//                	dp[i][j] = dp[i-1][j-1];
//                }
//                
//                while(dp[i][j]>k) {
//                	if(s1.charAt(i-runningLength[i][j])!=s2.charAt(j-runningLength[i][j])) {
//                    	dp[i][j]--;
//                	}
//                	runningLength[i][j]--;
//                }
//                result = Math.max(result,runningLength[i][j]);
//            }
//            
//        }
//        print(dp);
//        System.out.println();
//        print(runningLength);
//        return result;
//    }

	static int substringDiff(int k, String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int [][]L = new int[n+1][m+1]; 
        int [][]K = new int[n+1][m+1];

        //for(int i = 0; i<n; i++) L[0][i] = K[0][i] = 0;
        //for(int i = 0; i<m; i++) L[i][0] = K[i][0] = 0;
				
        int res = 0;
        
        for(int i = 1; i <= n; i++){
            char curr = s1.charAt(i-1);
						
            for(int j = 1; j <= m; j++){
                L[i][j] = L[i-1][j-1]+1; // running length
                K[i][j] = K[i-1][j-1] + (curr == s2.charAt(j-1) ? 0: 1); // running mismatches
                
								// calculate the  subsequence length by removing the  mismatches greater than k
                while(K[i][j] > k){
                    if(s1.charAt(i-L[i][j]) != s2.charAt(j-L[i][j])) K[i][j]--;
                    L[i][j]--;
                }
								
                res = Math.max(res, L[i][j]);
            }
        }

        return res;
    }
    static void print(int[][] dp) {
    	for(int i=1;i<dp.length;i++) {
    		for(int j=1;j<dp[0].length;j++) {
    			System.out.print(dp[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
	
    public static void main(String[] args) throws IOException {
        String s1 = "abacba";
        String s2 = "abcaba";
        int k = 2;
        int result = substringDiff(k, s1, s2);
        System.out.println(result);
    	
    }

    
}


