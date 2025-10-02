import java.util.*;
import java.io.*;

class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static int[][] fire;
    static boolean[][] visited;

    static class Node{
        int r;
        int c;
        int time;
        public Node(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        
        // 불이 붙는 시점, (몇 초 뒤에 불이 붙는지)
        fire = new int[R][C];

        for (int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
            Arrays.fill(fire[i], Integer.MAX_VALUE);
        }

        /*
        불 처리
         */
        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[R][C];
        
        // 0초 상태일때의 F, 큐에 삽입 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        // 불이 번지는 과정 큐로 계산 (BFS)
        while (!q.isEmpty()){
            Node cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curTime = cur.time;
            fire[curR][curC] = curTime; 
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                    if (!visited[nextR][nextC] && map[nextR][nextC] == '.') {
                        q.add(new Node(nextR, nextC, curTime + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        /*
        미로 탈출 처리
         */
        q = new ArrayDeque<>();
        visited = new boolean[R][C];

        int answer = -1;

        // 시작 지점 큐에 삽입
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    // 시작 지점은 하나 뿐 -> break
                    break;
                }
            }
        }
        
        // 미로 탈출 최솟값 -> BFS 구현
        while (!q.isEmpty()){
            Node cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curTime = cur.time;
            
            // 탈출 가능 시점 (지도의 가장자리) 
            if (curR == 0 || curC == 0 || curR == R -1 || curC == C -1) {
                answer = curTime + 1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                    // fire[nextR][nextC] > curTime + 1 -> 불이 번지기 전 시점에서만 이동 가능
                    if (!visited[nextR][nextC] && map[nextR][nextC] == '.' && fire[nextR][nextC] > curTime + 1) {
                        q.add(new Node(nextR, nextC, curTime + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
        
        /*
        정답 출력
         */
        if (answer == -1) {
            bw.write("IMPOSSIBLE");
        }
        else {
            bw.write(String.valueOf(answer));
        }
        bw.flush();
    }
}