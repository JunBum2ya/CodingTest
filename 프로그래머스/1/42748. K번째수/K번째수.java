import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int flag = 0;
        for(int[] command : commands){
            int[] temp = new int[command[1]-command[0] + 1];
            int cnt = 0;
            for(int i = command[0]-1; i < command[1]; i++ ){
                temp[cnt++] = array[i];
            }
            Arrays.sort(temp);
            answer[flag++] = temp[command[2]-1];
        }
        return answer;
    }
}