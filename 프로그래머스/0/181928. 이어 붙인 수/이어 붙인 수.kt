class Solution {
    fun solution(num_list: IntArray): Int {
        var str1 = ""
        var str2 = ""
        for(i in num_list) {
            if(i % 2 == 0) {
                str1 += i.toString();
            }else {
                str2 += i.toString();
            }
        }
        return Integer.parseInt(str1) + Integer.parseInt(str2)
    }
}