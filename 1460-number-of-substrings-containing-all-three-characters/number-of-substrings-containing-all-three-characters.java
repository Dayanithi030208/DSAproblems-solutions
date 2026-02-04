class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int n = s.length();
        int count = 0;
        for(int right = 0;right < n;right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(left <= right && map.size() == 3){
                count += n-right;
                char check = s.charAt(left);
                map.put(check,map.getOrDefault(check,0)-1);
                if(map.get(check) == 0){
                    map.remove(check);
                }
                left++;
            }
        }
        return count;
    }
}