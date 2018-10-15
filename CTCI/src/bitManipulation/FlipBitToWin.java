package bitManipulation;

public class FlipBitToWin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = flipBit(22);
		
		System.out.print(result);
	}
	
	public static int flipBit(int a)
	{
		// If all 1s , this is already the longest sequence
		if(~a==0)
		{
			return Integer.BYTES * 8;
		}
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength =1; // we can always have a sequence of atleast 1
		
		while(a!=0)
		{
			if((a&1)==1) // Current bit is 1
			{
				currentLength++;
			}
			else if((a&1)==0) //Current bit is 0
			{
				if((a&2)==0) 
				{
					previousLength=0;
				}
				else {
					previousLength=currentLength;
				}
				currentLength=0;
			}
			
			maxLength = Math.max(previousLength + currentLength +1, maxLength);
			a>>>=1;
		}
		return maxLength;
	}
}
