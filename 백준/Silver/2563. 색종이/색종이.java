import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();


        for (int i = 0; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int a = x ; a < x + 10 ; a++){
                for (int b = y ; b < y + 10 ; b++){
                    String s = a + "," + b;
                    set.add(s);
                }
            }
        }

        System.out.print(set.size());

    }
}