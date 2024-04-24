class Solution {
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, 0, dungeons, visited);
    }
    
    private int dfs(int k,int count, int[][] dungeons,boolean[] visited) {
        int max = count;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                int temp = dfs(k - dungeons[i][1], count + 1, dungeons, visited);
                if(max < temp) {
                    max = temp;
                }
                visited[i] = false;
            }
        }
        return max;
    }
}