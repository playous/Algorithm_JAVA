import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] top = new int[n + 1];
        int[] max = new int[n + 1];
        max[1] = 0;

        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(1);

        for (int i = 2; i <= n; i++) {
            if (!stack.isEmpty()){
                while (top[stack.peek()] < top[i]) {
                    stack.pop();
                    if (stack.isEmpty()){
                        break;
                    }
                }
            }

            if(stack.isEmpty()) {
                max[i]= 0;
            }
            else{
                max[i] = stack.peek();
            }
            stack.push(i);
        }
        
        for (int i = 1; i <= n; i++) {
            bw.write(max[i] + " ");
        }

        bw.flush();
    }
}
