class Solution {
    public int solution(String s) {
        int answer = 0;
        int num = 0; 
        String[] str = s.split(" ");
        
        for (String st : str){
            if(st.equals("Z")) {
                answer -= num;
                continue;
            }
            num = Integer.parseInt(st);
            answer +=  num;
            
        }
        return answer;
    }
}