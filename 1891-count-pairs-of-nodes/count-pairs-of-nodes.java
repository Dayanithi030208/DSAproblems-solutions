import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {

        // degree[i] = degree of node i
        int[] degree = new int[n + 1];

        // shared edges count between each pair (u,v)
        Map<Long, Integer> shared = new HashMap<>();

        // Compute degree and shared edge counts
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;

            int a = Math.min(u, v);
            int b = Math.max(u, v);

            long key = ((long) a << 32) | b;
            shared.put(key, shared.getOrDefault(key, 0) + 1);
        }

        // Create sorted degree array (1-indexed nodes → 0-indexed array)
        int[] sortedDegree = new int[n];
        for (int i = 1; i <= n; i++) {
            sortedDegree[i - 1] = degree[i];
        }

        Arrays.sort(sortedDegree);

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int query = queries[q];

            // Step 1: Count pairs whose degree sum > query
            int left = 0;
            int right = n - 1;
            int count = 0;

            while (left < right) {

                if (sortedDegree[left] + sortedDegree[right] > query) {

                    // all nodes between left and right-1 with right form valid pairs
                    count += (right - left);
                    right--;

                } else {
                    left++;
                }
            }

            // Step 2: Correct overcount caused by shared edges
            for (Map.Entry<Long, Integer> entry : shared.entrySet()) {

                long key = entry.getKey();
                int sharedEdges = entry.getValue();

                int u = (int) (key >> 32);
                int v = (int) key;

                int totalDegree = degree[u] + degree[v];

                // counted by two-pointer
                // but actual incident count becomes <= query
                if (totalDegree > query &&
                    totalDegree - sharedEdges <= query) {

                    count--;
                }
            }

            answer[q] = count;
        }

        return answer;
    }
}