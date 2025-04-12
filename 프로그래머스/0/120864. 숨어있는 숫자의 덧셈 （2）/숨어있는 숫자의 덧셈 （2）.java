class Solution {
    public int solution(String my_string) {
        long answer = 0;
        char[] ch = my_string.toCharArray();
        
        int num = 0;
        boolean flag = false;
        
        for (char c : ch){
            
            if(c >= '0' && c <= '9') {
                if (flag) num *= 10;
                num += c -'0';
                flag = true;
            }
            else {
                if (flag) answer += num;
                flag = false;
                num = 0;
            }
        }
        if (flag) answer+= num;
        return (int)answer;
    }
}