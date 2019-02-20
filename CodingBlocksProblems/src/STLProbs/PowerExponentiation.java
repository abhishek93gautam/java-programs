package STLProbs;

public class PowerExponentiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 999;
		int p = 5;
		int mod = 1000000007;
		
		modInverse(x, mod);

	}
	static void modInverse(int a, int m) 
    { 
        if (__gcd(a, m) != 1) 
            System.out.print("Inverse doesn't exist"); 
      
        else { 
      
            // If a and m are relatively prime, then 
            // modulo inverse is a^(m-2) mode m 
            System.out.print("Modular multiplicative inverse is "
                                            +power(a, m - 2, m)); 
        } 
    } 
	
	static int __gcd(int a, int b) 
    { 
      
        if(b == 0)  
        { 
            return a; 
        } 
        else 
        { 
            return __gcd(b, a % b); 
        } 
    } 
	
	static int power(int x,int p,int mod) {
		int res =1;
		x = x%mod;
		while(p>0) {
			if((p&1)==1) {
				res = (res*x)%mod;
			}
			p=p>>1;
			x=(x*x)%mod;
		}
		
		return res;
	}
}
