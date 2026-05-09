class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        for (int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '[') open++;
            else{
                if(open == 0) close++;
                else open--;
            }
        }
        if(open == 0 && close == 0) return 0;
        return ((open / 2) + (open % 2) + (close / 2) + ( close % 2)) / 2;
    }
}