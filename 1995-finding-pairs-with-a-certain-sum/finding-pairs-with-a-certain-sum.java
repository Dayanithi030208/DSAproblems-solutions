class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer,Integer> map = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = new int[nums1.length];
        this.nums2 = new int[nums2.length];
        for (int i = 0 ; i < nums1.length ; i++){
            this.nums1[i] = nums1[i];
        }
        for (int i = 0 ; i < nums2.length ; i++){
            this.nums2[i] = nums2[i];
            map.put(nums2[i] , map.getOrDefault(nums2[i] , 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        if(index < 0 || index >= nums2.length) return;
        map.put(nums2[index] , map.getOrDefault(nums2[index] , 0) - 1);
        nums2[index] += val;
        map.put(nums2[index] , map.getOrDefault(nums2[index] , 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int i = 0 ; i < nums1.length ; i++){
            if(map.containsKey(tot - nums1[i])) count += map.get(tot - nums1[i]);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */