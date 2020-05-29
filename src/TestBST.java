public class TestBST {
    public static void main(String[] args) {
        MyBinarySearchTree<String> searchTree= new MyBinarySearchTree<>();
        searchTree.insert("hello");
        searchTree.delete("he");
        searchTree.printAll();
    }
}
