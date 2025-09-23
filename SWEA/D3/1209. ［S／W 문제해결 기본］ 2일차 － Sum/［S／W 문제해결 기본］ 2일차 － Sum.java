import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int maxRow = 0;
            int maxCol = 0;
            int maxSlide1 = 0; // 내려가는 대각선 
            int maxSlide2 = 0; // 올라가는 대각선 (/)
			
            int test = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            
            int idx_C = 0;
            int idx_R = 100;
            for (int i = 0; i < 100 ; i ++){
                st = new StringTokenizer(br.readLine());
                int row = 0;
                for (int j = 0; j < 100 ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    row += arr[i][j];
                    if (i == j) maxSlide1 += arr[i][j];
                    if (i == idx_C && j == idx_R) {
                        maxSlide2 += arr[i][j];
                        idx_C--;
                        idx_R++;
                    }
                }
                maxRow = Math.max(maxRow,row);
            }
            
            for (int j = 0; j < 100 ; j ++){
                int col = 0;
                for (int i = 0 ; i < 100 ; i ++){
                    col += arr[i][j];
                }
                maxCol = Math.max(col,maxCol);
            }
                    
            int answer1 = Math.max(maxCol, maxRow);
            int answer2 = Math.max(maxSlide1, maxSlide2);
            int answer = Math.max(answer1,answer2);
            
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
                                                                        
	}
}