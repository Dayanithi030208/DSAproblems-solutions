class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String temp = "1";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(n > 1){
            for(int i = 1 ; i < temp.length() ; i++){
                if(temp.charAt(i) != temp.charAt(i - 1)){
                    sb.append(count);
                    sb.append(temp.charAt(i - 1));
                    count = 1;
                }
                else count++;
            }
            sb.append(count);
            sb.append(temp.charAt(temp.length() - 1));
            count = 1;
            temp = sb.toString();
            sb.setLength(0);
            n--;
        }
        return temp;
    }
}