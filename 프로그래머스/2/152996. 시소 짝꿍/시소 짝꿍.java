import java.util.*;

class Solution {
    
    private double[][] pair = new double[][]{{1.0, 1.0}, {2.0, 3.0}, {1.0, 2.0}, {3.0, 4.0}};
    
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int w : weights) {
            
            for(int i = 0; i < pair.length; i++) {
                double v = (w * pair[i][0]) / pair[i][1];
                if(map.containsKey(v)) {
                    answer += map.get(v);
                }
            }
            
            map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);
        }
        return answer;
    }
}