import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		boardTraversal traverse = new boardTraversal();
		Scanner input = new Scanner(System.in);

		// Ask for size of chess board
		System.out.println(
				"Please enter a number greater than 3 but less than or equal to 200 to set the size of the chess board.");
		int boardSize = input.nextInt();

		// Set size of chess board
		while (boardSize < 3 || boardSize > 200) {
			if (boardSize <= 3 || boardSize > 200) {
				System.out.println(
						"Number entered is invalid. Please enter a number greater than 3 but less or equal to 200.");
				boardSize = input.nextInt();
			} else {
				boardSize = input.nextInt();
			};
		};

		System.out.println("The size of the chess board is now " + boardSize + "x" + boardSize + ".");
		
		Random rand = new Random();
		// Initialize the goal position
		int x = rand.nextInt(boardSize) + 1;
		int y = rand.nextInt(boardSize) + 1;
		int[] goldPos = {x,y};

		// Initialize the Knight's position
		while (x == goldPos[0]) {
			x = rand.nextInt(boardSize) + 1;
		}
		while (y == goldPos[1]) {
			y = rand.nextInt(boardSize) + 1;
		}
		int[] knightPos = {x,y};

		// Find a path to the goal
		System.out.println(traverse.findTarget(knightPos, goldPos, boardSize));

		// Print out results
	};
}
