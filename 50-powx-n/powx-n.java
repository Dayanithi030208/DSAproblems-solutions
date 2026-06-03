class Solution {
    public double myPow(double x, int n) {
        long pow = n ;
        if(pow < 0){
            x = 1 / x ;
            pow = -pow ;
        }
        return findPower( x , pow);
    }
    public double findPower( double x , long pow){
        if(pow == 0) return 1;
        
        double half = findPower( x , pow / 2);

        if( pow % 2 == 0){
            return half * half;
        } 

        return half * half * x;
    }
}