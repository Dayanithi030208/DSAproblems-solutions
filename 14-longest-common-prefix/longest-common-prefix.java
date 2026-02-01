class Solution {
    public String longestCommonPrefix(String[] str) {
        // My approach
        if (str ==  null || str.length == 0) return "";
        if (str.length == 1) return str[0];
        Arrays.sort(str);
        String first = str[0];
        String last = str[str.length-1];
        StringBuilder temp = new StringBuilder();
        for (int i=0;i < first.length();i++){
            if(i<last.length() && first.charAt(i) == last.charAt(i)){
                temp.append(first.charAt(i));
            }else break;
        }
        return temp.isEmpty()?"":temp.toString();
    }
}