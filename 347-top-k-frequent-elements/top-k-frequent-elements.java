class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int num : nums){
            map.put (num , map.getOrDefault(num , 0) + 1);
        }

        int n = nums.length;
        ArrayList<Integer>[] Bucket = new ArrayList[n + 1];

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(Bucket[value] == null){
                Bucket[value] = new ArrayList<>();
            }
            Bucket[value].add(entry.getKey());
        } 

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n ; i >= 0  && list.size() < k; i--){
            if(Bucket[i] != null){
                for (int num : Bucket[i]){
                    list.add(num);
                    if(list.size() == k) break;
                }
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size() ;i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}