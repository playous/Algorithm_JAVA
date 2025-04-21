class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 0;
        int n = 0;
        for (int i = 1 ; i < num ; i++){
            n += i;
        }
        start = (total - n) / num;
        for (int i = 0 ; i < num ; i++){
            answer[i] = start++;
        }
        return answer;
    }
}