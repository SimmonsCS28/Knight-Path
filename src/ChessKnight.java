import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class ChessKnight {

	/**
	 * Main method for executing the program.
	 * 
	 * @param args any potential arguments. None being passed in this case.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Initialize chessboard size.
		System.out.println(
				"Please enter a number greater than 3 but less than or equal to 200 to set the size of the chess board.");
		int boardSize = input.nextInt();

		// Set size of chess board
		while (boardSize < 3 || boardSize > 200) {
			if (boardSize <= 3 || boardSize > 200) { // If we enter in a value outside of desired parameters, keep asking for a new value.
				System.out.println(
						"Number entered is invalid. Please enter a number greater than 3 but less or equal to 200.");
				boardSize = input.nextInt();
			} else {
				boardSize = input.nextInt(); // set board size.
			}
			;
		}
		;

		System.out.println("The size of the chess board is now " + boardSize + "x" + boardSize + ".");

		// Knight coordinates
		Random rand = new Random();
		int x = rand.nextInt(boardSize) + 0;
		int y = rand.nextInt(boardSize) + 0;
		
		Node knightPos = new Node(x, y);
		
		System.out.println("Performing Breadth First Search first. \n");
		System.out.println("Knight's starting position is (" + x + "," + y + "). \n");

		// Gold coordinates
		x = rand.nextInt(boardSize);
		y = rand.nextInt(boardSize);

		// Make sure new coordinates are not the same as the knight's
		// coordinates.
		if (x == knightPos.x) {
			x += 1;
		}
		if (y == knightPos.y) {
			y += 1;
		}

		Node goldPos = new Node(x, y);
		System.out.println("Gold position is (" + x + "," + y + "). \n");

		//Call BFS method
		System.out.println("Breadth First Search \n");
		while(BFS.BFS(knightPos, goldPos, boardSize, new KnightPiece()) == false){
			BFS.BFS(knightPos, goldPos, boardSize, new KnightPiece());
		};
		
		System.out.println("\n");
		
		System.out.println("Depth First Search \n");
		while(DFS.DFS(knightPos, goldPos, boardSize, new KnightPiece()) == false) {
			DFS.DFS(knightPos, goldPos, boardSize, new KnightPiece());
		};
	}
}