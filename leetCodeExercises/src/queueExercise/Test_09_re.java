package queueExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test_09_re {
    public static void main(String[] args) {

    }
}

class CQueue {
    public Deque<Integer> inputStack;
    public Deque<Integer> outputStack;

    public CQueue() {
        inputStack = new LinkedList<>();
        outputStack = new LinkedList<>();
    }

/*    public void appendTail(int value) {
        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }
        inputStack.push(value);
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
    public int deleteHead() {
        if (outputStack.isEmpty()) return -1;
        else return outputStack.pop();
    }*/

    public void appendTail(int value) {
        inputStack.push(value);
    }
    public int deleteHead() {
        //做缓存
        if (outputStack.isEmpty()){
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (outputStack.isEmpty()) return -1;
        else return outputStack.pop();
    }
}
