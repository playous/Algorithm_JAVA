import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        int cook = Integer.parseInt(br.readLine());

        int sum = hour * 60 + min;
        sum += cook;

        System.out.print(sum / 60 % 24 + " " + sum % 60);
    }
}