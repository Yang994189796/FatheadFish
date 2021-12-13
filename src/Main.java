import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

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
