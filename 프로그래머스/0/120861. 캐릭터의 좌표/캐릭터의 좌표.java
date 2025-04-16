class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = board[0]/2;
        int y = board[1]/2;
        
        for (String s : keyinput){
            int a = 0;
            int b = 0;
            if(s.equals("left")) a = -1;
            if(s.equals("right")) a = 1;
            if(s.equals("up")) b = 1;
            if(s.equals("down")) b = -1;
            
            if(answer[0] + a <= x && answer[0] + a >= -x && answer[1] + b <= y && answer[1] + b >= -y){
                answer[0] += a;
                answer[1] += b;
            }
            
        }
        return answer;
    }
}