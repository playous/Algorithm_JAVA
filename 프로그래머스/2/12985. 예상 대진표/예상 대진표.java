class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        
        small = (small + 1) / 2;
        big = (big + 1) / 2;
        
        while (big != small){
            small = (small + 1) / 2;
            big = (big + 1) / 2;
            answer++;
        }
        
        return answer;
    }
}