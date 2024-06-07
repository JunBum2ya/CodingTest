import java.util.*;

class Solution {
    
    private final Map<Character,Character> bucketMap;
    
    public Solution() {
        this.bucketMap = new HashMap<>();
        bucketMap.put(']','[');
        bucketMap.put(')','(');
        bucketMap.put('}','{');
    }
    
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isBucket(s.substring(i, s.length()) + s.substring(0,i))){
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isBucket(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(bucketMap.containsKey(c)) {
                if(stack.isEmpty()) {
                    return false;
                }else {
                    if(bucketMap.get(c) != stack.pop()) {
                        return false;
                    }
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}