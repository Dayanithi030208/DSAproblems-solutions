class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int lastMax = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n -2 ; i >= 0 ; i--){
            if(arr[i] > lastMax){
                int temp = lastMax;
                lastMax = arr[i];
                arr[i] = temp;
            }
            else{
                arr[i] = lastMax;
            }
        }
        return arr;
    }
}