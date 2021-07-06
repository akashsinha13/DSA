package dsa.graph.bfs;

public class Test {

    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);

        v1.addNeighbourVertex(v2);
        v1.addNeighbourVertex(v5);
        v1.addNeighbourVertex(v7);
        v5.addNeighbourVertex(v6);
        v2.addNeighbourVertex(v3);
        v2.addNeighbourVertex(v4);

        BFS.bfs(v1);
    }
}
