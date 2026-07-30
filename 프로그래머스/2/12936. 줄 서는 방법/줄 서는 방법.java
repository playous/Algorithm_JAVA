import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        long[] fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k -= 1;

        for (int i = 0; i < n; i++) {
            long f = fact[n - 1 - i];
            int idx = (int) (k / f);
            k %= f;
            answer[i] = list.remove(idx);
        }

        return answer;
    }
}