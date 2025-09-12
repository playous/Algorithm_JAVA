import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            if(arr[i] == '(') stack.push(-1);
            if(arr[i] == '[') stack.push(-2);
            int sum = 0;
            if (arr[i] == ')') {
                if (stack.isEmpty()){
                    flag = false;
                    break;
                }
                while (stack.peek() != -1) {
                    sum += stack.pop();
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    stack.pop();
                    stack.push(sum * 2 == 0 ? 2 : sum * 2);
                }
            }
            if (arr[i] == ']'){
                if (stack.isEmpty()){
                    flag = false;
                    break;
                }
                while (stack.peek() != -2) {
                    sum += stack.pop();
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    stack.pop();
                    stack.push(sum * 3 == 0 ? 3 : sum * 3);
                }
            }
        }
        int answer = 0;
        if (flag) {
            for (int num : stack) {
                if(num < 0){
                    answer = 0;
                    break;
                }
                answer += num;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

