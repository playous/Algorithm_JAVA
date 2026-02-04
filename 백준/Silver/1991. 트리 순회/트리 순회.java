import java.io.*;
import java.util.*;

class Node {
    char name;
    Node left;
    Node right;

    public Node(char name) {
        this.name = name;
    }
}

public class Main {

    static Node[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }
            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];
            }
            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue);
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();

    }

    static void preorder(Node node){
        if (node == null) return;
        System.out.print(node.name);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.name);
        inorder(node.right);
    }

    static void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.name);
    }
}

