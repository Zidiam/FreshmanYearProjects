import java.util.*;
import java.io.*;

public class Position {

	private static final int TRIED = 2;
	private static final int PATH = 3;
	
	private int numberRows, numberColumns;
	private int [] [] grid;
	
	public Position(String someFile) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File(someFile));
		numberRows = scan.nextInt();
		numberColumns = scan.nextInt();
		
		grid = new int[numberRows] [numberColumns];
		for (int i = 0; i < numberRows; i++)
			for (int j = 0; j < numberColumns; j++)
				grid [i][j] = scan.nextInt();
	
	}
	
	public void tryPosition(int row, int col)
	{
		grid[row] [col] = TRIED;
	}
	
	public int getColumns()
	{
		return grid[0].length;
	}

	public void markPath(int row, int col)
	{
		grid[row] [col] = PATH;
	}
	
	public boolean validPosition(int row, int column)
	{ 
		boolean result = false;
		if (row >= 0 && row < grid.length &&
				column >= 0 && column < grid[row].length)
			
			if (grid[row][column] == 1)
				result = true;
		return result;
		
	}
	
	public String toSTring()
	{
		String result = "\n";
		
		for (int row=0; row < grid.length; row++)
		{
			for (int column=0; column < grid[row].length; 
	column++)
				result += grid[row] [column] + "";
			result += "\n";
		}
		return result;
		
		}
	






}
	
	
	
	
	

