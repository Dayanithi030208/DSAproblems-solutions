class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        for (int num : hand){
            if (map.get(num) == 0) continue;
            for (int i = 0 ; i < groupSize ; i++){
                int card = num + i;
                if( !map.containsKey(card) || map.get(card) == 0) return false;
                map.put(card , map.get(card) - 1);
            }
        }
        return true;
    }
}