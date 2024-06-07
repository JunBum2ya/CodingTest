import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length -1; i++) {
            int a = numbers[i];
            for(int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                set.add(a + b);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}