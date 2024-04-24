import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        int[] parent = IntStream.range(0, n).toArray();
        
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(parent, from);
            int toParent = findParent(parent, to);

            if (fromParent == toParent) continue;

            answer += cost;
            parent[toParent] = fromParent;
        }
        return answer;
    }

    private int findParent(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }else {
            parent[node] = findParent(parent, parent[node]);
            return parent[node];
        }
    }

}
