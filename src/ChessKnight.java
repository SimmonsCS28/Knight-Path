import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class ChessKnight {

	/**
	 * Method for searching via a Breadth First Search algorithm
	 * 
	 * @param src - the original location of the Knight on the chess board.
	 * @param dest - the location of the piece of gold on the chess board.
	 * @param N - the size of the chess board
	 * @param knight - an object that contains the properties for a given chess piece
	 */
	public static void BFS(Node src, Node dest, int N, ChessPiece knight) {
		
		/* 
		 * Keep track of visited nodes and the parents of visited nodes (for
		 * finding the shortest path).
		 */
		HashMap<Node, Node> parentNode = new HashMap<Node, Node>();

		// Queue of nodes to visit
		Queue<Node> positionQueue = new LinkedList<Node>();

		// Initially add the starting node
		parentNode.put(src, null);
		positionQueue.add(src);

		// Breadth first search
		while (positionQueue.peek() != null) // check if anymore nodes to visit
		{
			Node currentPosition = positionQueue.poll();
			if (currentPosition.equals(dest)) {

				break; // Stop searching because we've reached the end position on the graph
			}

			/* otherwise get adjacent nodes (possible moves from current
			 * position for knight)
			 */
			ArrayList<Node> nextPositions = knight.validMoves(currentPosition, N);
			for (Node adjacentPosition : nextPositions) {
				
				/* 
				 * If this adjacent nodes is one that hasn't been visited add it to the queue.
				 * Also keep track of the adjacent node's parent (the current node).
				 */
				if (!parentNode.containsKey(adjacentPosition)) {
					parentNode.put(adjacentPosition, currentPosition);
					positionQueue.add(adjacentPosition);
				}
			}
		}

		/* 
		 * Traverse back from end position coordinate to start position using
		 * the parent map to get shortest path build up string of shortest path at same time.
		 */
		Node currentNode = dest; // start at the end node
		String shortestPath = "";
		int moves = 0; // initialize the number of moves taken to reach the end position
		while (parentNode.get(currentNode) != null) // stop once we are at the
													// start node
		{
			shortestPath = currentNode.pathStringBuilding(currentNode) + shortestPath;
			currentNode = parentNode.get(currentNode);
			moves += 1;
		}

		if (shortestPath.length() == 0) // When start position = end position
		{
			System.out.println("Start position equals end position");
			shortestPath = src.printString();
		}

		// Print out the shortest path found including start and end position
		System.out.println("The number of moves = " + moves);
		System.out.print(src.pathStringBuilding(src));
		System.out.print(shortestPath.substring(0, (shortestPath.length() - 3)));

	}

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

		// Call BFS method
		BFS(knightPos, goldPos, boardSize, new KnightPiece());
	}
}