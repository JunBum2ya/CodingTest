import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int book = -1;
        int[][] bookTimes = new int[book_time.length][2];
        for(int i = 0; i < bookTimes.length; i++) {
            String[] time = book_time[i];
            bookTimes[i][0] = convertMinutes(time[0]);
            bookTimes[i][1] = convertMinutes(time[1]) + 10;
        }
        Arrays.sort(bookTimes, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(int[] bookTime: bookTimes) {
            if(queue.isEmpty()) {
                queue.add(bookTime);
            }else {
                int[] temp = queue.peek();
                if(bookTime[0] >= temp[1]) {
                    queue.poll();
                }
                queue.add(bookTime);
            }
        }
        return queue.size();
    }
    
    private int convertMinutes(String time) {
        String[] chunks = time.split(":");
        return Integer.parseInt(chunks[0]) * 60 + Integer.parseInt(chunks[1]);
    }
}