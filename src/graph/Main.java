package graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(true);
        Vertex zero = new Vertex("A");
        Vertex one = new Vertex("B");
        Vertex two = new Vertex("C");
        Vertex three = new Vertex("D");
        Vertex four = new Vertex("E");
        Vertex five = new Vertex("F");
        Vertex six = new Vertex("G");

        graph.addEdge(zero, one, 8);
        graph.addEdge(zero, two, 11);
        graph.addEdge(one, three, 3);
        graph.addEdge(one, four, 8);
        graph.addEdge(one, two, 7);
        graph.addEdge(two, four, 9);
        graph.addEdge(three, four, 5);
        graph.addEdge(three, five, 2);
        graph.addEdge(four, six, 6);
        graph.addEdge(five, four, 1);
        graph.addEdge(five, six, 8);

        graph.dikstraAlgorithm(zero, six);
    }
}
