package bitManipulation;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 103217;
		System.out.println(toFullBinaryString(a));
		int b = 13;
		System.out.println(toFullBinaryString(b));		
		int c = updateBits(a, b, 4, 12);
		System.out.println(toFullBinaryString(c));
	}
	
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}
	
	public static int updateBits(int n,int m,int i,int j)
	{
		if(i>=32 || j<i)
		{
			return 0;
		}
		
		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
		
		int allOnes = ~0;
		int left = allOnes<<(j+1); // 1s through position j, then 0s. left = 11100000	
		int right = ((1<<i) -1);  // 1’s after position i.  right = 00000011
		
		int mask =left | right;  // All 1s, except for 0s between i and j. mask = 11100011
		/* Clear i through j, then put m in there */
		
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		
		/* OR them, and we're done! */
		return n_cleared | m_shifted;
	}

}
