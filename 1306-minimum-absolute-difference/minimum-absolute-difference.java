class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        mergesort(arr , 0 , n - 1);
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
}