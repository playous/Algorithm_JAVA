import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1 ; i <= g ; i ++){
            set.add(i);
        }

        int answer = 0;
        for (int i = 0; i < p; i++) {
            int cur = Integer.parseInt(br.readLine());
            Integer canRemove = set.floor(cur);
            if (canRemove == null){
               break;
            }
            set.remove(canRemove);
            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}