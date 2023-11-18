import java.lang.Math;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long d = (long) Math.sqrt(n);
        if(d * d == n) {
            return (d + 1) * (d + 1);
        } 
        return -1;
    }
}