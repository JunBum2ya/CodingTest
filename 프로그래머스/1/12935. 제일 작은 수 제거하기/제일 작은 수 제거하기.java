import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = arr.length > 1 ? new int[arr.length -1] : new int[]{-1};
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > min) {
                answer[count++] = arr[i];
            }
        }
        return answer;
    }
}