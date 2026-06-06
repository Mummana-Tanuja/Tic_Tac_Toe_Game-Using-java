package com.introduction.project;

import java.util.Arrays;
import java.util.*;

public class Tic_Tac_Toe_Game {
	static String[] board;
	static String turn;

	//CheckWinner method will decide the winner
	static String checkWinner()
	{
		for(int a=0;a<8;a++)
		{
			// Example of a switch statement used to check winning lines
			String line = null;
			switch(a)
			{
				case 0:
					line= board[0]+board[1]+board[2];
					break;
				case 1:
					line = board[3]+board[4]+board[5];
					break;
				case 2:
					line = board[6]+board[7]+board[8];
					break;
				case 3:
					line = board[0]+board[3]+board[6];
					break;
				case 4:
					line = board[1]+board[4]+board[7];
					break;
				case 5:
					line = board[2]+board[5]+board[6];
					break;
				case 6:
					line = board[0]+board[4]+board[8];
					break;
				case 7:
					line = board[2]+board[4]+board[6];
					break;
	
			}
			//for X winner
			if(line.equals("XXX"))
				return "X";
			//for O winner
			else if(line.equals("OOO"))
				return "O";
		}

		for(int a = 0;a < 9;a++)
		{
			if(Arrays.asList(board).contains(String.valueOf(a + 1)))
			{
				break;
			}
			else if(a == 8)
			{
				return "draw";
			}
		}
		
		System.out.println(turn+"'s turn; enter a slot number to place"+turn+" in:");
		return null;

	}
	//to print board
	static void printBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
		System.out.println("|-----------|");
		System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
		System.out.println("|-----------|");
		System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
		System.out.println("|---|---|---|");
	}

	//main method
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
        //creating a board with 9 positions
		board = new String[9];
        turn ="X";
        String winner = null;
        
     // Filling the board with slot numbers (1 to 9)
        for(int a = 0;a < 9;a++)
        {
        	  board[a] = String.valueOf(a+1);
        }
        
        System.out.println("Welcome to 3X3 Tic Tac Toe.");
        printBoard();
        System.out.println("X will paly first.Enter a slot number to place X in:");
        
        while(winner == null)
        {
        	  int numInput;
        	  
        	  try {
        		  numInput = sc.nextInt();
        		  
        		  //check range
        		  if(!(numInput > 0 && numInput <= 9))
        		  {
        			  System.out.println("Invalid input;re-enter slot number:");
        			  continue;
        		  }
        		  
        		  //check if slot is available
        		  if(board[numInput - 1].equals(String.valueOf(numInput)))
        		  {
        			  board[numInput - 1]=turn;
        			  
        			  //Toggle turn
        			  turn = turn.equals("X")?"O":"X";
        			  
        			  printBoard();
        			  winner = checkWinner();
        		  }
        		  else
        		  {
        			  System.out.println("Slot already taken;re-enter slot number:");
        		  }
        	  }
        	  catch(InputMismatchException e)
        	  {
        		 System.out.println("Invalid input;re-enter slot number:");
        		 sc.nextLine();//consume invalid input to prevent infinite loop
        	  }
        }
        
        //Final result
        if(winner.equalsIgnoreCase("draw"))
        {
        	  System.out.println("It's a draw! Thanks for playing.");
        }
        else
        {
        	System.out.println("Congratulations! "+winner +"'s have won! Thanks for playing.");
        }
        sc.close();
	}
}
