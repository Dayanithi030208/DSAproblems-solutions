class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int n = s.length();
        int max = 0;
        HashSet<Character> window = new HashSet<>();
        for (int right = 0;right < n;right++){
            char ch = s.charAt(right);
            while(left <= right && window.contains(ch)){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(ch);
            max = Math.max(max,window.size());
        }
        return max;
    }
}