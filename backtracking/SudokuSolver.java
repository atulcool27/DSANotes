package main.backtracking;

import java.util.Arrays;

public class SudokuSolver {

	static boolean solutionFound; 
	
	public static void main(String[] args) {
		solutionFound=false;
		int[][] board = {	  { 7, 3, 0, 0, 1, 2, 0, 9, 0 },  //0
										  { 0, 0, 0, 0, 4, 0, 0, 0, 0 },  //2
										  { 9, 0, 0, 0, 0, 0, 5, 0, 0 },
										  { 0, 0, 8, 0, 0, 0, 0, 0, 6 },
										  { 0, 1, 0, 0, 9, 3, 0, 5, 0 },
										  { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
										  { 0, 0, 0, 4, 0, 0, 0, 2, 0 },
										  { 0, 7, 0, 5, 0, 0, 0, 0, 0 },
										  { 0, 0, 1, 0, 2, 7, 8, 0, 0 }, 	  };
		
		
		// SudokuSolver using Recursion and Backtracking
		sudokuSolver(board,board.length-1,board.length-1);
		
		if(!solutionFound) {
			System.out.println("This sudoku is not solvable");
		}
	}
	
	
	public static void sudokuSolver(int[][] board, int row, int col) {
		
		//Stopping Condition
		if(col<0) {
			col=board.length-1;
			row--;
		}
		
		if(row<0) {
			//verify if solutionFound
			solutionFound=isSolutionFound(board);
			if(solutionFound) {
				System.out.println("finale");
				printSolution(board);
			}
			return;
		}
		
		//Logic
		if(!solutionFound) {
		
		   System.out.println("now board=");
		   printSolution(board);
			if(board[row][col]==0) {
				//check if digit is eligible for this position
				for(int i=1;i<=9;i++)
					if(isDigitEligible(board,row,col,i)) {
						
						board[row][col]=i;
						sudokuSolver(board,row,col-1);
						board[row][col]=0;
						
					}
			}else {
				sudokuSolver(board,row,col-1);
			}
			
		}
	}


	private static void printSolution(int[][] board) {
	//	System.out.println("sudoku Solution found!");
		for(int i=0;i<board.length;i++)
			System.out.println(Arrays.toString(board[i]));
	}


	private static boolean isSolutionFound(int[][] board) {
		boolean result = true;
		
		for(int i=board.length-1;i>=0;i--) {
			String str = Arrays.toString(board[i]);
			if(str.contains("0")) {
				result=false;
				break;
			}
		}
		
		return result;
	}


	private static boolean isDigitEligible(int[][] grid, int row, int col, int num) {

		// Check if we find the same num
		// in the similar row , we
		// return false
		for (int x = 0; x <= 8; x++)
			if (grid[row][x] == num)
				return false;

		// Check if we find the same num
		// in the similar column ,
		// we return false
		for (int x = 0; x <= 8; x++)
			if (grid[x][col] == num)
				return false;

		// Check if we find the same num
		// in the particular 3*3
		// matrix, we return false
		int startRow = row - row % 3, startCol
									= col - col % 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (grid[i + startRow][j + startCol] == num)
					return false;

		return true;
	}
}
