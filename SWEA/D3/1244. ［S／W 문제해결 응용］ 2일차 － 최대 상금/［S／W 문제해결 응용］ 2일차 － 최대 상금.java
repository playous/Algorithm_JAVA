import java.util.*;
import java.io.*;

class Solution
{
    static int answer = 0;
    static int count = 0;
    static int len = 0;
    static HashSet<String> set = new HashSet<>();

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            char[] num = st.nextToken().toCharArray();
            count = Integer.parseInt(st.nextToken());
            len = num.length;
            answer = 0;
            set.clear();
            
            findMax(num,0);
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }

    static void findMax(char[] num, int nowCount){
        String memo = new String(num) + "," + nowCount;
        if (set.contains(memo)) return;
        set.add(memo);
        
        if (count == nowCount){
            String current = new String(num);
            answer = Math.max(answer,Integer.parseInt(current));
            return;
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                char tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;

                findMax(num, nowCount + 1);

                num[j] = num[i];
                num[i] = tmp;
            }
        }
    }
}