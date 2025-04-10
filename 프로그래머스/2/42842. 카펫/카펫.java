import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<int[]> ybox = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                int[] y_size = new int[2];
                y_size[0] = yellow/i;
                y_size[1] = i;
                ybox.add(y_size);
            }
        }
        int yx, yy;
        
        for(int[] arr : ybox){
            yx = arr[0];
            yy = arr[1];
            if((yx + yy) * 2 + 4 == brown){
               answer[0] = yx + 2;
               answer[1] = yy + 2;
               break;
            }
                
        }
        return answer;
    }
}