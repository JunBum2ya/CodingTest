import java.util.*;

class Solution {
    
    private final static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] maps) {
        final int height = maps.length;
        final int width = maps[0].length();
        int[][] place = new int[height][width];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] goal = new int[2];
        for(int i = 0; i < height; i++) {
            String map = maps[i];
            for(int j = 0; j < width; j++) {
                char c = map.charAt(j);
                if(c == 'X') {
                    place[i][j] = 0;
                }else if(c == 'O') {
                    place[i][j] = 1;
                }else if(c == 'S') {
                    start[0] = i;
                    start[1] = j;
                    place[i][j] = 1;
                }else if(c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                    place[i][j] = 1;
                }else if(c == 'E') {
                    goal[0] = i;
                    goal[1] = j;
                    place[i][j] = 1;
                }
            }
        }
        
        int toLever = bfs(place, height, width, start, lever);
        if(toLever > 0) {
            int toGoal = bfs(place, height, width, lever, goal);
            if(toGoal > 0) {
                return toLever + toGoal;
            }
        }
        return -1;
    }
    
    private int bfs(int[][] place, int height, int width, int[] start, int[] goal) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];
        queue.add(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.peek();
            visited[temp[0]][temp[1]] = true;
            
            if(temp[0] == goal[0] && temp[1] == goal[1]) {
                return temp[2];
            }
            
            queue.poll();
            
            for(int[] direction: directions) {
                int newY = temp[0] + direction[0];
                int newX = temp[1] + direction[1];
                
                if(newY >= 0 && newY < height && newX >= 0 && newX < width) {
                    if(!visited[newY][newX] && place[newY][newX] == 1) {
                        visited[newY][newX] = true;
                        queue.add(new int[]{newY, newX, temp[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
    
}