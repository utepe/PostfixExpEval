package stack;

import java.lang.Math;

public class Utility {

    /**
     * parenthesesMatching Method
     * checks if the parenthes in the given expression are balanced
     * @param exp (String)
     * @return True (if balaned) else False
     */
    public static boolean parenthesesMatching(String exp){
        Stack<Character> stack = new Stack<Character>(20);
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if (c == '(') 
                stack.push(c); 
       
            if (c == ')') { 
                if (stack.isEmpty()) return false;
                else if (!isMatchingPair(stack.pop(), c)) return false; 
            }
       } 

       if (stack.isEmpty()) return true; 
       return false;
    }

    /**
     * convertPostfix Method
     * converts the given expression from infix to postfix notation
     * @param exp (String)
     * @return postfix (String)
     */
    private static String convertPostfix(String exp){
        String postfix = "";
        Stack<Character> stack = new Stack<Character>(20);
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c) || c == ' ') postfix += c;
            else if(c == '(') stack.push(c);
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    postfix += stack.pop();
                }
                stack.pop();
            }
            else{
                if(c == '-' && stack.peek() == '(')
                    stack.push('!');
                else{
                    while(!stack.isEmpty() && priority(c) <= priority(stack.peek()))
                        postfix += stack.pop();
                    
                    stack.push(c);
                }
                
            }
        }
        while(!stack.isEmpty()){
            postfix += stack.pop();
        }
        return postfix;
    }

    /**
     * evalPostfix Method
     * calls convertPostfix method, then evaluates the postfix
     * string and returns of the evaulated solution of the exprssion
     * @param exp (String)
     * @return solution (int)
     */
    public static int evalPostfix(String exp){
        exp = convertPostfix(exp);
        Stack<Integer> stack = new Stack<Integer>(20);
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)){
                int n = 0;
                while(Character.isDigit(c)){
                    n = n*10 + (int)(c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(n);
            }
            else if(c == '!'){
                int t = -(stack.pop());
                stack.push(t);
            }
            else{
                int O2 = stack.pop();
                int O1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(O1+O2);
                        break;
                    case '-':
                        stack.push(O1-O2);
                        break;
                    case '*':
                        stack.push(O1*O2);
                        break;
                    case '/':
                        stack.push(O1/O2);
                        break;
                    case '^':
                        stack.push((int)Math.pow(O1, O2));
                        break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * isMatchingPair Method
     * checks if the passed in characters are 
     * matching paranthesis pairs
     * @param char1
     * @param char2
     * @return true if matching else false
     */
    private static boolean isMatchingPair(char char1, char char2) { 
        if (char1 == '(' && char2 == ')') return true; 
        return false; 
    }

    /**
     * priority Method
     * defines and returns the operator precedence
     * based on the character operator entered
     * @param c (char)
     * @return int
     */
    private static int priority(char c) {
        switch (c){ 
            case '+': 
            case '-': 
                return 1; 
            case '*': 
            case '/': 
                return 2; 
            case '!':
                return 3;
            case '^': 
                return 4; 
        } 
        return -1; 
    }
}