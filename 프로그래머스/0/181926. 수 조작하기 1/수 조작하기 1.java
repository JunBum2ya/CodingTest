class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(int i = 0; i < control.length(); i++) {
            char c = control.charAt(i);
            switch(c) {
                case 'w': answer = answer + 1;
                    break;
                case 's': answer = answer - 1;
                    break;
                case 'd': answer = answer + 10;
                    break;
                case 'a': answer = answer - 10;
                    break;
            }
        }
        return answer;
    }
}