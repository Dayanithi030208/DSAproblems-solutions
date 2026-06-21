class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            if(word.charAt(i) == ch){
                StringBuilder sb = new StringBuilder();
                for(int j = i ; j >= 0 ; j--){
                    sb.append(word.charAt(j));
                }
                String prefix = sb.toString();
                word = prefix + word.substring(i + 1 , n);
                return word;
            }
        }
        return word;
    }
}