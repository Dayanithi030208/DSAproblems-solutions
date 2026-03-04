class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        for (int i = 0 ; i < n;){
            int startIndex = i ;
            int endIndex = s.lastIndexOf(s.charAt(i));
            for (int j = startIndex + 1 ; j <= endIndex - 1 ; j++){
                int lastIndexOfCharInsideTheRange = s.lastIndexOf(s.charAt(j));
                if(lastIndexOfCharInsideTheRange > endIndex){
                    endIndex = lastIndexOfCharInsideTheRange;
                }
            }
            result.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }
        return result;
    }
}