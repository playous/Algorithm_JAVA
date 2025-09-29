import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] arr = new int[7];
            HashSet<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0 ; i < 7 ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0 ; i < 7 ; i ++){
                for (int j = i +1 ; j < 7 ; j++){
                    for (int q = j +1 ; q < 7 ; q++){
                        set.add(arr[i] + arr[j] + arr[q]);
                    }
                }
            }
            for (int num : set){
                list.add(num);
            }
            list.sort(Collections.reverseOrder());
            sb.append("#").append(test_case).append(" ").append(list.get(4)).append("\n");
		}
        
        bw.write(sb.toString());
        bw.flush();
	}
}