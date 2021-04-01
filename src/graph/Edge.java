package graph;

/**
 * The Edge class.
 */
public class Edge implements Comparable<Edge>{

    public Vertex source;
    public Vertex destination;
    public double weight;

    /**
     * Instantiates a new Edge.
     *
     * @param source      the source Vertex
     * @param destination the destination Vertex
     * @param distance    the distance Vertex
     */
    public Edge(Vertex source, Vertex destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.weight = distance;
    }

    @Override
    public String toString() {
        return String.format("(%s --> %S, %f)",source.name,destination.name,weight);
    }

    @Override
    public int compareTo(Edge otherEdge) {
        if (this.weight > otherEdge.weight) {
            return 1;
        } else return -1;
    }
}
