class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      boolean[] visited = new  boolean[n];
      boolean[] pathvisited = new boolean[n];
      boolean[] check = new boolean[n];
      for (int i = 0 ; i < n ; i++){
        if(!visited[i]){
            checkDFS(graph , i , visited , pathvisited , check);
        }
      }
      List<Integer> result = new ArrayList<>();
      for (int i = 0 ; i < n ; i++){
        if(check[i]) result.add(i);
      }
      return result;
    }

    private boolean checkDFS(int[][] graph, int node, boolean[] visited, boolean[] pathvisited , boolean[] check) {
        visited[node] = true;
        pathvisited[node] = true;
        check[node] = false;
        for (int adjacent : graph[node]) {
            if (!visited[adjacent]) {
                if (checkDFS(graph , adjacent, visited, pathvisited , check))
                    return true;
            } else if (pathvisited[adjacent])
                return true;
        }
        pathvisited[node] = false ;
        check[node] = true ;
        return false ;
    }
}