import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T ; t++){
            Deque<String> stack = new ArrayDeque<>();
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < s.length; i++){
                stack.push(s[i]);
            }

            sb.append("Case ").append("#").append(t).append(":");

            for (int i = 0; i < s.length; i++){
                sb.append(" ").append(stack.pop());
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}