
public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(reverse(123));

	}
	public static int reverse(int x) {
        try {
        	int rev=0;
        	while(x!=0)
        	{
        		int rem = x%10;
        		int newRev = (rev*10)+rem;
        		if((newRev-rem)/10!=rev)
        		{
        			return 0;
        		}
        		rev=newRev;
        		x=x/10;
        	}
        	
        	return rev;
        }
        catch(Exception e)
        {
        	return 0;
        }
    }
}
