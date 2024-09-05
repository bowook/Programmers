import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node leftNode;
    Node rightNode;
    Node(String data) {
        this.data = data;
    }
}

class MakeTree {
    public Node root;

    public void createNode(String data, String leftNode, String rightNode) {
        if(root == null) {
            //초기 상태
            root = new Node(data);

            if(!leftNode.equals(".")) {
                root.leftNode = new Node(leftNode);
            }

            if(!rightNode.equals(".")) {
                root.rightNode = new Node(rightNode);
            }
        }
        else {
            //찾아야됨
            serachNode(root, data, leftNode, rightNode);
        }
    }

    private void serachNode(Node node, String data, String leftNode, String rightNode) {
        if(node == null) {
            return;
        }
        else if(node.data.equals(data)) {
            if(!rightNode.equals(".")) {
                node.rightNode = new Node(rightNode);
            }

            if(!leftNode.equals(".")) {
                node.leftNode = new Node(leftNode);
            }
        }
        else {
            //탐색해야됨
            serachNode(node.leftNode, data, leftNode, rightNode);
            serachNode(node.rightNode, data, leftNode, rightNode);
        }
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            if(node.leftNode != null) {
                preOrder(node.leftNode);
            }
            if(node.rightNode != null) {
                preOrder(node.rightNode);
            }
        }
    }

    public void inOrder(Node node) {
        if(node != null) {
            if(node.leftNode != null) {
                inOrder(node.leftNode);
            }
            System.out.print(node.data);
            if(node.rightNode != null) {
                inOrder(node.rightNode);
            }
        }

    }
    public  void postOrder(Node node) {
        if(node != null) {
            if(node.leftNode != null) {
                postOrder(node.leftNode);
            }
            if(node.rightNode != null) {
                postOrder(node.rightNode);
            }
            System.out.print(node.data);
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MakeTree tree = new MakeTree();

        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            tree.createNode(node, leftChild, rightChild);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}