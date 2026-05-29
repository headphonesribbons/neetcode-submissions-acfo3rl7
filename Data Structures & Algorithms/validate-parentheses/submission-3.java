class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        if (s.equals("")) {
            return true; 
        } else {
            String curr = String.valueOf(s.charAt(0)); // look at the first guy
            if (!is_open(curr)) { // if it's a close bracket,
                return false; // we have a close bracket with no open. invalid
            } else { // otherwise, it's an open bracket
                stack.push(curr); // push you in, cuz all open brackets go into the stack!
                int i = 1; // let's start the loop.
                while (i < s.length()) {
                    curr = String.valueOf(s.charAt(i));
                    if (is_open(curr)) { // if it's an open bracket,
                        stack.push(curr); // push the current into the stack.
                        i++; // then continue traversing through the string.
                    } else { // otherwise, it's a close bracket.
                        if (stack.isEmpty()) { // if the stack is empty, 
                            return false; // we have a closed bracket with no open bracket. invalid
                        } else { // the stack has something to look at:
                            String prev = stack.peek(); // look at the previous guy 
                            if (is_corresponding(curr, prev)) { // if it corresponds,
                                stack.pop(); // pop the prev guy out.
                                i++; // then continue traversing through the string.
                            } else { // otherwise it's invalid (doesn't correspond),
                                return false;
                            }
                        }
                    }
                }
                return stack.isEmpty();
            }
        }
    }

    public boolean is_open(String s) {
        if (s.equals("(") || s.equals("{") || s.equals("[")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_corresponding(String curr, String prev) {
        if (curr.equals(")")) {
            return prev.equals("(");
        } else if (curr.equals("}")) {
            return prev.equals("{");
        } else if (curr.equals("]")) {
            return prev.equals("[");
        } else {
            return false;
        }
    }
}