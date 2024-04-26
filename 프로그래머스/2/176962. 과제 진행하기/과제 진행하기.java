import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String[] solution(String[][] plans) {
        int index = 0;
        String[] answer = new String[plans.length];
        Stack<Task> stack = new Stack<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>();
        Arrays.stream(plans).map(Task::from).sorted().forEach(tasks::offer);
        Task currentTask = tasks.poll();
        while (currentTask != null) {
            if(tasks.isEmpty()) {
                //모든 일을 시작했을 경우
                answer[index++] = currentTask.name;
                while(!stack.isEmpty()) {
                    Task task = stack.pop();
                    answer[index++] = task.name;
                }
                currentTask = null;
            }else {
                //아직 하지 않은 일이 있을 경우
                Task nextTask = tasks.peek();
                if(nextTask.isAfter(currentTask)) {
                    //현재 업무가 완료 후 다음 업무가 있을 경우
                    answer[index++] = currentTask.name;
                    if(stack.isEmpty()) {
                        //중지한 업무가 없을 경우
                        currentTask = tasks.poll();
                    }else {
                        //중지한 업무가 있을 경우
                        int startTime = currentTask.getEndTime();
                        currentTask = stack.pop();
                        currentTask.setStartTime(startTime);
                    }
                }else {
                    //현재 업무를 중지하고 새 업무를 해야 할 경우
                    Task newTask = tasks.poll();
                    int remainTime = currentTask.getEndTime() - newTask.getStartTime();
                    currentTask.setTime(remainTime);
                    stack.push(currentTask);
                    currentTask = newTask;
                }
            }
        }
        return answer;
    }

    private static class Task implements Comparable<Task> {

        private String name;
        private int startTime;
        private int time;

        public Task(String name, int startTime, int time) {
            this.name = name;
            this.startTime = startTime;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getEndTime() {
            return startTime + time;
        }

        public static Task from(String[] task) {
            int[] startTime = Arrays.stream(task[1].split(":"))
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return new Task(task[0],startTime[0] * 60 + startTime[1],Integer.parseInt(task[2]));
        }

        public boolean isAfter(Task task) {
            return this.startTime >= task.getEndTime();
        }

        private boolean isDone() {
            return this.time <= 0;
        }

        @Override
        public int compareTo(Task o) {
            return this.startTime - o.startTime;
        }
    }
}
