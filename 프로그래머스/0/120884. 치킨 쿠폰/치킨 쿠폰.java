class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int ticket = chicken;
        while (ticket > 9){
            int service = ticket / 10;
            answer += service;
            ticket -= service * 10;
            ticket += service;
            
        }
        
        return answer;
    }
}