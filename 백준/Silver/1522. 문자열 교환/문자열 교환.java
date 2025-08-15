import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        int len = arr.length;
        int answer = 1000;
        int a = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a') {
                a++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a'){
                int bCount = 0;
                int aCount = a - 1;
                for (int j = i + 1; j < len + i; j++) {
                    if(arr[j % len] == 'b'){
                        bCount++;
                        aCount--;
                    }
                    if (arr[j % len] == 'a'){
                        aCount--;
                    }
                    if(aCount == 0){
                        answer = Math.min(answer, bCount);
                        break;
                    }
                }
            }

        }

        bw.write(String.valueOf(answer == 1000 ? 0 : answer));
        bw.flush();
    }

}