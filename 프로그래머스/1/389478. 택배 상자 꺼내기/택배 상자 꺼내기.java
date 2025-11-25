import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int w, int num) {
        int numRow = (num - 1) / w;
        
        int posInRow = (num - 1) % w;
        
        int numY;
        if (numRow % 2 == 0) {
            numY = posInRow;
        } else {
            numY = w - 1 - posInRow;
        }
        
        int answer = 1; 
        
        for (int box = num + 1; box <= n; box++) {
            int row = (box - 1) / w;
            int pos = (box - 1) % w;
            
            int y;
            if (row % 2 == 0) {
                y = pos;
            } else {
                y = w - 1 - pos;
            }
            
            if (y == numY) {
                answer++;
            }
        }
        
        return answer;
    }
}