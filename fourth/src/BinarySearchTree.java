public class BinarySearchTree<Anytype extends Comparable<? super Anytype>> {

    //嵌套类，节点
    private static class BinaryNode<Anytype> {
        BinaryNode(Anytype theElement) {
            this(theElement, null, null);
        }

        BinaryNode(Anytype theElement, BinaryNode<Anytype> lt, BinaryNode<Anytype> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        Anytype element;
        BinaryNode<Anytype> left;
        BinaryNode<Anytype> right;
    }


    private BinaryNode<Anytype> root;

    private BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Anytype x) {
        return contains(x, root);
    }

    public Anytype findMax() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMax(root).element;
    }

    public Anytype findMin() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMin(root).element;
    }

    public void setRoot(BinaryNode<Anytype> root) {
        this.root = root;
    }

    public void insert(Anytype x) {
        root = insert(x, root);
    }

    public void remove(Anytype x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.print("Empty Tree");
        else
            printTree(root);
    }

    private boolean contains(Anytype x, BinaryNode<Anytype> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else return true;
    }

    private BinaryNode<Anytype> findMin(BinaryNode<Anytype> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private BinaryNode<Anytype> findMax(BinaryNode<Anytype> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    private BinaryNode<Anytype> insert(Anytype x, BinaryNode<Anytype> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else ;
        return t;
    }

    private BinaryNode<Anytype> remove(Anytype x, BinaryNode<Anytype> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;

    }

    private void printTree(BinaryNode<Anytype> t) {
        if (t != null) {
            printTree(t.left);
            System.out.print(t.element);
            printTree(t.right);
        }
    }

    private int height(BinaryNode<Anytype> t) {
        if (t == null)
            return -1;
        else return 1 + Math.max(height(t.left), height(t.right));
    }

}


