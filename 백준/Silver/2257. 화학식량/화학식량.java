import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        String s = br.readLine();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int temp = 0;

            if(c == '(') {
                stack.push(0);

            }else if (c == ')') {
                while (true) {
                    int n = stack.pop();
                    if(n == 0) break;
                    temp += n;
                }
                stack.push(temp);

            } else if ((int) c >= '1' && (int) c <= '9') {
                temp = stack.pop();
                temp *= (int) c - '0';
                stack.push(temp);

            } else {
                if (c == 'H') {
                    stack.push(1);
                }
                if (c == 'C'){
                    stack.push(12);
                }
                if (c == 'O'){
                    stack.push(16);
                }
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
