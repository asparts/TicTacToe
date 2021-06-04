package tictactoe;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board board = new Board();
		
		AI ai = new AI(board);
		
		while(true) { // this acts as gameloop for ai class.. Poor implementation but works.. But propably that's not the thing we're focusing on this class..
			
			if(board.getCurrentPlayerMark() == "X") {
				ai.getBestMove(board);
			}
			//System.out.println("");
			Scanner scanner = new Scanner(System.in);
			//int jaa = scanner.nextInt();
			scanner.close();
		}
		

	}

}
