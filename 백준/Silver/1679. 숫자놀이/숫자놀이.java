import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int max = nums[n - 1] * k;
        boolean[][] flag = new boolean[k + 1][max + 1];
        boolean[] check = new boolean[max + 1];

        for (int num : nums) {
            flag[1][num] = true;
            check[num] = true;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= max; j++) {
                for (int q = 0; q < n; q++) {
                    if (j - nums[q] < 1) continue;
                    if (flag[i-1][j - nums[q]]) {
                        flag[i][j] = true;
                        check[j] = true;
                        break;
                    }
                }
            }
        }


        int answer = 0;
        boolean same = true;
        for (int i = 1; i <= max; i++) {
            if (!check[i]){
                if (i % 2 == 0 ){
                    bw.write("holsoon win at " + i);
                }
                else{
                    bw.write("jjaksoon win at " + i);
                }
                same = false;
                break;
            }
        }

        if (same) {
            if (max % 2 == 0){
                bw.write("holsoon win at " + String.valueOf(max + 1));
            }
            else{
                bw.write("jjaksoon win at " + String.valueOf(max + 1));
            }
        }

        bw.flush();
    }

}