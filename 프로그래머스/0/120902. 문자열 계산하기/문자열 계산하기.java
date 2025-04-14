class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] st = my_string.split(" ");
        boolean flag = true;
        
        for (String s : st){
            if(s.equals("+")) flag = true;
            else if(s.equals("-")) flag = false;
            else {
                if(flag == true) answer += Integer.parseInt(s);
                if(flag == false) answer -= Integer.parseInt(s);
            }
        }
        return answer;
    }
}