class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       List<List<Integer>> graph = new ArrayList<>();
       for(int i = 0; i < n ; i++){
        graph.add(new ArrayList<>());
       } 
       for(int []edge : edges ){
        int u = edge[0];
        int v = edge[1];
        graph.get(u).add(v);
        graph.get(v).add(u);
       }
       boolean [] visited = new boolean[n];
    return dfs(source, destination, graph , visited);
    }
    boolean dfs (int currentVertex, int destination,List<List<Integer>> graph, boolean[] visited){
        if(currentVertex == destination){
            return true;
        }
        visited[currentVertex] = true;
        for(int neighbour : graph.get(currentVertex)){
            if(!visited[neighbour]){
               if (dfs(neighbour, destination, graph, visited)){
                return true;
               }
            }
        }
        return false;
    }
}