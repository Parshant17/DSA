

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph: map from airport to a min-heap of destinations
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        // This will store our final itinerary in reverse order
        LinkedList<String> path = new LinkedList<>();

        // Start DFS from JFK
        dfs("JFK", graph, path);

        return path;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> path) {
        PriorityQueue<String> dests = graph.get(airport);

        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll(); // always pick the smallest (lexical) destination
            dfs(next, graph, path);
        }

        // Add to path after visiting all destinations from this airport
        path.addFirst(airport); // Think of it as "building the path backward"
    }
}
