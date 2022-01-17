package ss12_java_collection_framework.optional.thuc_hanh.installing_a_bst;

public interface Tree <E>{
    /*Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    boolean insert(E e);
    /**
     * Inorder traversal from the root
     */
    void inorder();
    /**
     * Get the number of nodes in the tree
     */
    int getSize();
}
