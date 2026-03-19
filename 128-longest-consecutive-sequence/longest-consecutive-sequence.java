class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxcnt=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            int trv=num;
            if(!set.contains( num - 1 )){
                int curr = num;
                int cnt = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    cnt++;
                }

                maxcnt = Math.max(maxcnt, cnt);
            }
        }
        return maxcnt;
    }
}