import java.util.Stack;

/**
 * This program is to check if a string is balanced using stack
 * To make it simple, the input only contains "{", "}", "(", and ")"
 * a balanced string is a string with all parentheses cover balanced string or nothing
 * e.g. {({})}, {}, (), ({()})
 * unbalanced string examples: {(}), ((), ()), ){}(
 */

public class Parser {

    public Parser() {}

    public boolean isBalanced(String input) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.startsWith("{", i) || input.startsWith("(", i)) {
                stack.add(input.substring(i, i + 1));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (input.startsWith("}", i) && stack.peek().equals("{")) {
                    stack.pop();
                    continue;
                }
                if (input.startsWith(")", i) && stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.size() == 0;
    }

}
