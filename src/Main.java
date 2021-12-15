import queue.LoopQueue;
import queue.LoopQueue2;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        LoopQueue2<Integer> loopQueue2 = new LoopQueue2<>();
        for (int i = 1; i < 20; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
                loopQueue2.enqueue(i);
                System.out.println(loopQueue2);
            if (i%3==0){
                loopQueue.dequeue();
                System.out.println(loopQueue);
                loopQueue2.dequeue();
                System.out.println(loopQueue2);
            }
        }
    }

    /**
     * LeetCode 第20题；有效的括号
     * */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char element = chars[i];
            if ('['==element||'{'==element||'('==element) {
                stack.push(element);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char last = stack.pop();
                if (('['==last&&']'==element)||('{'==last&&'}'==element)||('('==last&&')'==element)){
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
