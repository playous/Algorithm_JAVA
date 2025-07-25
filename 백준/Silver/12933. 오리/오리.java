import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();
        int[] arr = new int[5];
        boolean flag = true;
        int answer = 0;

        for (int i = 0; i < ch.length; i++) {
            int cnt = 0;
            if (!flag) {
                answer = -1;
                break;
            }
            if (ch[i] == 'q') arr[0]++;
            if (ch[i] == 'u') arr[1]++;
            if (ch[i] == 'a') arr[2]++;
            if (ch[i] == 'c') arr[3]++;
            if (ch[i] == 'k') arr[4]++;
            for (int j = 0; j < 4; j++) {
                if(arr[j] < arr[j+1])
                    flag = false;
                else if (arr[4] > 0){
                    cnt++;
                }
            }

            if (cnt == 4){
                answer = Math.max(arr[0], answer);
                for (int j = 0; j <= 4; j++) {
                    arr[j]--;
                }
            }
        }

        for (int j : arr) {
            if(j != 0) answer = -1;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}