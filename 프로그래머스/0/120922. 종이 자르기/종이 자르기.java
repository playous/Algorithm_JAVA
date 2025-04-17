class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        int x = M - 1;
        
        return x == 0 ? N - 1 : ((N - 1) * M) + x;
    }
}