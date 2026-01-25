class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
    private int mergesort(int[] nums,int low,int high){
        int cnt = 0;
        if(low < high){
            int mid = (low + high)/2;
            cnt+=mergesort(nums,low,mid);
            cnt+=mergesort(nums,mid+1,high);
            cnt+=merge(nums,low,mid,high);
        }
        return cnt;
    }
    private int merge(int[] nums,int low,int mid,int high){
        int cnt = 0;
        int left = low;
        int right = mid+1;
        int[] dup = new int[high-low+1];
        int index = 0; 
        int r = mid+1;
        for(int i=low;i<=mid;i++){
            while(r <= high && (long)nums[i] > 2L*nums[r]){
                r++;
            }
            cnt+=(r-(mid+1));
        }
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                dup[index++] = nums[left];
                left++;
            }else{
                dup[index++] = nums[right];
                right++;
            }
        }
        while(left <= mid){
            dup[index++] = nums[left];
            left++;
        }
        while(right <= high){
            dup[index++] = nums[right];
            right++;
        }
        for (int i=0;i<dup.length;i++){
            nums[low+i] = dup[i];
        }
        return cnt;
    }
}