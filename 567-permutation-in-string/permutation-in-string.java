class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // character frequency
        // int[] s1freq=new int[26];
        // for(int i=0;i<s1.length();i++){
        //     s1freq[s1.charAt(i)-'a']++;
        // }
        // int n=s1.length();
        // for(int i=0;i<=s2.length()-n;i++){
        //     int[] s2freq=new int[26];
        //     for(int j=i;j<i+n;j++){
        //         s2freq[s2.charAt(j)-'a']++;
        //     }
        //     if(matches(s1freq,s2freq)) return true;
        // }
        // return false;
        int m = s1.length();
        int n = s2.length();
        int matched = 0;
        if ( m > n) return false;
        HashMap<Character,Integer> characterFrequency = new HashMap<>();
        for (int i = 0;i < m; i++){
            char ch = s1.charAt(i);
            characterFrequency.put(ch,characterFrequency.getOrDefault(ch,0)+1);
        }
        int left = 0;
        for (int right = 0; right < n; right++){
            char ch = s2.charAt(right);
            if (characterFrequency.containsKey(ch)){
                characterFrequency.put(ch,characterFrequency.get(ch) - 1);
                if(characterFrequency.get(ch) == 0) matched++;
            }
            if(right - left + 1 > m){
                char leftchar = s2.charAt(left);
                if(characterFrequency.containsKey(leftchar)){
                    if(characterFrequency.get(leftchar) == 0) matched--;
                    characterFrequency.put(leftchar,characterFrequency.get(leftchar) + 1);
                }
                left++;
            }   
            if (right - left + 1 == m && matched == characterFrequency.size()) return true;
        }
        return false;
    }
    // private static boolean matches(int[] a,int[] b){
    //     for(int i=0;i<26;i++){
    //         if(a[i]!=b[i]) return false;
    //     }
    //     return true;
    // }
}
