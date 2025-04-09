class Solution {
    public int solution(int price) {
        int answer = price;
        if (price >= 100000){
            if (price < 300000 ){
                answer *= 0.95;
             }
            else if (price < 500000){
                answer *= 0.9;
             }
            else answer *= 0.8;
        }
        
        return answer;
    }
}