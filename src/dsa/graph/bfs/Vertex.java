package dsa.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int data;
    private boolean isVisited;
    private List<Vertex> neighboursVertex;

    public Vertex(int data) {
        this.data = data;
        neighboursVertex = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getNeighboursVertex() {
        return neighboursVertex;
    }

    public void setNeighboursVertex(List<Vertex> neighboursVertex) {
        this.neighboursVertex = neighboursVertex;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", isVisited=" + isVisited +
                ", neighboursVertex=" + neighboursVertex +
                '}';
    }

    public void addNeighbourVertex(Vertex v) {
        this.neighboursVertex.add(v);
    }
}
