class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for ( int i = 0 ; i < n ; i++){
            if(!visited[i]){
                bfsOfGraph(i,isConnected ,visited,queue);
                count++;
            }
        }
        return count;
    }
    public void bfsOfGraph(int node, int[][] isConnected ,boolean[] visited , Queue<Integer> queue) {
        int n = isConnected.length;
        visited[node] = true;
        queue.offer(node);
        while( !queue.isEmpty() ){
            int value = queue.poll();
            for(int j = 0 ; j < n ; j++){
                if(isConnected[value][j] == 1 && !visited[j]){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}