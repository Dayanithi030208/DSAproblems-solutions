class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int initend = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= initend) {
                initend = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
}