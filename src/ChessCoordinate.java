
public class ChessCoordinate {
	//Is the coordinate a valid position on the defined board size
		public static boolean isValidCoordinate(int xCoordinate, int yCoordinate, int BOARD_SIZE)
		{
			if (xCoordinate >= 1 && xCoordinate <= BOARD_SIZE && yCoordinate >= 1 && yCoordinate <= BOARD_SIZE)
			{
				return true;
			} else {
				return false;
			}
		}
}
