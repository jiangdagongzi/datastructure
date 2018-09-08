import java.nio.file.FileAlreadyExistsException;
import java.time.temporal.Temporal;

public class AVLTree<Anytype extends Comparable<? super Anytype>> {

    private static class AVLNode<Anytype> {
        AVLNode(Anytype theElement) {
            this(theElement, null, null);
        }

        AVLNode(Anytype theElement, AVLNode<Anytype> lt, AVLNode<Anytype> rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }

        Anytype element;
        AVLNode<Anytype> left;
        AVLNode<Anytype> right;
        int height;
    }

    private AVLNode<Anytype> root;

    private int height(AVLNode<Anytype> t) {
        return t == null ? -1 : t.height;
    }

    private AVLNode<Anytype> insert(Anytype x, AVLNode<Anytype> t) {
        if (t == null)
            return new AVLNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else ;
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AVLNode<Anytype> balance(AVLNode<Anytype> t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
            if (height(t.left.left) >= height(t.left.right))
                ;

        return null;
    }


}
