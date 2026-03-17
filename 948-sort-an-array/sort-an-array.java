class Solution {
    public int[] sortArray(int[] nums) {
        // quicksort(nums , 0 , nums.length - 1);
        mergesort (nums , 0 , nums.length - 1);
        return nums;
    }
    public static void mergesort(int[] nums,int left,int right){
        int mid=(left+right)/2;
        if(left<right){
            mergesort(nums,left,mid);
            mergesort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public static void merge(int[] nums,int left, int mid,int right){
        int[] temp=new int[right-left+1];
        int i=left,k=0,j=mid+1;
        while(i<=mid&&j<=right){
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }
            else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=right) temp[k++]=nums[j++];
        for(int p=0;p<temp.length;p++){
            nums[left+p]=temp[p];
        }
    }
    public void quicksort( int[] nums , int left , int right ){
        if ( left < right ){
            int partition = findPartitionIndex ( nums , left , right );
            quicksort( nums , left , partition - 1);
            quicksort( nums , partition + 1 , right);
        }
    }
    public int findPartitionIndex (int[] nums , int left , int right ){
        int pivot = nums[left];
        int i = left + 1;
        int j = right;

        while (true){
            while (i <= right && nums[i] <= pivot) i++;
            while (j >= left && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums , i , j);
        }
        swap(nums , left , j);
        return j;
    }
    public void swap (int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}