import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] cards = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[cards.length];
        dfs(set, visited, cards, 0, 0);
        for(Integer number : set) {
            if(isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(Set<Integer> set, boolean[] visited, int[] cards, int result, int number) {
        if(number > cards.length) {
            return;
        }
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int card = cards[i];
                int temp = result * 10 + card;
                set.add(temp);
                dfs(set, visited, cards, temp, number + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        for(int i = 2; i <= (int) Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
