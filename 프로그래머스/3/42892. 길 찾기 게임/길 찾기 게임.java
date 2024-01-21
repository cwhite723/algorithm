import java.util.*;

class Solution {
    int [][] answer;
    Node[] nodes;
    int index;
    
    public int[][] solution(int[][] nodeinfo) {
        this.nodes = new Node[nodeinfo.length];
        this.answer = new int[2][nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) return o1.x - o2.x;
                return o2.y - o1.y;
            }
        });

        Node parent = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            makeTree(parent, nodes[i]);
        }

        index = 0;
        preorder(parent);
        index = 0;
        postorder(parent);
        
        return answer;
    }
    
    private void makeTree(Node parent, Node child) {
        if (parent.x < child.x) {
            if (parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        } else {
            if (parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        }
    }

    private void preorder(Node node) {
        if (node == null) return;
        answer[0][index++] = node.value;
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        answer[1][index++] = node.value;
    }
}

class Node {
        int value;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int value, int x, int y, Node left, Node right) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }