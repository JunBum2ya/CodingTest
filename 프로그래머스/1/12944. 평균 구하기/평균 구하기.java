class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        return sum * 1.0 / arr.length;
    }
}