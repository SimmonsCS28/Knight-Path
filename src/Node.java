import java.util.List;

public class Node {
	// (x, y) represents chess board coordinates
    // dist represent its minimum distance from the source
    int x, y, dist;
    List<Node> neighbors;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    public Node(int x, int y, int dist, List<Node> neighbors) {
    	this.x = x;
        this.y = y;
        this.dist = dist;
        this.neighbors = neighbors;
    }

    // As we are using class object as a key in a HashMap
    // we need to implement hashCode() and equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (x != node.x) return false;
        if (y != node.y) return false;
        return dist == node.dist;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + dist;
        return result;
    }
    
    public void printString() {
    	System.out.println("(" + x + "," + y + ")");
    }
    
    public String pathStringBuilding(Node n) {
    	return ("(" + n.x + "," + n.y + ")");
    }
    
    
}
