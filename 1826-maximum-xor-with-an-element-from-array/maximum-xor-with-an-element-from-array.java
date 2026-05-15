class Node{
    Node[] links = new Node[2];
    boolean containsKey(int bit){
        return links[bit] != null;
    }
    void put(int bit , Node node){
        links[bit] = node;
    }
    Node get(int bit){
        return links[bit];
    }
}
class Trie{
    private Node root;
    Trie() {
        root = new Node();
    }

    void insert(int number) {
        Node node = root;
        for(int i =  31 ; i >= 0 ; i--){
            int bit = (number >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit , new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMAX(int number){
        Node node = root;
        int maxNum = 0;
        for(int i = 31 ; i >= 0 ; i--){
            int bit = (number >> i) & 1;
            if (node.containsKey(1 - bit)){
                maxNum |=( 1 << i);
                node = node.get(1 - bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[][] offlineQueries = new int[m][3];
        for(int i = 0 ; i < m ; i++){
            offlineQueries[i][0] = queries[i][1];
            offlineQueries[i][1] = queries[i][0];
            offlineQueries[i][2] = i;
        }
        Arrays.sort(offlineQueries , (a , b) -> a[0] - b[0]);
        Trie trie = new Trie();
        int[] result = new int[m];
        int index = 0;
        for(int[] query : offlineQueries){
            int mi = query[0];
            int xi = query[1];
            int originalIndex = query[2];
            while (index < nums.length && nums[index] <= mi) {
                trie.insert(nums[index]);
                index++;
            }
            if (index == 0) {
                result[originalIndex] = -1;
            } else {
                result[originalIndex] = trie.getMAX(xi);
            }
        }
        return result;
    }
}