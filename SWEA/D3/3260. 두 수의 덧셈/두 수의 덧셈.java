import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T ; t++){
        	st = new StringTokenizer(br.readLine());
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	int max = Math.max(a.length(), b.length());
        	
        	int[] num1 = new int[max + 1];
        	int[] num2 = new int[max + 1];
        	
        	int idx = 0;
        	
        	for (int i = a.length() - 1; i >= 0; i--) {
        		int n = (int)(a.charAt(i) - '0');
        		num1[idx++] = n;
        	}
        	
        	idx = 0;
        	
        	for (int i = b.length() - 1; i >= 0; i--) {
        		int n = (int)(b.charAt(i) - '0');
        		num2[idx++] = n;
        	}
        	
        	
        	int[] answer = new int[max + 1];
        	
        	for (int i = 0; i < max ; i++) {
        		int sum = num1[i] + num2[i];
        		answer[i] += sum % 10;
        		num1[i+1] += sum / 10;
        	}
        	
        	answer[max] = num1[max];
        	
        	StringBuilder sb1 = new StringBuilder();
        	
        	for (int i = 0; i < max; i++) {
        		sb1.append(answer[i]);
        	}
        	if (answer[max] == 1) sb1.append(1);
        	
        	sb1.reverse();
        	
        	sb.append("#").append(t).append(" ").append(sb1).append("\n");
        }
        System.out.print(sb.toString());
	}
}
