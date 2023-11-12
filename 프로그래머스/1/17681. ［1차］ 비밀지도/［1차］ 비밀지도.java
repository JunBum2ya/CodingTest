class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        if(arr1.length == arr2.length) {
            String[] answer = new String[arr1.length];
            for(int i = 0; i < arr1.length; i++) {
                String row = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
                answer[i] = row.replaceAll("1","#").replaceAll("0"," ");
            }
            return answer;
        }else {
            throw new RuntimeException("잘못된 값이 들어왔어요.");
        }
    }
}