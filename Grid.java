/**
 * Name(s) and ID(s):Zhihong Guo(40038183),Tiantian Ji(27781083).
 * COMP249
 * Assignment 1
 * Due Date :4th Feb 2017
 *
 *  Methodology: initializing two grids for initial placed and updated playing.initial placed grid will maintain the initial placed situations 
 * and updated playing will keep updated from initial placed situation to end of the game.
 * 
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Grid {
	/**
	 * Attributes 
	 */
	private char[][]  Grid = {{'_','_','_','_','_','_','_','_'}, 
			{'_','_','_','_','_','_','_','_'}, 
			{'_','_','_','_','_','_','_','_'}, 
			{'_','_','_','_','_','_','_','_'}, 
			{'_','_','_','_','_','_','_', '_'}, 
			{'_','_','_','_','_','_','_','_'},
			{'_','_','_','_','_','_','_','_'},
			{'_','_','_','_','_','_','_','_'}};// Create a 8 by 8 2D array for the game.

	/**
	 * enumerated type for input newValue.
	 */
	public enum newValue {
		S , s, G , g;
	}

	/**
	 * Takes two integers and a character in and set the character value to the grid location specified by coordinates of these two integers.
	 * 
	 * @param x an integer value
	 * @param y an integer value
	 * @param newValue a character value
	 */
	public void setGrid(int x ,int y,char newValue){
		Grid[x][y] = newValue;
	}

	/**
	 *  Takes two integers in and return the character value in the grid,which is specified by two integers.
	 * 
	 * @param x an integer value
	 * @param y an integer value
	 * @return a character in grid[x][y]
	 */
	public char getGrid(int x ,int y){
		return Grid[x][y] ;
	}

	/**
	 * this method plots the grid and every element in it.
	 */
	public void printGrid(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++)
				System.out.print(Grid[i][j]+" ");     
			System.out.println();                   
		}
	}
}