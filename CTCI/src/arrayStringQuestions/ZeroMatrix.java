package arrayStringQuestions;

public class ZeroMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3,0},{5,6,7,8},{9,10,11,12},{13,0,15,16}};
		setZeros(matrix);
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void setZeros(int[][] matrix)
	{
		boolean[] row=new boolean[matrix.length];
		boolean[] column=new boolean[matrix[0].length];
		
		//check for zeros 
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==0)
				{
					row[i]=true;
					column[j]=true;
				}
			}
		}
		
		// Nullify rows
		for(int i=0;i<row.length;i++)
		{
			if(row[i])
			{
				NullifyRows(matrix,i);
			}
		}
		//Nullify columns
		for(int j=0;j<column.length;j++)
		{
			if(column[j])
			{
				NullifyColumns(matrix,j);
			}
		}
		
	}
	static void NullifyRows(int[][] matrix,int row)
	{
		for(int j=0;j<matrix[0].length;j++)
		{
			matrix[row][j]=0;
		}
	}
	static void NullifyColumns(int[][] matrix,int column)
	{
		for(int i=0;i<matrix.length;i++)
		{
			matrix[i][column]=0;
		}
	}

}
