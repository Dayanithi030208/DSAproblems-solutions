class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length ;
        int[] visited = new int[m] ;
        for (int i = 0 ; i < m ; i++){
            visited[i] = -1;
        }
        for (int i = 0 ; i < m ; i++){
            if(visited[i] == -1){
                if(!colorBFS (graph , i , visited)) return false ;
            }
        }
        return true;
    }
    private boolean colorBFS (int[][] graph , int start , int[] visited){
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(start) ;
        visited[start] = 1;
        while ( !queue.isEmpty() ){
            int node = queue.peek();
            queue.poll();
            for (int adj : graph[node]){
                if(visited[adj] == -1){
                    visited[adj] = 1 - visited[node];
                    queue.add(adj);
                }
                else if (visited[node] == visited[adj]) return false;
            }
        }
        return true;
    }
}