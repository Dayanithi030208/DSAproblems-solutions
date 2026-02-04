class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int n = fruits.length;
        int count = 0;
        int max = 0;
        HashMap<Integer,Integer> typeFruit = new HashMap<>();
        for(int right = 0;right < n;right++){
            int type = fruits[right];
            typeFruit.put(type,typeFruit.getOrDefault(type,0)+1);
            count++;
            while(left <= right && typeFruit.size()>2){
                int check = fruits[left];
                typeFruit.put(check,typeFruit.getOrDefault(check,0)-1);
                left++;
                count--;
                if(typeFruit.get(check) == 0) {
                    typeFruit.remove(check);
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}