class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isCheckingMatch(s,p,0,0,memo);
    }
    private boolean isCheckingMatch(String s , String p , int sIndex , int pIndex ,Boolean[][] memo){
        if(sIndex == s.length() && pIndex == p.length()) return true;

        if(pIndex >= p.length()) return false;

        if(memo[sIndex][pIndex] != null) return memo[sIndex][pIndex];

        boolean charactersMatch = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        boolean isNextOneStar = pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*';

        boolean isMatch = false;

        if(charactersMatch){
            if(isNextOneStar){
                isMatch = isCheckingMatch(s, p , sIndex , pIndex + 2 , memo) || isCheckingMatch(s , p , sIndex + 1 , pIndex , memo);
            }else{
                isMatch = isCheckingMatch(s , p , sIndex + 1 , pIndex + 1 , memo);
            }
        }else{
            if(isNextOneStar){
                isMatch = isCheckingMatch(s , p , sIndex , pIndex + 2 , memo); 
            }else{
                
            }
        }
        memo[sIndex][pIndex] = isMatch;

        return memo[sIndex][pIndex];
    }
}