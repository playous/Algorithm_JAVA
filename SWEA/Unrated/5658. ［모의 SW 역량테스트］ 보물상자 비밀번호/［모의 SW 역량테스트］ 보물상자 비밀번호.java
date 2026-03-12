import java.util.*;
import java.io.*;

public class Solution {	
	
	static int n, k, slice;
	static char[] arr;
	static List<Integer> list;
	static HashSet<Integer> set;
	static HashMap<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		map.put('0', 0);
		map.put('1', 1);
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		map.put('A', 10);
		map.put('B', 11);
		map.put('C', 12);
		map.put('D', 13);
		map.put('E', 14);
		map.put('F', 15);
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			slice = (n / 4);
			
			String line = br.readLine();
			
			arr = new char[n * 2];
			
			for (int i = 0 ; i < n ; i ++) {
				arr[i] = line.charAt(i);
			}
			
			for (int i = n ; i < n * 2 ; i ++) {
				arr[i] = arr[i - n];
			}
			
			set = new HashSet<>();
			
			for (int i = 0 ; i <= slice ; i ++) {
				calc(i);
			}
			
			list = new ArrayList<>(set);
			
			list.sort((a, b) -> b - a);
			int answer = list.get(k - 1);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void calc(int start) {
		for (int i = start ; i < start + n ; i += slice) {
			String s = "";
			for (int j = i ; j < i + slice; j ++) {
				s += arr[j];
			}
			int num = calc2(s);
			set.add(num);
		}
	}
	
	public static int calc2(String s) {
		int len = s.length();
		
		int cIdx = len - 1;
		int sum = 0;
		
		for (int i = 0 ; i < len ; i ++) {
			char ch = s.charAt(cIdx--);
			
			int num = map.get(ch);
			
			sum += (Math.pow(16, i) * num);
		}
		return sum;
	}
	
}
