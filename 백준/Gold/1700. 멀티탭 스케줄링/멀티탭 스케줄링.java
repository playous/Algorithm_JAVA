import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, k;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (!set.contains(arr[i])) {
                if (set.size() < n) {
                    set.add(arr[i]);
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    set.remove(getItem(i));
                    set.add(arr[i]);
                    map.put(arr[i], map.get(arr[i]) - 1);
                    count++;
                }
            } else {
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }

    static int getItem(int idx) {
        for (int num : set) {
            if (map.get(num) == 0) {
                return num;
            }
        }
        int maxIdx = 0;
        int maxItem = 0;
        for (int num : set) {
            int idxs = 0;
            for (int i = idx; i < k; i++) {
                if (num == arr[i]) {
                    idxs = i;
                    break;
                }
            }
            if (idxs > maxIdx) {
                maxIdx = idxs;
                maxItem = num;
            }
        }
        return maxItem;
    }
}
