import java.util.*;
import java.io.*;

class Main {
    static boolean[] cantUsed = new boolean[10];
    static int n ,len;
    static int answer;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int c = Integer.parseInt(br.readLine());
        int n1 = n;

        while (n1 > 0) {
            n1 /= 10;
            len++;
        }

        if (c != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < c; i++) {
                int num = Integer.parseInt(st.nextToken());
                cantUsed[num] = true;
            }
        }
        answer = Math.abs(n - 100);

        if(!cantUsed[0]) answer = Math.min(answer, n + 1);
        for (int i = 1; i < 10; i++) {
            if(!cantUsed[i]){
                makeNums(i,1);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static void makeNums(int cur, int curLen){
        if(curLen == len || curLen == len - 1){
            answer = Math.min(answer, Math.abs(cur - n) + curLen);
        }
        else if(curLen == len + 1){
            answer = Math.min(answer, Math.abs(cur - n) + curLen);
            return;
        }
        cur *= 10;
        for (int i = 0; i < 10; i++) {
            if(!cantUsed[i]){
                makeNums(cur + i, curLen + 1);
            }
        }
    }

}