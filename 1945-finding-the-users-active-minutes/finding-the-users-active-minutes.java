class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] UAMtime = new int[k];
        int n = logs.length;
        Arrays.sort(logs, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        HashMap<Integer, Integer> uniqueChecker = new HashMap<>();
        HashMap<Integer , Integer> uniqueCounter = new HashMap<>();
        for (int i = 0 ; i <  n ; i++){
            int id = logs[i][0];
            int time = logs[i][1];
            if(uniqueChecker.containsKey(id)){
                if(time != uniqueChecker.get(id)){
                    int count = uniqueCounter.get(id);
                    uniqueChecker.put(id,time);
                    uniqueCounter.put(id,count + 1);
                }
            }
            else{
                uniqueChecker.put(id,time);
                uniqueCounter.put(id,1);
            }
        }
        for(Map.Entry<Integer , Integer> entry : uniqueCounter.entrySet()){
            int value = entry.getValue();
            UAMtime[value - 1]++;
        }
        return UAMtime;
    }
}