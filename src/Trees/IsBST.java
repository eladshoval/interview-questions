package Trees;

public class IsBST {

    private static class Node {
        // TODO - add getters, setters, constructors
        public int data;
        public Node right;
        public Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean check(Node root) {
        if (root == null) {
            return true;
        }

        // check current child’s right & left children (grandchildrens) with current to make sure both are smaller on the left,  and both are larger (maybe equal) on the right
        // pass in recursion the MAX to left and MIN to right 

        ////  return check(root.left, root.data, root.right, root.data);

        return checkLeft(root.left, root.data) && checkRight(root.right, root.data);
    }


    private boolean checkLeft(Node root, int max) {
        if (root == null && root == null) {
            return true;
        }

        if (root.data > max) return false;

        if (root.left != null && root.left.data > root.data) return false;
        if (root.right != null && root.right.data > max) return false;

        if (root.right != null && root.left != null && root.right.data < root.left.data)
        return false;

        return checkLeft(root.left, root.data) && checkRight(root.right, root.data);
    }


    private boolean checkRight(Node root, int min) {
        if (root == null && root == null) {
            return true;
        }

        if (root.data < min) return false;

        if (root.left != null && root.left.data < min) return false;
        if (root.right != null && root.right.data < root.data) return false;

        if (root.right != null && root.left != null && root.right.data < root.left.data)
        return false;

        return checkLeft(root.left, root.data) && checkRight(root.right, root.data);
    }


/*
public boolean check(Node left, int max, Node right, int min) {
		if (right == null && left == null) {
			return true;
		}
		
		if (left.left != null && (left.left.data > max || left.data < left.left.data)) return false;
		if (left.right != null && left.right.data > max) return false;
		if (left.data < left.left.data) return false;
		if (left.data > left.right.data) return false;

		if (right.left != null && right.left.data < min) return false;
		if (right.right != null && right.right.data < min) return false;	

		return check(left.left, left.data, left.right, left.data) 
&& check(right.left, right.data, right.right, right.data);
}
*/


    public static void main(String args[]) {
        Node n1 = new Node(1);
        n1.right = new Node(5);

        IsBST isBst = new IsBST();

        System.out.println("Is BST - " + isBst.check(n1));
    }
}
