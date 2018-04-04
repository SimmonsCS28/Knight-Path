import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DFS {

	public static boolean DFS(Node src, Node dest, int N, ChessPiece pieceType) {
		// map to check if matrix cell is visited before or not
		Map<Node, Boolean> visited = new HashMap<>();

		// Keep track of visited nodes and the parents of visited nodes (for
		// finding the shortest path).
		HashMap<Node, Node> parentNode = new HashMap<Node, Node>();

		// Stack of nodes to visit
		Stack<Node> positionStack = new Stack<Node>();

		// Initially add the starting node
		parentNode.put(src, null);
		positionStack.push(src);

		// Depth first search
		if (positionStack.isEmpty() || positionStack == null) {
			return false;
		} else {

			try {
				while (positionStack.peek() != null) // check if anymore nodes
														// to
														// visit
				{
					Node currentPosition = positionStack.pop();
					if (currentPosition.equals(dest)) {
						break; // we have reached the end position on the graph
								// via
								// the
						// shortest path so stop searching
					}

					// otherwise get adjacent nodes (possible moves from current
					// position for knight)
					ArrayList<Node> nextPositions = pieceType.validMoves(currentPosition, N);
					for (Node adjacentPosition : nextPositions) {
						// if this adjacent nodes is one that hasn't been
						// visited
						// add it
						// to the stack
						// also keep track of the adjacent node's parent (the
						// current
						// node)
						if (!parentNode.containsKey(adjacentPosition)) {
							parentNode.put(adjacentPosition, currentPosition);
							positionStack.add(adjacentPosition);
						}
					}
				}
			} catch (Exception e) {
				return false;
			}
		}

		// traverse back from end position coordinate to start position using
		// the parent map to get shortest path
		// build up string of shortest path at same time
		Node currentNode = dest; // start at the end node
		String shortestPath = "";
		int moves = 0; // initialize the number of moves taken to reach the end
						// position
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
			// Print out the shortest path found, excluding start position and
			// including end position
			System.out.println("The number of moves = " + moves);
			System.out.print(src.pathStringBuilding(src));
			System.out.print(shortestPath.substring(0, (shortestPath.length() - 3)));
			return true;
		}

	}
}
