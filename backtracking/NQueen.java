package main.backtracking;

import java.util.Arrays;

public class NQueen {
	
	public static boolean solutionFound;
	
	public static void main(String[] args) {
		solutionFound=false;
		 int[][] board = {
				 {0,0,0,0},
				 {0,0,0,0},
				 {0,0,0,0},
				 {0,0,0,0}
		 };
		 
		 solveNQueen(board,0);
		 
	}
	
	public static void printSolution(int[][] board) {
		for(int i=0;i<board.length;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public static void solveNQueen(int[][] board, int row) {
		
		//Stopping condition
		if(row>board.length-1) {
			solutionFound=checkIfSolutionFound(board);
			if(solutionFound) {
				System.out.println("Solution found");
				printSolution(board);
			}
			return;
		}
		
		//Logic
		for(int i=0;i<board.length;i++) {
			if(positionEligible(board,row,i)) {
				board[row][i]=1;
				solveNQueen(board,row+1);
				board[row][i]=0;
			}else {
				solveNQueen(board,row+1);
			}
		}
		
	}

	private static boolean checkIfSolutionFound(int[][] board) {
		for(int i=0;i<board.length;i++) {
			if(!Arrays.toString(board[i]).contains("1"))
				return false;
		}
		return true;
	}

	private static boolean positionEligible(int[][] board, int row, int col) {
		
		//queen can be placed in this row
		for(int i=0;i<board.length;i++) {
			if(board[row][i]==1 || board[i][col]==1) {
				return false;
			}
		}
		
		//diagonal
		int r = row;
		int c = col;
		while(r>=0 && c>=0) {
			if(board[r][c]==1) {
				return false;
			}
			r--;
			c--;
		}
		
		r = row;
		c = col;
		while(r>=0 && c<=board.length-1) {
			if(board[r][c]==1) {
				return false;
			}
			r--;
			c++;
		}
		
		return true;
	}
	
}
