class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int min = sides[0] < sides[1] ? sides[0] : sides[1];
        int max = sides[0] > sides[1] ? sides[0] : sides[1];
        
        //max가 가장 긴 변인 경우
        for (int i = max - min + 1 ; i <= max ; i ++){
            answer++;
        }
        
        //나머지 한 변이 가장 긴 변인 경우
        for (int i = max + 1 ; i <= max + min - 1 ; i++){
            answer++;
        }
        
        return answer;
    }
}