class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        int n = digits.length;
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int num : digits){
            freq.put(num , freq.getOrDefault(num , 0) + 1);
        }
        for(int i = 100 ; i < 1000 ; i += 2){
            int number = i;
            HashMap<Integer , Integer> temp = findNumfreq(number);
            int tempcount = 0;
            for(Map.Entry<Integer , Integer> entry : temp.entrySet()){
                int digit = entry.getKey();
                if(!freq.containsKey(digit)) break;
                else{
                    if(freq.get(digit) >= temp.get(digit)) tempcount++;
                }
            }
            if(tempcount == temp.size()) count++;
        }
        return count;
    }
    private HashMap<Integer , Integer> findNumfreq(int number){
        HashMap<Integer , Integer> freq = new HashMap<>();
        while(number != 0){
            int digit = number % 10;
            freq.put(digit , freq.getOrDefault(digit,0) + 1);
            number = number / 10;
        }
        return freq;
    }
}