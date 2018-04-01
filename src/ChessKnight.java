import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class ChessKnight {
	// Below arrays details all 8 possible movements
	// for a knight
	private static int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
	private static int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };

	// Check if (x, y) is valid chess board coordinates
	// Note that a knight cannot go out of the chessboard
	private static boolean valid(int x, int y, int N) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;

		return true;
	}

	// Find minimum number of steps taken by the knight
	// from source to reach destination using BFS
	public static int BFS(Node src, Node dest, int N) {
		// map to check if matrix cell is visited before or not
		Map<Node, Boolean> visited = new HashMap<>();

		// create a queue and enqueue first node
		Queue<Node> q = new ArrayDeque<>();
		q.add(src);

		// run till queue is not empty
		while (!q.isEmpty()) {
			// pop front node from queue and process it
			Node node = q.poll();

			int x = node.x;
			int y = node.y;
			int dist = node.dist;

			// if destination is reached, return distance
			if (x == dest.x && y == dest.y){
				System.out.print("(" + dest.x + "," + dest.y + ") ");
				return dist;
			}

			// Skip if location is visited before
			if (visited.get(node) == null) {
				// mark current node as visited
				System.out.print("Visted node (" + node.x + "," + node.y + ") Dist = " + node.dist + " ");
				visited.put(node, true);

				// check for all 8 possible movements for a knight
				// and enqueue each valid movement into the queue
				for (int i = 0; i < 8; ++i) {
					// Get the new valid position of Knight from current
					// position on chessboard and enqueue it in the
					// queue with +1 distance
					int x1 = x + row[i];
					int y1 = y + col[i];

					if (valid(x1, y1, N)){
						q.add(new Node(x1, y1, dist + 1));
					}
				}
			}
		}

		// return INFINITY if path is not possible
		return Integer.MAX_VALUE;
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
		
		// make sure new coordinates are not the same as the knight's coordinates.
		if (x == knightPos.x) {
			x += 1;
		}
		if (y == knightPos.y) {
			y += 1;
		}

		Node goldPos = new Node(x, y);
		System.out.println("Gold position is (" + x + "," + y + ").");

		System.out.println("Minimum number of steps required is " + BFS(knightPos, goldPos, boardSize));
	}
}