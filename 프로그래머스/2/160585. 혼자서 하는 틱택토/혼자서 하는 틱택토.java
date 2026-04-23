class Solution {
    public int solution(String[] board) {        
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0; j < 3 ; j ++){
                if(board[i].charAt(j) == 'O') count1++;
                if(board[i].charAt(j) == 'X') count2++;
            }
        }
        
        int flag1 = 0;
        int flag2 = 0;
        
        for (int i = 0 ; i < 3 ; i ++){
            if(board[i].charAt(0) == 'O' &&
              board[i].charAt(1) == 'O' &&
              board[i].charAt(2) == 'O') flag1++;
            
            if(board[0].charAt(i) == 'O'&&
              board[1].charAt(i) == 'O'&&
              board[2].charAt(i) == 'O') flag1++;
            
            if(board[i].charAt(0) == 'X' &&
              board[i].charAt(1) == 'X' &&
              board[i].charAt(2) == 'X') flag2++;
            
            if(board[0].charAt(i) == 'X'&&
              board[1].charAt(i) == 'X'&&
              board[2].charAt(i) == 'X') flag2++;
            
        }
            
        if(board[0].charAt(0) == 'O' &&
          board[1].charAt(1) == 'O' &&
          board[2].charAt(2) == 'O') flag1++;
        
        if(board[0].charAt(2) == 'O' &&
          board[1].charAt(1) == 'O' &&
          board[2].charAt(0) == 'O') flag1++;
        
        
        if(board[0].charAt(2) == 'X' &&
          board[1].charAt(1) == 'X' &&
          board[2].charAt(0) == 'X') flag2++;

        if(board[0].charAt(0) == 'X' &&
          board[1].charAt(1) == 'X' &&
          board[2].charAt(2) == 'X') flag2++;
        
        
        int answer = 1;
        
        if (count2 > count1 || count1 - count2 > 1) answer = 0;
        else {
            if (flag1 >= 1 && count1 != count2 + 1) answer = 0;
            if (flag2 >= 1 && count1 != count2) answer = 0;
            if (flag1 >= 1 && flag2 >= 1) answer = 0;
        }
        
        return answer;
    }
}
