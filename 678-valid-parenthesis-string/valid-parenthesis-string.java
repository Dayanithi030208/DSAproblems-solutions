class Solution {
    public boolean checkValidString(String s) {
        if (s.isEmpty()) return false;
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        return checkingValidString(s , 0 , 0,memo);
    }
    private boolean checkingValidString(String s , int index , int count , Boolean[][] memo){
        int n = s.length();
        if(count < 0) return false;
        if(index == n) return count == 0;
        if(memo[index][count] != null) return memo[index][count];
        if(s.charAt(index) == '(') {
            memo[index][count] = checkingValidString(s,index + 1 , count + 1,memo);
        }
        else if(s.charAt(index) == ')') {
            memo[index][count] = checkingValidString(s,index + 1 , count - 1,memo);
        }
        else{
            memo[index][count] = checkingValidString(s, index + 1, count + 1,memo) || checkingValidString(s, index + 1 , count - 1,memo) || checkingValidString(s, index + 1, count,memo);
        }
        return memo[index][count];
    }
}