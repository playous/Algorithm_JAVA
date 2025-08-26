import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < s; i++) {
            if (str.charAt(i) == 'I') {
                int prev = 1;
                int max = 0;
                int count = 0;
                int j = i + 1;
                for (; j < s; j++) {
                    if(prev == 1 && str.charAt(j) == 'O') {
                        count++;
                        prev = 0;
                    }
                    else if (prev == 0 && str.charAt(j) == 'I') {
                        prev = 1;
                        max = count;
                    }
                    else {
                        break;
                    }
                }
                i = j - 1;
                if (max >= n){
                    answer += (max - n + 1);
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
