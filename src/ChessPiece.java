import java.util.*;

public abstract class ChessPiece {

	//Given a starting position what are the valid co-ordinates a chess piece can move to next
	//
	//Assumes empty chess board with no other pieces  
	//
	//Returns ArrayList of valid ChessCoordinates for next move of a chess piece
	public abstract ArrayList<Node> validMoves(Node startPosition, int boardSize);

	public ArrayList<Node> validMoves1(Node startPosition, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

}