package RecursionAndDP;

import java.util.ArrayList;

public class EightQueens {

	public static int GRID_SIZE = 5;
	public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++){
			    if (columns[i] == j) {
			    	System.out.print("Q|");
			    } else {
			    	System.out.print(" |");
			    }
			}
            System.out.print("\n");
            drawLine();
		}
		System.out.println("");
	}

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }
    
    public static void printBoards(ArrayList<Integer[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}
	public static void clear(Integer[] columns) {
		for (int i = 0; i < GRID_SIZE; i++) {
			columns[i] = -1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		clear(columns);
		placeQueens(0, columns, results);
		printBoards(results);
		System.out.println(results.size());

	}
	
	static void placeQueens(int row,Integer[] columns,ArrayList<Integer[]> results)
	{
		if(row==GRID_SIZE)
		{
			results.add(columns.clone());
		}
		else {
			for(int col=0;col<GRID_SIZE;col++)
			{
				if(checkValid(columns,row,col))
				{
					columns[row] = col;
					placeQueens(row+1,columns,results);
				}
			}
		}
	}
	
	static boolean checkValid(Integer[] columns,int row1,int col1)
	{
		for(int row2=0;row2<row1;row2++)
		{
			int col2 = columns[row2];
			
			//check if rows have a queen in same column
			if(col1==col2)
			{
				return false;
			}
			
			//check if rows have a queen in same diagonal - distance between rows = distance between columns
			int colDistance = Math.abs(col2 - col1);
			
			int rowDistance = Math.abs(row2-row1);
			if(colDistance==rowDistance)
			{
				return false;
			}
		}
		return true;
	}

}
