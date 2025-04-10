class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] ch = word.toCharArray();
        String gather = "AEIOU";
        int[] weight = new int[5];
        
        for (int i = 0 ; i < 5 ; i ++){
            int w = 0;
            for (int j = 0 ; j < 5 - i; j++){
                w += Math.pow(5,j);
            }
            weight[i] = w;
        }
        
        for (int i = 0 ; i < ch.length ; i ++){
            int sq = gather.indexOf(ch[i]);
            answer += (weight[i] * sq);
            answer++;
        }
        return answer;
    }
}