import java.util.Queue;

public class boardTraversal {
	public int findTarget(int knightPos[], int goldPos[], int boardSize) {
		cellModel cell = new cellModel(knightPos, goldPos, boardSize);
		
		int numberOfSteps = 0;
		int[] directionX = {-2, -1, 1, 2, -2, -1, 1, 2};
		int[] directionY = {-2, -1, 1, 2, -2, -1, 1, 2};
		
		Queue<cellModel> q = null; 
		
		q.add(cell);
		
		return numberOfSteps;
	}
}
