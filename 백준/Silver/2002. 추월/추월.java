import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cars = new HashMap<>();
        HashMap<Integer, String> cars2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            cars.put(s, i);
        }

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            cars2.put(i, s);
            if(cars.get(s) < i) {
                for (int j = 1; j < i; j++) {
                    if(cars.get(cars2.get(j)) > cars.get(s)) {
                        set.add(cars2.get(j));
                    }
                }
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();

    }

}