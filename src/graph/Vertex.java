package graph;

import java.util.LinkedList;

/**
 * Vertex class,
 * content is in case that somthing needs to be store, it could be any datatype
 */
public class Vertex {
    private boolean isKnown;
    public LinkedList<Edge> edges;
    private double content;
    public String name;

    /**
     * Instantiates a new Vertex.
     *
     * @param name the name of Vertex
     */
    public Vertex(String name) {
        isKnown = false;
        edges = new LinkedList<>();
        content = 0.0;
        this.name = name;
    }

    /**
     * Instantiates a new Vertex.
     *
     * @param content in case we need to store sth.
     * @param name    the name
     */
    public Vertex(double content, String name) {
        isKnown = false;
        edges = new LinkedList<>();
        this.content = content;
        this.name = name;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public double getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(double content) {
        this.content = content;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Is known boolean.
     *
     * @return the boolean
     */
    public boolean isKnown() {
        return isKnown;
    }

    /**
     * Sets known.
     *
     * @param known the known
     */
    public void setKnown(boolean known) {
        isKnown = known;
    }
}
