class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 10;
        while(true){
            answer += n % a;
            n /= a;
            if(n == 0) break;
        }
        return answer;
    }
}