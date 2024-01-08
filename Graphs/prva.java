package Graphs;

import java.util.*;

class Graph<T> {
    private Map<T, Set<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyList.computeIfAbsent(vertex, k -> new HashSet<>());
    }

    public void removeVertex(T vertex) {
        removeVertexFromAllLists(vertex);
        adjacencyList.remove(vertex);
    }

    private void removeVertexFromAllLists(T vertex) {
        adjacencyList.values().forEach(neighbors -> neighbors.remove(vertex));
    }

    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        addEdgeToAdjacencyLists(source, destination);
    }

    private void addEdgeToAdjacencyLists(T source, T destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // for undirected graph
    }

    public void removeEdge(T source, T destination) {
        removeEdgeFromAdjacencyLists(source, destination);
        removeEdgeFromAdjacencyLists(destination, source); // for undirected graph
    }

    private void removeEdgeFromAdjacencyLists(T source, T destination) {
        adjacencyList.getOrDefault(source, Collections.emptySet()).remove(destination);
    }

    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptySet());
    }

    public void print() {
        adjacencyList.forEach((v, neighbors) ->
                System.out.printf("%s: %s\n", v, new ArrayList<>(neighbors)));
    }
}

public class prva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Graph<Integer> graph = new Graph<>();

        for (int i = 0; i < numCommands; i++) {
            processCommand(scanner.nextLine(), graph);
        }
    }

    private static void processCommand(String command, Graph<Integer> graph) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "CREATE":
                graph = new Graph<>();
                break;
            case "PRINTGRAPH":
                graph.print();
                System.out.println();
                break;
            case "ADDEDGE":
                graph.addEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                break;
            case "DELETEEDGE":
                graph.removeEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                break;
            default:
                printIsAdjacent(graph, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                break;
        }
    }

    private static void printIsAdjacent(Graph<Integer> graph, int vertex1, int vertex2) {
        System.out.println(graph.getNeighbors(vertex1).contains(vertex2));
    }
}
