/**
 * -----------------------------------------------------------------------
 *     Copyright (C) 2015.  All rights reserved.
 * -----------------------------------------------------------------------
 */

/**
 * @author ewanggu
 * @since 2015
 *
 */
public class TreeNode {

    private int val;

    private TreeNode leftChild;

    private TreeNode rightChild;

    public TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.leftChild = left;
        this.rightChild = right;
    }

    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }

    /**
     * @param val the val to set
     */
    public void setVal(final int val) {
        this.val = val;
    }

    /**
     * @return the leftChild
     */
    public TreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(final TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public TreeNode getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(final TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public static int getNodeNum(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeNum(root.getLeftChild()) + getNodeNum(root.getRightChild()) + 1;
    }

    public static int getDeepNum(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftDeep = getDeepNum(root.getLeftChild());
        final int rightDeep = getDeepNum(root.getRightChild());
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }

    public static void preOrder(final TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getVal() + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

}
