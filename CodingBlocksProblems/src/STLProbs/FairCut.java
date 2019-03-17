package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FairCut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        long[] arr = new long[n];

        String[] arrItems = br.readLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        long result = fairCut(k, arr);
        System.out.println(result);

	}
	
	static long fairCut(int k, long[] a) {
        /*
         * Write your code here.
         */
         int n = a.length;
         Arrays.sort(a);
         long[][] dp = new long[n+1][k+1];
         for(int i=0;i<=n;i++){
             for(int j=0;j<=k;j++){
                 dp[i][j] = Long.MAX_VALUE;
             }
         }
         dp[0][0] = 0;
         for (int i = 0; i < n; i++){
            for (int j = 0; j <= i && j <= k; j++) {
                if (dp[i][j] < Long.MAX_VALUE) {
                    int my = j, his = i - j;
                    if (my < k) {
                        long add = (long)(a[i]) * (his - (n - k - his));
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + add);
                    }
                    if (his < n - k) {
                        long add = (long)(a[i]) * (my - (k - my));
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + add);
                    }
                }
            }
                
        }
        
        
        return dp[n][k];

    }

}
