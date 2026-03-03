class Solution {
    public boolean lemonadeChange(int[] nums) {
        int count5 = 0;
        int count10 = 0;
        for (int num : nums){
            if(num == 5){
                count5++;
            }
            else if (num == 10){
                if(count5 > 0){
                    count5--;
                    count10++;
                }
                else {
                    return false;
                }
            }
            else{
                if(count10 > 0 && count5 > 0){
                    count10--;
                    count5--;
                }
                else if(count5 >= 3){
                    count5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}