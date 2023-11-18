import java.lang.Math

class Solution {
   fun solution(n: Long): Long {
        val sqrt = Math.sqrt(n.toDouble())
        return if(sqrt % 1.0 == 0.0) {
            Math.pow(sqrt + 1, 2.0).toLong()
        } else {
            -1L
        }
    }
}