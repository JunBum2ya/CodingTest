import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int number = friends.length;
        int[] array = new int[number];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < number; i++) {
            map.put(friends[i],i);
        }
        int[][] matrix = new int[number][number];
        for(String gift: gifts) {
            String[] situation = gift.split(" ");
            matrix[map.get(situation[0])][map.get(situation[1])]++;
            array[map.get(situation[0])]++;
            array[map.get(situation[1])]--;
        }
        for(String friend: friends) {
            int sum = 0;
            int i = map.get(friend);
            for(int j = 0; j < number; j++ ) {
                int temp = matrix[i][j] - matrix[j][i];
                if(temp > 0) {
                    sum += 1;
                }else if(temp == 0) {
                    sum += (array[i] > array[j] ? 1 : 0);
                }
            }
            if(sum > answer) {
                answer = sum;
            }
        }
        return answer;
    }
}