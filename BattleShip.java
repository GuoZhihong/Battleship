/**
 * Name(s) and ID(s):Zhihong Guo(40038183),Tiantian Ji(27781083).
 * COMP249
 * Assignment 1
 * Due Date :4th Feb 2017
 *
 *
 * Methodology: initializing two grids for initial placed and updated playing.initial placed grid will maintain the initial placed situations 
 * and updated playing will keep updated from initial placed situation to end of the game.
 *
 *
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */

import java.util.Scanner;
public class BattleShip {
	/**
	 * Attributes 
	 */
	private String position;//input from user.
	private int shipH = 6;//counter to determine who lose or win.
	private int shipC = 6;//counter to determine who lose or win.
	Grid placedGrid = new Grid();//new a object of grid for placing in the game.                         
	Grid playingGrid = new Grid();//new a object of grid for playing in the game.    

	/**
	 * start() method is called by the drive directly.
	 */
	public void start(){

		System.out.println("Hi, let's play battleship!");
		System.out.println();
		placeShipH();// user inputs ships.
		placeGreH();//user inputs grenades.
		placeShipC();// computer inputs ships.
		placeGreC();//computer inputs grenades.
		System.out.println();
		System.out.println("OK, the computer placed its ships and grenades at random. Let¡¯s play.");
		System.out.println();

		while(shipH > 0 && shipC > 0){ //playing games until one side loses all of ships.
			if(shipH != 0&& shipC != 0)//condition for next turn or end the game.
				turnH();
			if(shipH != 0&& shipC != 0)//condition for next turn or end the game.
				turnC();
		}
		if (shipC == 0 && shipH != 0 ){ //condition for user to win.
			System.out.println("you win");
		}
		else if (shipH == 0 && shipC != 0){ //condition for computer to win.
			System.out.println("you loose");
		}
		placedGrid.printGrid();//print all placed ships and grenade for both user and computer.
	}

	/**
	 * turnH() method indicates user's turn of the game.
	 */
	private void turnH(){

		System.out.print("position of your rocket: ");
		do {
			getPosition();//input positions from user
		}
		while(outRange());
		int j= position.charAt(0)-'A';
		int i =position.charAt(1)-'1';  

		if (playingGrid.getGrid( i, j) == '_'){ // this part indicates whether this position has been called or not.                                              
			
			char a = placedGrid.getGrid( i, j);                                             
			if (a == 'g' ){ //user hits his/her own grenade.
				
				System.out.println("boom! grenade!");
				playingGrid.setGrid( i, j,'g');                                            
				playingGrid.printGrid();
				turnC();//computer loses a turn.
			}
			if (a== 'G'){ //user hits computer's grenade.
				
				System.out.println("boom! grenade!");
				playingGrid.setGrid( i, j,'G');
				playingGrid.printGrid();
				turnC();//computer loses a turn.
			}
			if (a == 's' ){ //user hits his/her own ship.

				System.out.println("ship hit.");
				shipH--;
				playingGrid.setGrid( i, j,'s');
				if(shipH != 0)//condition to print out the grid.
					playingGrid.printGrid();
			}
			if ( a == 'S'){ //user hits computer's ship.

				System.out.println("ship hit.");
				shipC--;
				playingGrid.setGrid( i, j,'S');
				if(shipC != 0)//condition to print out the grid.
					playingGrid.printGrid();

			}
			if (a == '_'){ //user hits nothing.
				
				System.out.println("nothing.");
				playingGrid.setGrid( i, j,'*');
				playingGrid.printGrid();
			}
		}
		else{//this position has already been called.
			System.out.println("position already called");
			playingGrid.printGrid();
		}
	}

