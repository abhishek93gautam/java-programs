package arrayStringQuestions;

public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("Input Matrix");
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Result");
		boolean result=IsRotation(matrix);
		if(result)
		{
			for(int i=0;i<matrix.length;i++)
			{
				for(int j=0;j<matrix[i].length;j++)
				{
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
		}
		else{
			System.out.print("Rotation not possible.Not Square matrix");
		}

	}
	
	static boolean IsRotation(int[][] matrix){
		//check if matrix is square matrix
		if(matrix.length==0 || matrix.length!=matrix[0].length)
		{
			return false;
		}
		
		int n=matrix.length;
		//layer wise traverse the matrix
		for(int layer=0;layer<n/2;layer++)
		{
			int first=layer;
			int last=n-1-layer;
			for(int i=first;i<last;i++)
			{
				int offset=i-first;
				//save the top element
				int top=matrix[first][i];
				
				//left-->top
				matrix[first][i]=matrix[last-offset][first];
				
				//bottom-->left
				matrix[last-offset][first]=matrix[last][last-offset];
				
				//right-->bottom
				matrix[last][last-offset]=matrix[i][last];
				
				//top-->right
				matrix[i][last]=top;
				
				
			}
		}
		return true;
	}
}
