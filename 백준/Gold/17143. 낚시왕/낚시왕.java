import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int r, c, m;
    static int[][] visited;
    static List<Node> list;

    static class Node {
        int r, c, s, d, z;
        Node(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[r + 1][c + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new Node(sr, sc, s, d, z));
        }

        rebuildVisited();

        int answer = 0;

        for (int col = 1; col <= c; col++) {
            answer += catchShark(col);

            moveAllSharks();
        }

        System.out.print(answer);
    }

    static void rebuildVisited() {
        visited = new int[r + 1][c + 1];
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            visited[node.r][node.c] = i + 1;
        }
    }

    static int catchShark(int col) {
        for (int i = 1; i <= r; i++) {
            if (visited[i][col] != 0) {
                int targetIdx = visited[i][col] - 1;
                int size = list.get(targetIdx).z;

                list.remove(targetIdx);

                rebuildVisited();
                return size;
            }
        }
        return 0; // 잡은 상어가 없으면 0
    }

    static void moveAllSharks() {
        visited = new int[r + 1][c + 1];
        Set<Integer> remove = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            moveShark(cur);

            if (visited[cur.r][cur.c] != 0) {
                int prevIdx = visited[cur.r][cur.c] - 1;
                Node prev = list.get(prevIdx);

                if (prev.z > cur.z) {
                    remove.add(i);
                } else {
                    remove.add(prevIdx);
                    visited[cur.r][cur.c] = i + 1;
                }
            } else {
                visited[cur.r][cur.c] = i + 1;
            }
        }

        List<Integer> removeList = new ArrayList<>(remove);
        removeList.sort(Collections.reverseOrder());
        for (int idx : removeList) {
            list.remove((int) idx);
        }

        rebuildVisited();
    }

    static void moveShark(Node node) {
        int flag = node.d;
        int cr = node.r;
        int cc = node.c;
        int s = node.s;

        int remain = 0;
        int remain2 = 0;

        if (flag == 1) { // 위
            s %= ((r - 1) * 2);
            remain = cr - 1;
            remain2 = remain + r - 1;
        } else if (flag == 2) { // 아래
            s %= ((r - 1) * 2);
            remain = r - cr;
            remain2 = remain + r - 1;
        } else if (flag == 3) { // 오른쪽
            s %= ((c - 1) * 2);
            remain = c - cc; // c - cc - 1 이 아님
            remain2 = remain + c - 1;
        } else if (flag == 4) { // 왼쪽
            s %= ((c - 1) * 2);
            remain = cc - 1; // cc 가 아님
            remain2 = remain + c - 1;
        }

        // 방향전환 0회
        if (s <= remain) {
            node.r += dr[flag - 1] * s;
            node.c += dc[flag - 1] * s;
        }
        // 방향전환 1회
        else if (s <= remain2) {
            int move = s - remain; // 벽에 부딪힌 후 반대로 이동할 거리
            if (flag == 1) {
                node.r = 1 + move;
                node.d = 2; // 방향 반전
            } else if (flag == 2) {
                node.r = r - move;
                node.d = 1;
            } else if (flag == 3) {
                node.c = c - move;
                node.d = 4;
            } else if (flag == 4) {
                node.c = 1 + move;
                node.d = 3;
            }
        }
        // 방향전환 2회
        else {
            int move = s - remain2; // 두 번 부딪힌 후 이동할 거리
            if (flag == 1) {
                node.r = r - move;
            } else if (flag == 2) {
                node.r = 1 + move;
            } else if (flag == 3) {
                node.c = 1 + move;
            } else if (flag == 4) {
                node.c = c - move;
            }
        }
    }
}