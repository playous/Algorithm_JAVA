import java.util.*;
import java.io.*;

public class Main {
    
    static Stack<Integer>[] stack = new Stack[7];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            Stack<Integer> s = stack[a];
            
            if (s.isEmpty()) {
                s.push(b);
                answer++;
                
            } else if (s.peek() == b) {
                continue;
                
            } else if (s.peek() < b) {
                s.push(b);
                answer++;
                
            } else {
                while (!s.isEmpty() && s.peek() > b) {
                    s.pop();
                    answer++;
                }
                if (s.isEmpty() || s.peek() != b) {
                    s.push(b);
                    answer++;
                }
            }
        }
        
        System.out.print(answer);
    }
}