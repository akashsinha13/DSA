package dsa.graph.dfs;

import java.util.List;
import java.util.Stack;

public class DFS {

    public static void dfs(List<Vertex> vertices) {
        for (Vertex v : vertices) {
            if (!v.isVisited()) {
                //dfsWithStack(v);
                dfsWithRecursion(v);

            }
        }
    }

    public static void dfsWithStack(Vertex v) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(v);
        v.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            System.out.println(vertex.getData());

            for (Vertex vertex1 : vertex.getNeighboursVertex()) {
                vertex1.setVisited(true);
                stack.push(vertex1);
            }
        }
    }

    public static void dfsWithRecursion(Vertex v) {

        System.out.println(v.getData());

        for (Vertex vertex1 : v.getNeighboursVertex()) {
            vertex1.setVisited(true);
            dfsWithRecursion(vertex1);
        }
    }
}
