import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int missile = -1;
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        for(int[] target: targets) {
            int start = target[0];
            int end = target[1];
            if(missile < start || missile > end) {
                answer++;
                missile = end -1;
            }
        }
        return answer;
    }
}