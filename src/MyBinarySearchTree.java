import com.sun.source.tree.Tree;

public class MyBinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void printAll() {
        printAll(root);
    }

    public void printAll(TreeNode<T> root) {
        if(root!=null) {
            printAll(root.getLeftChild());
            System.out.println(root.getItem());
            printAll(root.getRightChild());
        }
    }

    public TreeNode<T> search(T item){
        if(root==null) return null;
        else return search(root,item);
    }
    public TreeNode<T> search(TreeNode<T> root, T item) {
        if(root!=null) {
            if(item.compareTo(root.getItem())<0) {
                return search(root.getLeftChild(),item);
            } else if(item.compareTo(root.getItem())>0) {
                return search(root.getRightChild(),item);
            } else {
                return root;
            }
        } else {
            return null;
        }
    }

    public void insert(T item) {
        if(root==null) this.root = new TreeNode<>(item);
        else insert(root,item);
    }

    public void insert(TreeNode<T> root, T item) {

        if(item.compareTo(root.getItem())<0) {
            if(root.getLeftChild()==null) {
                root.setLeftChild(new TreeNode<>(item));
            } else {
                insert(root.getLeftChild(),item);
            }
        } else if(item.compareTo(root.getItem())>0) {
            if(root.getRightChild()==null) {
                root.setRightChild(new TreeNode<>(item));
            } else insert(root.getRightChild(),item);
        } else {
            System.err.println("이미 있는 key 입니다.");
        }
    }


    public void delete(T item) {
        this.root = delete(root, item);
    }

    public TreeNode<T> delete(TreeNode<T> root, T item) {
        if(root!=null) {
            if(item.compareTo(root.getItem())<0) {
                root.setLeftChild(delete(root.getLeftChild(),item));
            } else if(item.compareTo(root.getItem())>0) {
                root.setRightChild(delete(root.getRightChild(),item));
            } else {
                root = deleteNode(root);
            }

            return root;
        } else return null;
    }

    public TreeNode<T> deleteNode(TreeNode<T> root) {
        if(root.getLeftChild()==null && root.getRightChild()==null) {
            return null;
        } else if(root.getLeftChild()==null) {
            return root.getRightChild();
        } else if(root.getRightChild()==null) {
            return root.getLeftChild();
        } else {
            TreeNode<T> curr = root.getRightChild();
            while(curr.getLeftChild()!=null) {
                curr = curr.getLeftChild();
            }
            root.setItem(curr.getItem());
            root.setRightChild(deleteMin(root.getRightChild()));
            return root;
        }
    }

    public TreeNode<T> deleteMin(TreeNode<T> root) {
        if(root.getLeftChild()==null) {
            return root.getRightChild();
        } else {
            root.setLeftChild(deleteMin(root.getLeftChild()));
            return root;
        }
    }
}

class TreeNode<T> {
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private T item;

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public TreeNode() {

    }

    public TreeNode(T item) {
        this.item = item;
    }
}
