class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int n = 1; // 자릿수
        
        while(num / n >= 10){
            n *= 10;
        }
        
        while (num >= 0 && n > 0 ){
            answer++;
            if(num / n == k){
                return answer;
            }
            num %= n;
            n /= 10;
        }
    
        return -1;
    }
}