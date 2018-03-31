
public class board {

	public boolean insideBoard(int x, int y, int n) {
		if (x >= 1 && x <= n && y >= 1 && y <= n) {
			return true;
		} else
			return false;
	}
}
