package tictactoe;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class AI {

	
	/*
	 * I need to make a copy of board, and a method to get all possible moves every turn. 
	 * 
	 * */
	
	
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Board board;
	private static final int MAX_DEPTH = 1;
	
	//For randomizing first move
	
	boolean isFirstMove = true;
	Random rN1;
	//

	static char[][] tempBoard = new char[3][3];
	
	public AI(Board board) {
		this.board = board;
		initTempBoard();
		getButtons();

	}
	
	public void initTempBoard() {
		
			System.out.println("test");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					tempBoard[i][j] = ' ';		
				}
			}
	}
	
public void ifGameIsOver() {
		
		if(AI.checkTempBoardWin('X')) {
			//board.aiPoints++;
			//board.startNewGame(); // we're actually checking this in board class.
			isFirstMove = true;
			initTempBoard();
		}
		if(AI.checkTempBoardWin('O')) { // this needs to be checked here because if o wins, tempBoard doesn't get information about it and wont init.
			board.playerPoints++;
			board.startNewGame();
			isFirstMove = true;
			initTempBoard();
		}
		if(AI.checkTempBoardTie()) {
			//board.ties++; these two lines are not mandatory here, since we check draws in Board class also. However, if game is draw/tie, we want to initTempBoard here.
			//board.startNewGame();
			isFirstMove = true;
			initTempBoard();
		}
		
	}
	
	public void makeMove(int[] moveToMake) {

		board.currentPlayerMark = "X";
		
		if(moveToMake[0] == 0 && moveToMake[1] == 0) {board.btn00.doClick();}
		if(moveToMake[0] == 0 && moveToMake[1] == 1) {board.btn01.doClick();}
		if(moveToMake[0] == 0 && moveToMake[1] == 2) {board.btn02.doClick();}
		
		if(moveToMake[0] == 1 && moveToMake[1] == 0) {board.btn10.doClick();}
		if(moveToMake[0] == 1 && moveToMake[1] == 1) {board.btn11.doClick();}
		if(moveToMake[0] == 1 && moveToMake[1] == 2) {board.btn12.doClick();}
		
		if(moveToMake[0] == 2 && moveToMake[1] == 0) {board.btn20.doClick();}
		if(moveToMake[0] == 2 && moveToMake[1] == 1) {board.btn21.doClick();}
		if(moveToMake[0] == 2 && moveToMake[1] == 2) {board.btn22.doClick();}
		
		/*for(int i = 0; i < 3; i++) {
			System.out.println();
		for(int j = 0; j < 3; j++) {
			System.out.print(tempBoard[i][j]);
		}
		}*/
		
		
	}
	
	
	
	public int[] getBestMove(Board board) {
	
		getButtons();
		ifGameIsOver();
		
	int[] bestMove = new int[] {-1, -1};
	int bestValue = Integer.MIN_VALUE;
	
	for(int row = 0; row < 3; row++) {
		for(int col = 0; col < 3; col++) {
			if(tempBoard[row][col] == ' ') {
				tempBoard[row][col] = 'X';
			int value = miniMax(tempBoard, MAX_DEPTH, false);
			//System.out.println("back here with value " + value);
			tempBoard[row][col] = ' ';
			
			if(value > bestValue) {
				
				bestMove[0] = row;
				bestMove[1] = col;
				bestValue = value;
				System.out.println("bestvalue " + bestValue);
			}
			}
			
		}
	}
	//System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT " + bestMove[0] + " " + bestMove[1]);	
	//NTS forgot to put value to tempBoard also... feel dumb
	//System.out.println("Best move = " + bestMove[0] + "," +bestMove[1]);
	
	if(isFirstMove) { // if it's ai's first move I want to randomize it
		
		rN1 = new Random();
		int r1 = rN1.nextInt(3);
		int r2 = rN1.nextInt(3);
		System.out.println("test222 + " + r1 + " " + r2);
		tempBoard[bestMove[0]+r1][bestMove[1]+r2] = 'X';
		isFirstMove = false;
		bestMove[0] += r1;
		bestMove[1] += r2;
		makeMove(bestMove);
		
	}else {
		tempBoard[bestMove[0]][bestMove[1]] = 'X';
		makeMove(bestMove);
	}
	
	
	
	return bestMove;
	}
	
	
	
	public int miniMax(char[][] board, int depth, boolean isMax) {
		
		
		
		
		int boardValue = evaluateBoard(board);
		//System.out.println("board value " + boardValue);
		//System.out.println("high v " + highestSeenValue + " low v " + lowestSeenValue);
		if(depth == 0 || boardValue == 10) {
			return boardValue;
		}
			
					if(isMax) {
						
						int highestSeenValue = Integer.MIN_VALUE;
						for(int row = 0; row < 3; row++) {
							for(int col = 0; col < 3; col++) {
								if(tempBoard[row][col] == ' ') {
									tempBoard[row][col] = 'X';
									highestSeenValue = Math.max(highestSeenValue, miniMax(tempBoard, depth-1, false));
									tempBoard[row][col] = ' ';
								}
							}
						}
						
						//System.out.println(highestSeenValue + " HWS");
						return highestSeenValue;
					}
					
					else {
						int lowestSeenValue = Integer.MAX_VALUE;
						for(int row = 0; row < 3; row++) {
							for(int col = 0; col < 3; col++) {
								
								if(tempBoard[row][col] == ' ') {
									tempBoard[row][col] = 'O';
									lowestSeenValue = Math.min(lowestSeenValue, miniMax(tempBoard, depth-1, true));
									tempBoard[row][col] = ' ';
								}
								
							}
						}
						
						
						
						//System.out.println(lowestSeenValue + " LWS");
						return lowestSeenValue;	
					}

		
	}
	
	
	private static int evaluateBoard(char[][] board) {
		
		if(checkTempBoardWin('X')) {
			return 10;
		}
		if(checkTempBoardWin('O')) {
			return -10;
		}
		
		if(checkTempBoardTie()) { // probably useless...
			return 5;
		}
		
		return 0;
		
	}
	
	
	private void getButtons() {
		
		buttons.clear();
		
		buttons.add(board.btn00);
		if(board.btn00.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[0][0] = 'O';
		}
		buttons.add(board.btn01);
		if(board.btn01.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[0][1] = 'O';
		}
		buttons.add(board.btn02);
		if(board.btn02.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[0][2] = 'O';
		}
		
		buttons.add(board.btn10);
		if(board.btn10.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[1][0] = 'O';
		}
		buttons.add(board.btn11);
		if(board.btn11.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[1][1] = 'O';
		}
		buttons.add(board.btn12);
		if(board.btn12.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[1][2] = 'O';
		}
		
		buttons.add(board.btn20);
		if(board.btn20.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[2][0] = 'O';
		}
		buttons.add(board.btn21);
		if(board.btn21.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[2][1] = 'O';
		}
		buttons.add(board.btn22);
		if(board.btn22.getText().toString().equalsIgnoreCase("O")) {
			tempBoard[2][2] = 'O';
		}
		
	}

	private static boolean checkTempBoardWin(char playerMark) {
		
		
		//ROWS
		if(tempBoard[0][0] == tempBoard[0][1] && tempBoard[0][1] == tempBoard[0][2] && tempBoard[0][2] == playerMark) {
			return true;
		}
		if(tempBoard[1][0] == tempBoard[1][1] && tempBoard[1][1] == tempBoard[1][2] && tempBoard[1][2] == playerMark) {
			return true;
		}
		if(tempBoard[2][0] == tempBoard[2][1] && tempBoard[2][1] == tempBoard[2][2] && tempBoard[2][2] == playerMark) {
			return true;
		}
		
		//COLUMNS
		if(tempBoard[0][0] == tempBoard[1][0] && tempBoard[1][0] == tempBoard[2][0] && tempBoard[2][0] == playerMark) {
			return true;
		}
		if(tempBoard[0][1] == tempBoard[1][1] && tempBoard[1][1] == tempBoard[2][1] && tempBoard[2][1] == playerMark) {
			return true;
		}
		if(tempBoard[0][2] == tempBoard[1][2] && tempBoard[1][2] == tempBoard[2][2] && tempBoard[2][2] == playerMark) {
			return true;
		}
		//DIAGS
		//ROWS
		if(tempBoard[0][0] == tempBoard[1][1] && tempBoard[1][1] == tempBoard[2][2] && tempBoard[2][2] == playerMark) {
			return true;
		}
		if(tempBoard[0][2] == playerMark && tempBoard[1][1] == playerMark && tempBoard[2][0] == playerMark) {
			return true;
		}

		
		return false;
	}
	
	private static boolean checkTempBoardTie() {
		
		boolean tieCon1 = true;
		
		for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
		if(tempBoard[i][j] == ' ') { // this is basicly for checking if all tiles on board are full. If not, tiecondition is false.
			tieCon1 = false;
		}
			
			
		}
		}
		
		if(!checkTempBoardWin('X') && tieCon1 == true || !checkTempBoardWin('O') && tieCon1 == true)  { // if tiecondition is true, and not either o or x is winner, we return true.
			return true;
		}
		
		return false;
	}
	
}
