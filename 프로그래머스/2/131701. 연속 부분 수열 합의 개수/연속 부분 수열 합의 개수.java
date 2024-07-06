import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < length; j++) {
                int sum = 0;
                for(int k = 0; k < i; k++) {
                    sum += elements[(j + k) % length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}