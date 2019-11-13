/*
 * Maze -- Creates our maze
 * Jason Melnik
 * CSC - 121
 * 3/21/2019
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private static final int TRIED = 2;
	private static final int PATH = 3;
	
	private int numberRows, numberColumns;
	private int[][] grid;
	
	public Maze(String filename) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File(filename));
		numberRows = scan.nextInt();
		numberColumns = scan.nextInt();
		
		grid = new int[numberRows][numberColumns];
		for(int i = 0; i < numberRows; i++) {
			for(int x = 0; x < numberColumns; x++){
				grid[i][x] = scan.nextInt();
			}
			
		}
	}
	public void tryPosition(int row, int col) {
		grid[row][col] = TRIED;
	}
	
	public int getRows() {
		return grid.length;
	}
	
	public int getColumns() {
		return grid[0].length;
	}
	
	public void markPath(int row, int col) {
		grid[row][col] = PATH;
	}
	
	public boolean validPosition(int row, int column) {
		boolean result = false;
		
		if(row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) {
			if(grid[row][column] == 1)
				result = true;
		}
		return result;
	}
	
	public String toString() {
		String result = "\n";
		for(int row = 0; row < grid.length; row++) {
			for(int column = 0; column < grid[row].length; column++) {
				result += grid[row][column] + "";
			}
			result += "\n";
		}
		return result;
	}
	
		
}
