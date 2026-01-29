class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1,k,n,result,new ArrayList<Integer>());
        return result;
    }
    private void findCombinations(int index,int k,int n,List<List<Integer>> result,ArrayList<Integer> current){
        if(current.size() > k || n < 0) return;
        if(current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
        }
        for(int i=index;i<10;i++){
            current.add(i);
            findCombinations(i+1,k,n-i,result,current);
            current.remove(current.size()-1);
        }
    }
}