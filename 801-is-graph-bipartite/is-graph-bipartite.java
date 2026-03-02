class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length ;
        int[] visited = new int[m] ;
        for (int i = 0 ; i < m ; i++){
            visited[i] = -1;
        }
        for (int i = 0 ; i < m ; i++){
            if(visited[i] == -1){
                if(!colorDFS (graph , i , visited,0)) return false ;
            }
        }
        return true;
    }
    // private boolean colorBFS (int[][] graph , int start , int[] visited){
    //     Queue<Integer> queue = new LinkedList<>() ;
    //     queue.add(start) ;
    //     visited[start] = 1;
    //     while ( !queue.isEmpty() ){
    //         int node = queue.peek();
    //         queue.poll();
    //         for (int adj : graph[node]){
    //             if(visited[adj] == -1){
    //                 visited[adj] = 1 - visited[node];
    //                 queue.add(adj);
    //             }
    //             else if (visited[node] == visited[adj]) return false;
    //         }
    //     }
    //     return true;
    // }
    private boolean colorDFS (int[][] graph , int start , int[] visited , int color){
        visited[start] = color;
        for (int adj : graph[start]){
            if(visited[adj] == -1){
                if(!colorDFS(graph ,adj ,visited ,1 - color)) return false;
            }
            else if (visited[adj] == color) return false;
        }
        return true;
    }
}