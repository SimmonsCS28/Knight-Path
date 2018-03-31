
public class cellModel {
	int[] x;
	private int[] y;
	int dis;

	public cellModel(int[] knightPos, int[] goldPos, int dis) {
		super();
		this.x = knightPos;
		this.y = goldPos;
		this.dis = dis;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public int getDis() {
		return dis;
	}

	public void setDis(int dis) {
		this.dis = dis;
	}

}
