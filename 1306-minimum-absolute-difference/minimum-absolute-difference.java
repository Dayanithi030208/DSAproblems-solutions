class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1 ; i < n ; i++){
            int diff = arr[i] - arr[i - 1];
            if ( diff < minDifference ){
                minDifference = diff;
                result = new ArrayList<>();
                result.add(Arrays.asList(arr[i - 1] , arr[i]));
            }else if (diff == minDifference){
                result.add(Arrays.asList(arr[i - 1] , arr[i]));
            }
        }
        return result;
    }
}