import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length -1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        int[] answer = new int[sortedList.size()];
        for(int i = 0; i < sortedList.size(); i++) {
            answer[i] = sortedList.get(i);
        }
        return answer;
    }
}