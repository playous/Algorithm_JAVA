import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (flag == false || !stack.isEmpty()) {
                sb.append("NO\n");
            }
            else sb.append("YES\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}