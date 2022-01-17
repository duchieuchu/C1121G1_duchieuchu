package ss12_java_collection_framework.optional.thuc_hanh.installing_a_bst;

public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        tree.insert(9);
        tree.insert(6);
        tree.insert(7);
        tree.insert(5);

        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