	/**
	 * turnH() method indicates computer's turn of the game.
	 */
	private void turnC(){
		System.out.println("position of my rocket: ");
		int i = (int)(Math.random() * 8 ); 
		int j= (int)(Math.random() * 8 ); 

		if (playingGrid.getGrid( i, j) == '_'){   //to check if this position has been called or not.     
			
			char a = placedGrid.getGrid( i, j);                                             
			if (a == 'g' ){ //computer hits user's ship.
				
				System.out.println("boom! grenade!");
				playingGrid.setGrid( i, j,'g');                                             
				playingGrid.printGrid();
				turnH();//computer loses a turn.
			}
			if (a== 'G'){ //computer hits its own ship.
				
				System.out.println("boom! grenade!");
				playingGrid.setGrid( i, j,'G');
				playingGrid.printGrid();
				turnH();//computer loses a turn.
			}
			if (a == 's' ){ //computer hits user's ship.

				System.out.println("ship hit.");
				shipH--;
				playingGrid.setGrid( i, j,'s');
				if(shipH != 0)//condition to print out the grid.
					playingGrid.printGrid();
			}
			if ( a == 'S'){ //computer hits its own ship.

				System.out.println("ship hit.");
				shipC--;
				playingGrid.setGrid( i, j,'S');
				if(shipC != 0)
					playingGrid.printGrid();

			}
			if (a == '_'){ //hits nothing.
				
				System.out.println("nothing.");
				playingGrid.setGrid( i, j,'*');
				playingGrid.printGrid();
			}
		}
		else{ //this position has already been called.
			System.out.println("position already called");
			playingGrid.printGrid();;
		}
	}

	/**
	 * getPosition() method is to take in string input from the user and return it ignoring character format .
	 * @return a String value
	 */
	private String getPosition(){
		Scanner keyIn = new Scanner(System.in);
		position = keyIn.nextLine().toUpperCase();//convert to upper case for all inputs.
		return position;
	}




	/**
	 * placeShipH(() method is to generate user's ships positions from the user's input.
	 */
	private void placeShipH(){

		int  countSH = 0,time = 1;//counters
		do{

			System.out.print("Enter the coordinates of your ship #" + time + ";");      
			getPosition();//input positions from user

			int j= position.charAt(0)-'A';  
			int i =position.charAt(1)-'1';  

			if(!outRange()){ //to check if this position is in the range or not. 
				if(placedGrid.getGrid( i, j) == '_' ){ //to check if this position is occupied or not.                 
					placedGrid.setGrid( i, j,'s');

					countSH++;
					time++;
				}
				else
					System.out.println("sorry, coordinates already used. try again.");
			}	
		}while(countSH<6);//6 positions
	}

	/**
	 * placeGreH() method is to generate user's grenades positions from the user's input.
	 */
	private void placeGreH(){

		int countGH = 0, time = 1;//counters
		do{
			System.out.print("Enter the coordinates of your grenade #" + time +";");
			getPosition();//input positions from user
			int j= position.charAt(0)-'A';  //
			int i =position.charAt(1)-'1';  //

			if(!outRange()){ //to check if this position is in the range or not. 
				if(placedGrid.getGrid( i, j) == '_' ){ //to check if this position is occupied or not. 
					placedGrid.setGrid( i, j,'g');
					time ++;
					countGH ++;
				}
				else
					System.out.println("sorry, coordinates already used. try again.");
			}
		}while(countGH < 4);//4 positions
	}

	/**
	 * placeShipC() method is to generate random positions for the computer ships.This method will automatically find the empty positions and place them.  
	 */
	private void placeShipC(){
		int countSC = 0;//counter.
		do{
			int i = (int)(Math.random() * 8 ); 
			int j = (int)(Math.random() * 8 );

			if(placedGrid.getGrid( i, j) == '_'){
				placedGrid.setGrid( i, j,'S');
				countSC++;
			}
		}while(countSC<6);//6 positions
	}

	/**
	 * placeGreC() method is to generate random positions for the computer grenades.This method will automatically find the empty positions and place them.  
	 */
	private void placeGreC(){
		int countGC = 0;//counter.
		do{
			int i = (int)(Math.random() * 8 ); 
			int j = (int)(Math.random() * 8 );
			if(placedGrid.getGrid( i, j) == '_'){
				placedGrid.setGrid( i, j,'G');
				countGC++;
			}
		}while(countGC<4);//4 positions
	}

	/**
	 * outRange method() is to return a boolean value to see if the grid range of the user's input is valid or not. 
	 * @return a boolean value
	 */
	private boolean outRange(){
		char p = position.charAt(0);
		char q = position.charAt(1);


		if(p<'A' || p>'H' || q<'1' ||q>'8'){
			System.out.println("sorry, coordinates outside the grid. try again.");
			return true;
		}
		else
			return false;

	}
}
