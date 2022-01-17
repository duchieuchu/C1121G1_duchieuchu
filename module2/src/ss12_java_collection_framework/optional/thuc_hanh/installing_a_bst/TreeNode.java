package ss12_java_collection_framework.optional.thuc_hanh.installing_a_bst;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e){
        element= e;
    }
}
