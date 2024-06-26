import java.util.*;

class Solution {
    
    private final static int[][] directions = {{1, 0}, {-1, 0},{0, 1},{0, -1}};
    
    public int solution(int[][] land) {
        int height = land.length;
        int width = land[0].length;
        int[] amount = new int[width];
        boolean[][] visited = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, height, width, i, j, amount, visited);
                }
            }
        }
        int answer = -1;
        for(int oil : amount) {
            if(answer < oil) {
                answer = oil;
            }
        }
        return answer;
    }
    
    private void bfs(int[][] land, int height, int width, int y, int x, int[] amount, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        
        int count = 1;
        
        Set<Integer> set = new HashSet<>();
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int ny = temp[0];
            int nx = temp[1];
            
            set.add(nx);
            
            for(int[] direction: directions) {
                int my = ny + direction[0];
                int mx = nx + direction[1];
                
                if(my < 0 || mx < 0 || my >= height || mx >= width) {
                    continue;
                }
                
                if(land[my][mx] == 1 && !visited[my][mx]) {
                    queue.add(new int[]{my, mx});
                    visited[my][mx] = true;
                    count++;
                }
                
            }
            
        }
        
        for(int column : set) {
            amount[column] += count;
        }
        
    }
}