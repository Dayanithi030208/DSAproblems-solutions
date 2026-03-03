class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0 ;
        int j = 0 ;
        int count = 0 ;
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length ;
        int n = s.length ;
        while ( i < m && j < n){
            if(s[j] >= g[i]){
                i++;
                j++;
                count ++;
            }
            else{
                j++;
            }
        }
        return count ;
    }
}