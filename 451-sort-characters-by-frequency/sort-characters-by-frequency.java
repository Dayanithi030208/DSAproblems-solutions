class Solution {    
    public String frequencySort(String s) {
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            frequencyMap.put(s.charAt(i),frequencyMap.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character>[] Buckets = new List[s.length() + 1];
        for (char c:frequencyMap.keySet()){
            int frequency = frequencyMap.get(c);
            if(Buckets[frequency] == null){
                Buckets[frequency] = new ArrayList<>();
            }
            Buckets[frequency].add(c);
        }
        StringBuilder sorted_string = new StringBuilder();
        for (int i = Buckets.length-1;i >= 0;i--){
            if(Buckets[i] != null){
                for(char c:Buckets[i]){
                     for(int j = 0;j < i;j++){
                        sorted_string.append(c);
                     }
                }
            }
        }
        return sorted_string.toString();
    }
}