class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya","ye","woo","ma"};
        for (String s: babbling){
            s = s.replace(baby[0],"+");
            s = s.replace(baby[1],"+");
            s = s.replace(baby[2],"+");
            s = s.replace(baby[3],"+");
            if(s.equals("+")||
              s.equals("++")||
              s.equals("+++")||
              s.equals("++++")) answer++;
        }
        return answer;
    }
}