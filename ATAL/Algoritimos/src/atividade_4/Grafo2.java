package atividade_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo2 {

    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Grafo2(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        /*
         * v = origem
         * w = destino
         */
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
    }

    public void bfs(int startVertex) {
        // Array para rastrear vértices visitados
        boolean[] visited = new boolean[numVertices];

        // Fila para a BFS
        Queue<Integer> queue = new LinkedList<>();

        // Marca o vértice inicial como visitado e o adiciona na fila
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("Busca em Largura a partir do vértice " + startVertex + ":");

        while (!queue.isEmpty()) {
            // Remove o próximo vértice da fila
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Itera sobre os vizinhos do vértice atual
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Marca o vizinho como visitado
                    queue.add(neighbor);     // Adiciona o vizinho na fila
                }
            }
        }

        System.out.println(); // Nova linha para finalizar a exibição
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numVertices; i++) {
            sb.append("Vértice: ").append(i).append(":\n");
            for (Integer neighbor : adjacencyList.get(i)) {
                sb.append(" -> ").append(neighbor).append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Grafo2 grafo = new Grafo2(5);

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 4);
        grafo.addEdge(1, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);

        System.out.println(grafo.toString());

        // Executa a BFS a partir do vértice 0
        grafo.bfs(0);
    }
}
