import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int id;
        int food;
        Node (int id, int food){
            this.id = id;
            this.food = food;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new LinkedList<>();

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        for (int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1){
                int id = Integer.parseInt(st.nextToken());
                int food = Integer.parseInt(st.nextToken());
                list.add(new Node(id, food));
            }

            if (order == 2){
                int food = Integer.parseInt(st.nextToken());

                Node cur = list.remove(0);

                if(cur.food == food) {
                    listA.add(cur.id);
                }
                else {
                    listB.add(cur.id);
                }
            }
        }

        for (Node node : list){
            listC.add(node.id);
        }

        Collections.sort(listA);
        Collections.sort(listB);
        Collections.sort(listC);

        if (listA.size() == 0) {
            System.out.println("None");
        }
        else {
            for (int id : listA) {
                System.out.print(id + " ");
            }
            System.out.println();
        }

        if (listB.size() == 0) {
            System.out.println("None");
        }
        else {
            for (int id : listB) {
                System.out.print(id + " ");
            }
            System.out.println();
        }

        if (listC.size() == 0) {
            System.out.println("None");
        }
        else {
            for (int id : listC) {
                System.out.print(id + " ");
            }
            System.out.println();
        }

    }

}