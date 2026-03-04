class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int[] triplet : triplets){
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            if (triplet[0] == target[0]) a = true;
            if (triplet[1] == target[1]) b = true;
            if (triplet[2] == target[2]) c = true;
            if (a && b && c) return true;
        }
        return false;
    }
}