import java.util.*;
import java.io.*;

public class Main{

    static long nextNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();
        list.add(a);
        nextNum = a;
        int answer = 0;

        while (true) {
            powNum(nextNum, b);
            if (list.contains(nextNum)) break;
            list.add(nextNum);
        }
        for (long x : list) {
            if(x == nextNum) break;
            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void powNum(long a, int b){
        long sum = 0;
        while (a > 0){
            long k  = a % 10;
            sum += Math.pow(k, b);
            a /= 10;
        }
        nextNum = sum;
    }
}