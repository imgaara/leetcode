import java.util.*;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack();
        String parentheses = "({[)}]";

        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            int index = parentheses.indexOf(cur);
            if (index < 3) {
                stack.push(index);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (index - stack.peek() == 3) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return !stack.isEmpty();
    }
}
