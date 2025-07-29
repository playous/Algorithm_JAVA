import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int answer = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } 
            else {  
                stack.pop();
                if (ch[i-1] == '(') {  // 바로 앞이 '('면 레이저
                    answer += stack.size();  
                } 
                else {  // 철근의 끝
                    answer += 1;  
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}