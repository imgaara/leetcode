import java.util.Stack;

/**
 * 
 */

/**
 * @file Solution_Valid_Parentheses.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-7-3
 * 
 * 
 */
public class Solution_Valid_Parentheses
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                if (ch == '{' || ch == '[' || ch == '(') {
                    stack.push(ch);
                } else {
                    return false;
                }
            } else {
                if (ch == '{' || ch == '[' || ch == '(') {
                    stack.push(ch);
                } else {
                    if (isMatch(stack.peek(), ch)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isMatch(char a, char b) {
        if (a == '{' && b == '}') {
            return true;
        }
        
        if (a == '[' && b == ']') {
            return true;
        }
        
        if (a == '(' && b == ')') {
            return true;
        }
        
        return false;
    }
}
