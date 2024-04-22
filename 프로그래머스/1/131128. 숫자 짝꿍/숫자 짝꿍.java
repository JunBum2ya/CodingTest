import java.util.*;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xArray = convertArray(X);
        int[] yArray = convertArray(Y);
        for(int i = 9; i >= 0; i--) {
            int xCount = xArray[i];
            int yCount = yArray[i];
            int count = xCount < yCount ? xCount : yCount;
            for(int j = 0; j < count; j++) {
                answer.append(i);
            }
        }
        if(answer.toString().equals("")) {
            return "-1";
        }
        if(answer.toString().startsWith("0")) {
            return "0";
        }
        return answer.toString();
    }
    
    private int[] convertArray(String numberStr) {
        int[] array = new int[10];
        for(int i = 0; i < numberStr.length(); i++) {
            int key = numberStr.charAt(i) - '0';
            array[key]++;
        }
        return array;
    }
}