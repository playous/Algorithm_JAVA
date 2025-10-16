import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());

        boolean hasAnswer = false;

        for (long i = 1; i <= 50000000 ; i ++) {
            long num = g + (i * i);
            if (isSquare(num)) {
                hasAnswer = true;
                bw.write(String.valueOf((long)Math.sqrt(num)) + "\n");
            }
        }
        if (!hasAnswer) bw.write("-1");
        bw.flush();
    }

    public static boolean isSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return (sqrt * sqrt == n);
    }
}

