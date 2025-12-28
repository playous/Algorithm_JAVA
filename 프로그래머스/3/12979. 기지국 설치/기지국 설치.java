class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1;
        for (int num : stations){
            int last = num - w;
            while (cur < last) {
                answer++;
                cur += 2 * w + 1; 
            }
            cur = num + w + 1;  
        }
        
        while (cur <= n) {
            answer++;
            cur += 2 * w + 1;
        }
        
        return answer;
    }
}