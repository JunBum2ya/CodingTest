class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int range = 0;
        for(int i = 0; i < section.length; i++) {
            int num = section[i];
            if(range < num) {
                range = num + m - 1;
                answer++;
            }
        }
        return answer;
    }
}