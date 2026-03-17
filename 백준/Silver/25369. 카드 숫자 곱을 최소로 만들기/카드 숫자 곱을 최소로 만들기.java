import java.io.*;
import java.util.*;

public class Main {

    static int A = 1;
    static int n;
    static int[] count = new int[10];
    static int[] answer;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            A *= num;
        }

        calc(1, 0);

        if (!find) System.out.print("-1");
        else{
            for (int i = 1; i <= 9 ; i ++){
                if (answer[i] != 0){
                    for (int j = 0; j < answer[i]; j ++){
                        System.out.print(i + " ");
                    }
                }
            }
        }


    }

    public static void calc(int sum, int cnt){
        if (find) return;
        if(cnt == n){
            if (sum > A) {
                find = true;
                answer = count.clone();
            }
            return;
        }

        for (int i = 1; i <= 9 ; i ++){
            count[i]++;
            calc(sum * i , cnt + 1);
            count[i]--;
        }

    }

}