class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String currentSequence = "1";
        StringBuilder sb = new StringBuilder();
        while(n > 1){
            int count = 1;
            for(int i = 1 ; i < currentSequence.length() ; i++){
                if(currentSequence.charAt(i) != currentSequence.charAt(i - 1)){
                    sb.append(count);
                    sb.append(currentSequence.charAt(i - 1));
                    count = 1;
                }
                else count++;
            }
            sb.append(count);
            sb.append(currentSequence.charAt(currentSequence.length() - 1));
            currentSequence = sb.toString();
            sb.setLength(0);
            n--;
        }
        return currentSequence;
    }
}