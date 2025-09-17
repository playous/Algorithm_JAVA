import java.io.*;
import java.util.*;

public class Main {
    static class Player{
        int name;
        int power;
        int magic;
        int rank;
        public Player(int name, int power, int magic){
            this.name = name + 1;
            this.power = power;
            this.magic = magic;
            this.rank = 0;
        }
        public void plusRank(){
            rank++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] rank = new int[n];

        List<Player> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(st.nextToken());
            int magic = Integer.parseInt(st.nextToken());
            list.add(new Player(i,power, magic));
        }

        for (int i = 0; i < n; i++) {
            Player p1 = list.get(i);
            for (int j = i + 1; j < n; j++) {
                Player p2 = list.get(j);
                int score1 = p1.power + p1.magic * p2.power;
                int score2 = p2.power + p2.magic * p1.power;
                if (score1 > score2) {
                    p1.plusRank();
                }
                else p2.plusRank();
            }
        }

        list.sort((a, b) -> b.rank - a.rank);
        for (int i = 0; i < n; i++) {
            bw.write(list.get(i).name + "\n");
        }

        bw.flush();

    }

}

