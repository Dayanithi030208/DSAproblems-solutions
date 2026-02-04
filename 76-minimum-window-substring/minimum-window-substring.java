class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
    int startIndex = 0;
    int formed = 0;
    int minlen = Integer.MAX_VALUE;
    int m = s.length();
    int n = t.length();
    if(m < n) return "";
    HashMap<Character, Integer> map1 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char ch = t.charAt(i);
      map1.put(ch, map1.getOrDefault(ch, 0) + 1);
    }
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (int right = 0; right < m; right++) {
      char ch = s.charAt(right);
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
      if (map1.containsKey(ch)) {
        if (map1.get(ch).intValue() == map2.get(ch).intValue()) formed++;
      }
      while (left <= right && formed == map1.size()) {
        if((right-left+1) < minlen){
            startIndex = left;
            minlen = right-left+1;
        }
        char check = s.charAt(left);
        map2.put(check, map2.getOrDefault(check, 0) - 1);
        if (map1.containsKey(check)) {
          if (map1.get(check).intValue() > map2.get(check).intValue()) formed--;
        }
        left++;
      }
    }
    return minlen == Integer.MAX_VALUE ? "" :s.substring(startIndex,startIndex + minlen);
    }
}