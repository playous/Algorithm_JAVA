class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int index = (k-1) * 2 ;
        answer = numbers[index % numbers.length];
        return answer;
    }
}