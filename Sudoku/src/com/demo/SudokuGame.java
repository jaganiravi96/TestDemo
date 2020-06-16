package com.demo;

public class SudokuGame {

	// Defining the variable	
	public static int[][] sudoku = {};
	public static int row;
	public static int column;
	public static int digit;
	
	//main method to run our program
	public static void main(String[] args) {
		// creating the object and calling the method of the class
		SudokuGame SG1 = new SudokuGame();
		SG1.checkValidity(sudoku, row, column, digit);
	}
	
	//as per business case define the method checkValidity
		/*
		 * input argument - two dimensional int array, int digit value and its location by row and column value in int
		 * return type - boolean if pass through all the rule define
		 */
	public boolean checkValidity(int sudoku[][], int row, int column, int digit){
		boolean flag = false;
		
		// checking validity of digit
		if(digit > 0 && digit < 10){
			// checking validity on the row
			if(row > 0 && row < 10){
				for (int i = 0; i < 9; i++) {
					if(sudoku[row][i] != digit)
						flag = true;
				}
			}
			// checking validity on the column
			if(column > 0 && column < 10){
				for (int i = 0; i < 9; i++) {
					if(sudoku[i][column] != digit)
						flag = true;
				}
			}
			
			// checking validity on the subsquare
			for(int rcount = 0; rcount < 9; rcount = rcount + 3){
			    for(int ccount = 0; ccount < 9; ccount = ccount + 3)
				{ 
					int temp1 = rcount;
					int temp2 = ccount;
					if(row < temp1 + 3 && column < temp2 + 3)
					{
					    for(int r = rcount; r < rcount + 3; r++){
							for(int c = ccount; c < ccount + 3; c++){
								if(sudoku[r][c] != digit)
									flag = true;
							}
						} 
					}		
			    }
			}
		}
		return flag;		
	}

}
