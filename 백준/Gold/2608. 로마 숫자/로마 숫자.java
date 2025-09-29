import java.util.*;
import java.io.*;

class Main {
    static HashMap<Character, Integer> map = new HashMap<>();
    static HashMap<String, Integer> map2 = new HashMap<>();
    static HashMap<Integer, String> map3 = new HashMap<>();
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //초기값
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        map2.put("IV", 4);
        map2.put("IX", 9);
        map2.put("XL", 40);
        map2.put("XC", 90);
        map2.put("CD", 400);
        map2.put("CM", 900);

        map3.put(1, "I");
        map3.put(5, "V");
        map3.put(10, "X");
        map3.put(50, "L");
        map3.put(100, "C");
        map3.put(500, "D");
        map3.put(1000, "M");
        map3.put(4, "IV");
        map3.put(9, "IX");
        map3.put(40, "XL");
        map3.put(90, "XC");
        map3.put(400, "CD");
        map3.put(900, "CM");

        String num1 = br.readLine();
        String num2 = br.readLine();

        int sum = 0;

        for (String s : map2.keySet()) {
            if (num1.contains(s)) {
                sum += map2.get(s);
                sum -= map.get(s.charAt(0));
                sum -= map.get(s.charAt(1));
            }
            if (num2.contains(s)) {
                sum += map2.get(s);
                sum -= map.get(s.charAt(0));
                sum -= map.get(s.charAt(1));
            }
        }

        for (int i = 0; i < num1.length(); i++){
            sum += map.get(num1.charAt(i));
        }
        for (int i = 0; i < num2.length(); i++){
            sum += map.get(num2.charAt(i));
        }

        sb.append(sum + "\n"); // 답 1

        for (int i = 1000; i > 0; i /= 10) {
            int k = sum / i;
            if (k > 0) {
                if (k == 4 || k == 5 || k == 9) {
                    sb.append(map3.get(k * i));
                } else if (k < 4) { // 1,2,3
                    for (int j = 0; j < k; j++) {
                        sb.append(map3.get(i));
                    }
                } else if (k > 5) { // 6, 7, 8
                    sb.append(map3.get(5 * i));
                    for (int j = 0; j < k - 5; j++) {
                        sb.append(map3.get(i));
                    }
                }
            }
            sum %= i;
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}
