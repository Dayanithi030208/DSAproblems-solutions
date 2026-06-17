class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;
        for(String word : words){
            if(checkPalindrome(word)) return word;
        }
        return "";
    }
    private boolean checkPalindrome(String word){
        int n = word.length();
        int left = 0;
        int right = n - 1 ;
        while(left <= right){
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}