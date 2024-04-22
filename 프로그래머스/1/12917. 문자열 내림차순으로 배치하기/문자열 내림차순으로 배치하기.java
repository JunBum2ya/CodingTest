import java.util.*;

class Solution {
    public String solution(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuilder answer = new StringBuilder();
        for(int i = array.length -1; i >= 0; i--) {
            answer.append(array[i]);
        }
        return answer.toString();
    }
}