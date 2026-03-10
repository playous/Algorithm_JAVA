import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int weight;
        int value;
        Node(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(w, v));
        }

        list.sort((a,b) -> a.weight - b.weight);

        int[] bag = new int[k];

        for (int i = 0; i < k; i++){
            int w = Integer.parseInt(br.readLine());
            bag[i] = w;
        }

        Arrays.sort(bag);

        long answer = 0;

        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0 ; i < k ; i ++){
            int cur = bag[i];

            while (true){
                if (idx == n) break;
                Node curNode = list.get(idx);
                if(curNode.weight <= cur) {
                    pq.add(curNode.value);
                    idx++;
                }
                else {
                    break;
                }
            }

            if (!pq.isEmpty()){
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }

}