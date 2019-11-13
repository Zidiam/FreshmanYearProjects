import java.io.*;
import java.util.*;

public class MazeSolver {
   private char[][] maze;
   private int startx,starty,saveRow,saveCol,savey,savex;
  
   public void printMaze(){
      for(int i = 0; i < saveRow; i++){
         for(int j = 0; j < saveCol; j++){
            System.out.print(maze[i][j]);
         }
         System.out.println();
      }
   }
  
   public boolean solveMaze(char[][] maze, int x, int y){
      if(x < 0 || x > saveCol){
         maze[savey][savex] = '+';
         return false;
      }
      if(y < 0 || y > saveRow){
         maze[savey][savex] = '+';
         return false;
      }
      if(maze[y][x] == 'E'){
    	  maze[y][x] = '+';
         return true;
      }
      if(maze[y][x] == 'X'){
         return false;
      }
      if(maze[y][x] == '+'){
         return false;
      }
    
      savex = x;
      savey = y;
      maze[y][x] = '+';
    
      //north of position
      if(solveMaze(maze, x, y-1) == true){
         return true;
      }
      //east of position
      if(solveMaze(maze, x+1, y) == true){
         return true;
      }
      //south of position
      if(solveMaze(maze, x, y+1) == true){
         return true;
      }
      //west of position
      if(solveMaze(maze, x-1, y) == true){
         return true;
      }
    
      //restart
      x = startx;
      y = starty;
      return false;
   }
  
   public MazeSolver(String fileName) throws IOException {

      File inFile = new File(fileName);
      Scanner inputMaze = new Scanner(inFile);
    
      int row = inputMaze.nextInt();
      saveRow = row;
      int col = inputMaze.nextInt();
      saveCol = col;
      inputMaze.nextLine();
      maze = new char[row][col];
    
      for(int i = 0; i < row; i++){
         String line = inputMaze.nextLine();
         for(int j = 0; j < line.length(); j++){
            maze[i][j] = line.charAt(j);
            if(maze[i][j] == 'S'){
               startx = j;
               starty = i;
            }
          
         }
      }
          

          
      printMaze(); // a method that prints the maze

      //solveMaze() is a recursive method to solve the maze
      if(solveMaze(maze,startx,starty)) {
         System.out.println(" Solution found ");
         printMaze();
      }
      else {
         System.out.println("No solution found");
      }
   }
}

