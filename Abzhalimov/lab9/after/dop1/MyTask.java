package dop1;

import java.util.ArrayList;

public class MyTask {
    private int start;
    private int end;
    private boolean taskCompleted;
    private ArrayList<Integer>answers;

    public MyTask(int s, int e) {
        start = s;
        end = e;
        taskCompleted = false;
        answers = new ArrayList<>();
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean n) {
        taskCompleted = n;
    }

    public void pushSimple(int n) {
        answers.add(n);
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        if (answers.isEmpty() && taskCompleted) {
            sb.append("\nNo prime numbers in interval: ");
            sb.append(start);
            sb.append(" to ");
            sb.append(end);
            return sb.toString();
        }
        else {
            if (answers.isEmpty() && !taskCompleted) {
                sb.append("\n");
                for (int i = start; i <= end; i++) {
                    sb.append(i);
                    sb.append(" ");
                }
                return sb.toString();
            } else {
                sb.append("\n");
                sb.append(answers);
                return sb.toString();
            }
        }
    }
}
