class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int count = 0;
            for(int j = i; j < prices.length -1; j++){
                if(prices[i] <= prices[j]){
                    count++;
                }else{
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}