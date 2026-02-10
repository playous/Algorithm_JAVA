import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T;

	static int N;
	static int[][] board;
	static List<int[]> processors;
	static int[][] dList = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int maxCore;
	static int maxLine;

	static void dfs(int n, int lineCount, int coreCount) {
		if(coreCount + processors.size() - n < maxCore)
			return;
		if (n == processors.size()) {
			if (coreCount > maxCore) {
				maxLine = lineCount;
				maxCore = coreCount;
			} else if (coreCount == maxCore) {
				maxLine = Math.min(lineCount, maxLine);
			}
			return;
		}

		// 0 1 2 3
		int[] cur = processors.get(n);
		int x = cur[0];
		int y = cur[1];

		for (int[] d : dList) {
			boolean canConnect = false;
			for (int i = 1; i < N + 1; i++) {
				int nx = x + d[0] * i;
				int ny = y + d[1] * i;

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					canConnect = true;
					break;
				}
				if (board[nx][ny] != 0)
					break;
			}
			if (canConnect) {
				int lCount = 0;
				for (int i = 1; i < N + 1; i++) {
					int nx = x + d[0] * i;
					int ny = y + d[1] * i;

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						break;

					board[nx][ny] = 2;
					lCount++;
				}

				dfs(n + 1, lineCount + lCount, coreCount + 1);
				for (int i = 1; i < N + 1; i++) {
					int nx = x + d[0] * i;
					int ny = y + d[1] * i;

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						break;

					if (board[nx][ny] == 2)
						board[nx][ny] = 0;
				}
			}
		}
		dfs(n + 1, lineCount, coreCount);

	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			processors = new ArrayList<>();
			maxLine = 0;
			maxCore = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
					if (num == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1)
							processors.add(new int[] { i, j });
					}
				}
			}

			dfs(0, 0, 0);
			sb.append(maxLine);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
