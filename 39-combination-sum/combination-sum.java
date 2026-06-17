class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>>  answer = new ArrayList<>();
     findCombinations(candidates , target , answer , new ArrayList<>() , 0); 
     return answer;
    }

    private void findCombinations(int[] candidates, int target, List<List<Integer>> answer, List<Integer> current,
            int index) {
        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], answer, current, i);
            current.removeLast();
        }
    }
}