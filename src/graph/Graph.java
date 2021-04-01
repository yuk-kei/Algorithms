package graph;

import java.util.*;

/**
 * The Graph class, using Set to store Vertexes to avoid duplicates.
 */
public class Graph {
    private Set<Vertex> Vertexes;
    private  boolean isDirected;

    /**
     * Instantiates a new Graph.
     *
     * @param isDirected set the graph to be a directed graph or not directed graph
     */
    public Graph(boolean isDirected) {
        Vertexes = new HashSet<>();
        this.isDirected = isDirected;
    }

    /**
     * Dikstra algorithm, two HashMap one is for keeping track of the path, the other is for storing the shortest path
     *
     * @param start the start vertex
     * @param end   the end vertex
     */
    public void dikstraAlgorithm(Vertex start, Vertex end){
        // keep track of the path
        HashMap<Vertex, Vertex> changeAt = new HashMap<>();
        // store the path
        HashMap<Vertex, Double> shortestPath = new HashMap<>();
        // set the distance to infinity, init the first vertex
        for (Vertex vertex : Vertexes){
            if (vertex == start){
                shortestPath.put(vertex,0.0);
                start.setKnown(true);
                for (Edge edge : start.edges){
                    shortestPath.put(edge.destination,edge.weight);
                    changeAt.put(edge.destination,start);
                }
            } else {
                shortestPath.put(vertex,Double.POSITIVE_INFINITY);
            }
        }

        // run the loop until there's a path or pointed to null
        while(true){
            Vertex currentVertex = nextUnknownVertex(shortestPath);
            // make sure whether there is a path
            if (currentVertex == null){
                System.out.println("Sorry, it seems that doesn't exit a path from " + start.name + " to " + end.name);
                return;
            }
            // if the path exits, we need to print it
            if (currentVertex == end){
                System.out.println("We find it!! The path is :");

                // not using StringBuffer because it should add at the start
                Vertex child = end;
                String path = end.name;
                while (true) {
                    Vertex parent = changeAt.get(child);
                    if (parent == null){
                        break;
                    }
                    path = parent.getName() + " " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("The path costs: " + shortestPath.get(end));
                return;
            }

            // set the current vertex to be known
            currentVertex.setKnown(true);
            // go through all the edges attached to the current vertex
            for (Edge edge : currentVertex.edges){
                if (edge.destination.isKnown())
                    continue;

                // check whether its shortest path value is better when go though current node than whatever we had before
                if (shortestPath.get(currentVertex) + edge.weight < shortestPath.get(edge.destination)){
                    shortestPath.put(edge.destination,shortestPath.get(currentVertex) + edge.weight);
                    changeAt.put(edge.destination,currentVertex);
                }
            }
        }
    }

    private Vertex nextUnknownVertex(HashMap<Vertex, Double> shortestPath){
        // init the distance and the nextUnvisitedVertex
        double shortestDistance = Double.POSITIVE_INFINITY;
        Vertex nextUnknownVertex = null;
        // go through all the vertex, find the shortest, unknown vertex and return it

        for (Vertex vertex : Vertexes){
            if (vertex.isKnown())
                continue;

            double currentDistance = shortestPath.get(vertex);

            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                nextUnknownVertex = vertex;
            }
        }
        return nextUnknownVertex;
    }

    /**
     * Add vertex, only use for the vertexes which have no edges
     * Since vertexes has been added during the addEdges process
     * @param names the names of vertex
     */

    public void addVertex(Vertex... names){
        Vertexes.addAll(Arrays.asList(names));
    }

    /**
     * Add edges to the graph.
     *
     * @param source      the source Vertex
     * @param destination the destination Vertex
     * @param weight      the weight of edges
     */
    public void addEdge(Vertex source,Vertex destination,double weight) {
        Vertexes.add(source);
        Vertexes.add(destination);

        addEdgeHelper(source, destination, weight);

        if (!isDirected && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    // Go through all the edges and see whether that edge has already been added
    private void addEdgeHelper(Vertex source, Vertex destination, double weight) {
        for (Edge edge : source.edges) {
            if (edge.source == source && edge.destination == destination) {
                // Update the value in case it's a different one now
                edge.weight = weight;
                return;
            }
        }
        // add it if it hasn't been addeds
        source.edges.add(new Edge(source, destination, weight));
    }

    /**
     * Print edges.
     */
    public void printEdges(){
        for (Vertex vertex : Vertexes) {
            LinkedList<Edge> edges = vertex.edges;

            if (edges.isEmpty()) {
                System.out.println("Vertex " + vertex.getName() + " has no edges.");
                continue;
            }
            System.out.print("Node " + vertex.getName() + " has edges to: ");

            for (Edge edge : edges) {
                System.out.print(edge.destination.getName() + "(" + edge.weight + ") ");
            }
        }
    }

    /**
     * Check whether there is an edge between two Vertexes.
     *
     * @param source      the source
     * @param destination the destination
     * @return boolean
     */
    public boolean hasEdge(Vertex source, Vertex destination){
        LinkedList<Edge> edges = source.edges;
        for (Edge edge : edges) {

            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reset all vertexes to unknown.
     */
    public void resetVertex(){
        for (Vertex vertex : Vertexes) {
            vertex.setKnown(false);
        }
    }
}
