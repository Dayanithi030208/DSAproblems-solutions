class Solution {
    public int[][] insert(int[][] Intervals, int[] newInterval) {
        int i = 0;
        int n = Intervals.length;
        List<int[]> tempList = new ArrayList<>();
        while(i < n && Intervals[i][1] < newInterval[0]){
            tempList.add(Intervals[i]);
            i++;
        } 
        while(i < n && Intervals[i][0] <= newInterval[1]){
          newInterval[0] = Math.min(newInterval[0] , Intervals[i][0]);
          newInterval[1] = Math.max(newInterval[1] , Intervals[i][1]);
          i++;  
        }
        tempList.add(new int[] {newInterval[0] , newInterval[1]});
        while(i < n){
            tempList.add(Intervals[i]);
            i++;
        }
        int m = tempList.size();
        int[][] result = new int[m][2];
        for (int j = 0 ; j < m ; j++){
            result[j][0] = tempList.get(j)[0];
            result[j][1] = tempList.get(j)[1];
        }
        return result;
    }
}