package ArrayString.Stack;

// ques: https://neetcode.io/problems/baseball-game/question?list=neetcode250

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] operations) {
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for(String i : operations){
            if(i.equals("+")) {
                int k = st.pop();
                int l = st.peek();
                st.push(k);
                st.push(k+l);
            }
            else if (i.equals("D"))
                st.push(2 * st.peek());
            else if (i.equals("C"))
                st.pop();
            else
                st.push(Integer.parseInt(i));
            System.out.println(st);
        }


        while(!st.isEmpty())
            ans += st.pop();

        return ans;
    }
}
