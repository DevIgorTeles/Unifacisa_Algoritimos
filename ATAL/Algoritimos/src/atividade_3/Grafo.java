package atividade_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

    private int numVertices;
    private int[][] adjacencyMatrix;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int v, int w) {

        adjacencyMatrix[v][w] = 1;
        adjacencyMatrix[w][v] = 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz de Adjacência:\n");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(adjacencyMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 4);
        grafo.addEdge(1, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);

        System.out.println(grafo.toString());
    }
}
