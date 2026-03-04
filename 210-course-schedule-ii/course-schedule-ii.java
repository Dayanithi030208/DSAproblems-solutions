class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            for(Integer it : adj.get(i)){
            indegree[it]++;
        }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            count++;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.offer(it);
                }
            }
        }
        if(count != numCourses) return new int[] {};
        int[] ans = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}