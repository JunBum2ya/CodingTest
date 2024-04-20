import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stacks = createStackBoard(board);
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            if(!stacks[move -1].isEmpty()) {
                int item = stacks[move - 1].pop();
                if(stack.isEmpty()) {
                    stack.push(item);
                }else if(stack.peek() != item) {
                    stack.push(item);
                }else {
                    stack.pop();
                    answer+=2;
                }
            }
        }
        return answer;
    }
    
    private Stack<Integer>[] createStackBoard(int[][] board) {
        Stack[] stacks = Arrays.stream(board).map(it -> new Stack<Integer>()).collect(Collectors.toList()).toArray(new Stack[0]);
        for(int i = board.length -1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }
        return stacks;
    }
}