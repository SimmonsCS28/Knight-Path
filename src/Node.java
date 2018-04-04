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

    /* 
     * Need to implement hashCode() and equals() since we're using class object as a key in a HashMap
     * 
     */
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
    
    public String printString() {
    	return ("(" + x + "," + y + ")");
    }
    
    public String pathStringBuilding(Node n) {
    	return ("(" + n.x + "," + n.y + ") -> ");
    }
    
    
}
