public class TreeBasicTraversals {


    public void inOrderTraversal(Node root) {

    /*
    Algorithm Inorder(tree)
       1. Traverse the left subtree, i.e., call Inorder(left-subtree)
       2. Visit the root.
       3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    */

        if (root == null) return;

        inOrderTraversal(root.getLeft());
        System.out.println(root);
        inOrderTraversal(root.getRight());

    }

    public void preOrderTraversal(Node root) {
        /*
        Algorithm Preorder(tree)
        1. Visit the root.
        2. Traverse the left subtree, i.e., call Preorder(left-subtree)
        3. Traverse the right subtree, i.e., call Preorder(right-subtree)
         */
        if (root == null) return;
        System.out.println(root);
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(Node root) {
        /*
        Algorithm Postorder(tree)
        1. Traverse the left subtree, i.e., call Postorder(left-subtree)
        2. Traverse the right subtree, i.e., call Postorder(right-subtree)
        3. Visit the root.
         */

        if (root == null) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root);
    }

    public int treeSize(Node root) {

        if (root == null) return 0;

        return 1 + treeSize(root.getRight()) + treeSize(root.getLeft());

    }

    public int treeMaxDepth(Node root) {

        if (root == null) return 0;

        return 1 + Math.max( treeMaxDepth(root.getLeft()), treeMaxDepth(root.getRight()) );

    }

}
