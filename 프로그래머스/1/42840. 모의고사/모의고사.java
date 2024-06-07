import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] typeA = {1,2,3,4,5};
        int[] typeB = {2,1,2,3,2,4,2,5};
        int[] typeC = {3,3,1,1,2,2,4,4,5,5};
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for(int i = 0; i < answers.length; i++) {
            int correct = answers[i];
            if(correct == typeA[i % typeA.length]) {
                countA++;
            }
            if(correct == typeB[i % typeB.length]) {
                countB++;
            }
            if(correct == typeC[i % typeC.length]) {
                countC++;
            }
        }
        int max = countA > countB ? (countA > countC ? countA : countC) : (countB > countC ? countB : countC);
        List<Integer> list = new ArrayList<>();
        if(max == countA) {
            list.add(1);
        }
        if(max == countB) {
            list.add(2);
        }
        if(max == countC) {
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}