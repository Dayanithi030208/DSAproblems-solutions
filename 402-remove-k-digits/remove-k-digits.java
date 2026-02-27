class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        for(int i = 0 ; i < n ; i++){
            char ch = num.charAt(i);
            while( !stack.isEmpty() && k > 0 && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while( k > 0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.pop();
            sb.append(ch);
        }
        sb.reverse();
        int i = 0 ;
        while( i < sb.length() - 1 && sb.charAt(i) == '0'){
            i++ ;
        }
        return sb.substring(i);
    }
}