import java.util.*;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Integer,Integer> xMap = convertMap(X);
        Map<Integer,Integer> yMap = convertMap(Y);
        for(int i = 9; i >= 0; i--) {
            int xCount = xMap.getOrDefault(i, 0);
            int yCount = yMap.getOrDefault(i, 0);
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
    
    private Map<Integer,Integer> convertMap(String numberStr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numberStr.length(); i++) {
            int key = numberStr.charAt(i) - '0';
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
        }
        return map;
    }
}