class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            HashMap<Character , Integer> map = new HashMap<>();
            for(int j = i ; j < n ; j++){
                char ch = s.charAt(j);
                map.put(ch , map.getOrDefault(ch , 0) + 1);
                if((map.containsKey('0') && map.get('0') > k) && (map.containsKey('1') && map.get('1') > k)) continue;
                count++;
            }
        }
        return count;
    }
}