package graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(true);
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex z = new Vertex("z");

        graph.addEdge(s, t, 10);
        graph.addEdge(s, y, 5);
        graph.addEdge(t, x, 1);
        graph.addEdge(t, y, 2);
        graph.addEdge(y, z, 2);
        graph.addEdge(y, t, 3);
        graph.addEdge(y, x, 9);
        graph.addEdge(x, z, 4);
        graph.addEdge(z, s, 7);
        graph.addEdge(z, x, 6);

        graph.dikstraAlgorithm(s, z);
    }
}
