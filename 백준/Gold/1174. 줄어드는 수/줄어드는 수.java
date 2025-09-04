import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            list.add((long)i);
        }
        for (int i = 0; i < 9; i++) {
            calc(i, 1);
        }
        Collections.sort(list);

        if (n > list.size()) {
            bw.write("-1");
        }
        else{
            bw.write(String.valueOf(list.get(n-1)));
        }
        
        bw.flush();
    }

    static void calc(long cur, int digit) {
        long num = cur == 0 ? 0 : cur / digit;
        for (int i = 1; i <= 9; i++) {
            if(i > num){
                list.add((long)i * digit * 10 + cur);
                calc((long)i * digit * 10 + cur, digit * 10);
            }
        }
    }
}
