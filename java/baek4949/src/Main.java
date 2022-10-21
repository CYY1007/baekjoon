import java.util.*;

class Stack{
    private char[] stack;
    private int top;

    Stack(){
        this.stack = new char[100];
        this.top = -1;
    }

    void push(char c){
        this.stack[++top] = c;
    }

    void pop(){
        top--;
    }

    void clear(){
        this.top = -1;
    }

    char top(){
        if (top == -1)
            return '1';
        else
            return stack[top];
    }
    int getLength(){
        return this.top;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack checker = new Stack();
        Scanner cin = new Scanner(System.in);
        String s;
        while(true){
            Boolean balanced = true;
            s = cin.nextLine();
            if (s.charAt(0) == '.')
                break;
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (c == '('){
                    checker.push(c);
                }
                else if (c == '['){
                    checker.push(c);
                }
                else if (c == ')'){
                    if (checker.getLength() == -1 || checker.top() == '['){
                        balanced = false;
                        break;
                    }
                    else
                        checker.pop();
                }
                else if (c == ']'){
                    if (checker.getLength() == -1 || checker.top() == '(') {
                        balanced = false;
                        break;
                    }
                    else
                        checker.pop();
                }
            }
            if (balanced && checker.getLength() != -1)
                balanced = false;

            if (balanced)
                System.out.println("yes");
            else
                System.out.println("no");
            checker.clear();
        }
    }
}
