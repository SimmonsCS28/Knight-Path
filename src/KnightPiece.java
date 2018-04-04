import java.util.ArrayList;

class KnightPiece extends ChessPiece {
	
	public ArrayList<Node> validMoves(Node startPosition, int boardSize)
	{
		//Will build up list of valid co-ordinates for next move
		ArrayList<Node> validCoordiantes = new ArrayList<Node>();

		int[] moves = {-2, -1, 1, 2};

		for (int xMove : moves) {
			for (int yMove : moves) {
				if (Math.abs(xMove) != Math.abs(yMove)) { //A Knight can only move 1 space in one direction and 2 in the other
					if (ChessCoordinate.isValidCoordinate(startPosition.x + xMove, startPosition.y + yMove, boardSize))
					{
						validCoordiantes.add((new Node((startPosition.x + xMove),(startPosition.y + yMove))));
					}
				}
			}
		}

		return validCoordiantes;
	}

	@Override
	public ArrayList<Node> validMoves1(Node startPosition, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}