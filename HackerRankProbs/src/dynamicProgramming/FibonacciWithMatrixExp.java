package dynamicProgramming;

public class FibonacciWithMatrixExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final FibonacciFinder fibonacciFinder = new FibonacciFinder();
//        for (int i = 0; i < 6; i++) {
//            System.out.println(fibonacciFinder.fib(i));
//        }
        System.out.println(fibonacciFinder.fib(10));
        System.out.println("Fast exponent : "+power(2,12));

	}
	
	
	//calculating power using fast exponentiation - Time complexity - O(log(n))
	// returns a raise to power n
	static int power(int a,int n)
	{
		if(n==0)
		{
			return 0;
		}
		if(n==1)
		{
			return a;
		}
		int r = power(a,n/2);
		if(n%2==0)
		{
			return r*r;
		}
		else {
			return r*r*a;
		}
	}

}

class FibonacciFinder{
	private final long[][][] exponents;
	
	public FibonacciFinder()
	{
		// making the exponents matrix upto 64
		exponents = new long[64][2][2];
		exponents[0] = new long[][]{{1, 1}, {1, 0}};
		for (int i = 1; i < exponents.length; i++) {
            exponents[i] = square(exponents[i - 1]);
        }
	}
	
	 private long[][] square(final long[][] matrix) {
	        return multiply(matrix, matrix);
	 }
	 
	 
	 //Standard matrix multiplication
	 private long[][] multiply(final long[][] matrix1, final long[][] matrix2) {
	        final long[][] result = new long[matrix1[0].length][matrix2.length];
	        for (int i = 0; i < matrix1.length; i++) {
	            for (int j = 0; j < matrix2[0].length; j++) {
	                for (int k = 0; k < matrix1[i].length; k++) {
	                    result[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
	        return result;
	    }
	 
	 public long fib(int n) {
	        if (n < 0) {
	            throw new IllegalArgumentException();
	        } else if (n == 0 || n == 1) {
	            return 1;
	        } else {
	            final long[][] matrix = binaryExponentiation(n - 1);
	            //printing the final n-1 exponent matrix
	            System.out.println(matrix[0][0] + " "+ matrix[0][1]);
	            System.out.println(matrix[1][0] + " "+ matrix[1][1]);
	            return matrix[0][0] + matrix[0][1];
	        }
	    }

	    private long[][] binaryExponentiation(final int n) {
	    	// Identity matrix
	        long[][] result = new long[][]{{1, 0}, {0, 1}};
	        for (int i = 31; i >= 0; i--) {
	            if ((n & (1 << i)) != 0) {
	                result = multiply(result, exponents[i]);
	            }
	        }
	        return result;
	    }
}
