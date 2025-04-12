class Solution {
    public int solution(int a, int b, int k) {
        int answer = 0;
        char cc = (char)( k + '0');
        for (int i = a; i <= b; i ++){
            String st = String.valueOf(i);
            char[] ch = st.toCharArray();
            for (char c : ch){
                if(c == cc) answer++;
            }
        }
        return answer;
    }
}