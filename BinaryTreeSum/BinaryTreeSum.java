//Дадено  е бинарно дрво. Потоа дадена е вредноста на некој јазол во дрвото. Испечатете го збирот на
// елементите во неговото лево поддрво кои се помали од него и збирот на елементите во неговото
// десно поддрво кои се поголеми од него.
// You are given a binary tree and a node value in the tree. Print the sum of the elements of the
// node's left subtree that are lower than the given node value and the sum of the elements of the
//  node's right subtree that are greater than the given node value.
package BinaryTreeSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public int sumLeftSubtree(BNode<Integer> root, BNode<Integer> node) {
        if (node == null) return 0;

        if (node.info < root.info) {
            return sumLeftSubtree(root, node.left) + sumLeftSubtree(root, node.right) + node.info;
        }
        return sumLeftSubtree(root, node.left) + sumLeftSubtree(root, node.right);
    }

    public int sumRightSubtree(BNode<Integer> root, BNode<Integer> node) {
        if (node == null) return 0;

        if (node.info > root.info) {
            return sumRightSubtree(root, node.left) + sumRightSubtree(root, node.right) + node.info;
        }
        return sumRightSubtree(root, node.left) + sumRightSubtree(root, node.right);
    }
}

public class BinaryTreeSum {


    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        int baranaVrednost = Integer.parseInt(br.readLine());

        br.close();

        BNode<Integer> element = tree.root;

        Stack<BNode<Integer>> stack = new Stack<>();
        stack.push(tree.root);

        while (!stack.isEmpty()) {
            element = stack.pop();
            if (element == null) continue;
            if (element.info == baranaVrednost) break;
            stack.push(element.right);
            stack.push(element.left);
        }

        if (element == null) {
            System.out.println("Element not found!");
            return;
        }

        j = tree.sumLeftSubtree(element, element.left);
        k = tree.sumRightSubtree(element, element.right);
        System.out.println(j + " " + k);
    }
}


