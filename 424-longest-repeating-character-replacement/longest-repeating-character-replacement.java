class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxfreq = 0;
        int maxlen = 0;
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        int n = s.length();
        for (int right = 0;right < n;right++){
            char ch = s.charAt(right);
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
            maxfreq = Math.max(maxfreq,frequencyMap.get(ch));
            while((right-left+1) - maxfreq > k){
                char check = s.charAt(left);
                frequencyMap.put(check,frequencyMap.getOrDefault(check,0)-1);
                left++;
            }
            maxlen = Math.max(maxlen,(right-left+1));
        }
        return maxlen;
    }
}