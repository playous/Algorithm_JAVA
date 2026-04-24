class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + cookie[i - 1];
        }

        for (int m = 1; m < n; m++) {
            int l = m;
            int r = m + 1;

            while (l >= 1 && r <= n) {
                int left = sum[m] - sum[l - 1];
                int right = sum[r] - sum[m];

                if (left == right) {
                    answer = Math.max(answer, left);
                    l--;
                    r++;
                } 
                else if (left < right) {
                    l--;
                } 
                else {
                    r++;
                }
            }
        }

        return answer;
    }
}