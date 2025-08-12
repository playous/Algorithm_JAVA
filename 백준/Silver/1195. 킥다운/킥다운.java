import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = check(s1, s2);
        int len2 = check(s2, s1);

        bw.write(String.valueOf(Math.min(len1, len2)));
        bw.flush();
    }

    static int check(String big, String small) {
        int answer = big.length() + small.length();

        for (int i = 0; i <= big.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < small.length(); j++) {
                if (i + j >= big.length()) break;

                if(small.charAt(j) == '1') continue;
                else if(big.charAt(i+j) != '1') {
                    flag = false;
                    break;
                }
            }
            if(flag){
                int len = Math.max(big.length(), i + small.length());
                answer = Math.min(answer, len);
            }
        }
        return answer;
    }
}