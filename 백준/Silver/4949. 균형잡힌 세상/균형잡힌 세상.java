import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        while (!s.equals(".")){
            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;

            for (int i = 0; i < arr.length; i++){
                if (arr[i] == '('){
                    stack.push('(');
                }
                if (arr[i] == '[') {
                    stack.push('[');
                }
                if (arr[i] == ')'){
                    if(stack.isEmpty() || !stack.peek().equals('(')){
                        sb.append("no\n");
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
                if (arr[i] == ']'){
                    if(stack.isEmpty() || !stack.peek().equals('[')){
                        sb.append("no\n");
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!flag) {
                if (stack.isEmpty()) sb.append("yes\n");
                else sb.append("no\n");
            }

            s = br.readLine();
        }
        System.out.print(sb.toString());
    }
}