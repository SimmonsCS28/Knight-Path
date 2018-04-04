import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class ChessKnight {

	// Find minimum number of steps taken by the knight
	// from source to reach destination using BFS
	public static void BFS(Node src, Node dest, int N, ChessPiece pieceType) {
		// map to check if matrix cell is visited before or not
		Map<Node, Boolean> visited = new HashMap<>();

		// Keep track of visited nodes and the parents of visited nodes (for
		// finding the shortest path).
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
				System.out.println("Destination Found.");
				break; // we have reached the end position on the graph via the
						// shortest path so stop searching
			}

			// otherwise get adjacent nodes (possible moves from current
			// position for knight)
			ArrayList<Node> nextPositions = pieceType.validMoves(currentPosition, N);
			for (Node adjacentPosition : nextPositions) {
				// if this adjacent nodes is one that hasn't been visited add it
				// to the queue
				// also keep track of the adjacent node's parent (the current
				// node)
				if (!parentNode.containsKey(adjacentPosition)) {
					parentNode.put(adjacentPosition, currentPosition);
					positionQueue.add(adjacentPosition);
				}
			}
		}

		// traverse back from end position coordinate to start position using
		// the parent map to get shortest path
		// build up string of shortest path at same time
		Node currentNode = dest; // start at the end node
		String shortestPath = "";
		while (parentNode.get(currentNode) != null) // stop once we are at the
													// start node
		{
			shortestPath = currentNode.pathStringBuilding(currentNode) + shortestPath;
			currentNode = parentNode.get(currentNode);
		}

		if (shortestPath.length() == 0) // When start position = end position
		{
			shortestPath = src.pathStringBuilding(src);
		}

		// Print out the shortest path found, excluding start position and
		// including end position
		System.out.println(shortestPath);

	}

	public static void main(String[] args) {
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
			}
			;
		}
		;

		System.out.println("The size of the chess board is now " + boardSize + "x" + boardSize + ".");

		// knight coordinates
		Random rand = new Random();
		int x = rand.nextInt(boardSize) + 0;
		int y = rand.nextInt(boardSize) + 0;
		Node knightPos = new Node(x, y);
		System.out.println("Knight's starting position is (" + x + "," + y + ").");

		// gold coordinates
		x = rand.nextInt(boardSize);
		y = rand.nextInt(boardSize);

		// make sure new coordinates are not the same as the knight's
		// coordinates.
		if (x == knightPos.x) {
			x += 1;
		}
		if (y == knightPos.y) {
			y += 1;
		}

		Node goldPos = new Node(x, y);
		System.out.println("Gold position is (" + x + "," + y + ").");

		BFS(knightPos, goldPos, boardSize, new KnightPiece());
	}
}