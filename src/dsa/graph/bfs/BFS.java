package dsa.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.println(vertex.getData());
            for (Vertex v : vertex.getNeighboursVertex()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
