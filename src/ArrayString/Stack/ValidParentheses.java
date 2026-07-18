package ArrayString.Stack;

// ques: https://neetcode.io/problems/validate-parentheses/question?list=neetcode250

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch =='[')
                st.push(ch);
            else{
                if(st.isEmpty())
                    return false;
                if(ch == ')' && st.peek() != '(')
                    return false;
                else if(ch == ']' && st.peek() != '[')
                    return false;
                else if (ch == '}' && st.peek() != '{')
                    return false;

                st.pop();
            }

            i++;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("]");
    }
}
