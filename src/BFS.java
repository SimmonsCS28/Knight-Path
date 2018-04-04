import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	/**
	 * Method for searching via a Breadth First Search algorithm
	 * 
	 * @param src - the original location of the Knight on the chess board.
	 * @param dest - the location of the piece of gold on the chess board.
	 * @param N - the size of the chess board
	 * @param knight - an object that contains the properties for a given chess piece
	 */
	public static boolean BFS(Node src, Node dest, int N, ChessPiece knight) {
		
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
			return false;
		} else {
			// Print out the shortest path found including start and end position
			System.out.println("The number of moves = " + moves);
			System.out.print(src.pathStringBuilding(src));
			System.out.print(shortestPath.substring(0, (shortestPath.length() - 3)));
			return true;
		}

	}
}
