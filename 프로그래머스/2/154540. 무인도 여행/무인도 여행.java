import java.util.*;

class Solution {
    
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[] solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        int[][] place = new int[height][width];
        for(int i = 0; i < height; i++) {
            String map = maps[i];
            for(int j = 0; j < width; j++) {
                char c = map.charAt(j);
                if(c == 'X') {
                    place[i][j] = 0;
                }else {
                    place[i][j] = Character.getNumericValue(c);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int result = bfs(place, visited, height, width, i, j);
                if(result > 0) {
                    list.add(result);
                }
            }
        }
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private int bfs(int[][] place, boolean[][] visited, int height, int width, int y, int x) {
        if(place[y][x] <= 0 || visited[y][x]) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        
        int sum = place[y][x];
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int[] direction: directions) {
                int newY = temp[0] + direction[0];
                int newX = temp[1] + direction[1];
                
                if(newY >= 0 && newY < height && newX >= 0 && newX < width) {
                    if(place[newY][newX] > 0 && !visited[newY][newX]) {
                        queue.add(new int[]{newY, newX});
                        visited[newY][newX] = true;
                        sum += place[newY][newX];
                    }
                }
            }
        }
        return sum;
    }
    
}