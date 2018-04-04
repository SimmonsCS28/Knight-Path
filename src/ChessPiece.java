import java.util.*;

public abstract class ChessPiece {

	/**
	 * Given a starting position, what are the valid coordinates a chess piece
	 * can move to next.
	 *
	 * Assumes empty chess board with no other pieces.
	 *
	 * Returns ArrayList of valid ChessCoordinates for next move of a chess
	 * piece.
	 * 
	 * @param startPosition - the initial position of the Knight piece.
	 * @param boardSize - the max size of the board.
	 * @return
	 */
	public abstract ArrayList<Node> validMoves(Node startPosition, int boardSize);

	public ArrayList<Node> validMoves1(Node startPosition, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

}