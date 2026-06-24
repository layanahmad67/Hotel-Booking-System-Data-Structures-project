package project;

public class BinaryTree<E> {

    public TreeNode<E> Root;
    public int size;

    public BinaryTree() {
        Root = null;
        size = 0;
    }

    public boolean hasLeft(TreeNode<E> node) {
        return (node.left != null);
    }

    public boolean hasRight(TreeNode<E> node) {
        return (node.right != null);

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode<E> addRoot(E e) {
        if (!isEmpty()) {
            System.out.println("Invalid action: Tree is not empty");
        } else {
            Root = new TreeNode<E>(e);
            size = 1;
        }
        return Root;
    }

    public TreeNode<E> search(TreeNode<E> root, E e, TreeNode<E> result) {
        if (root == null) {
            return null;
        }
        if (e == root.element) {
            return root;
        } else {
            if (root.left != null) {
                result = search(root.left, e, result);
            }

            if (root.right != null) {
                result = search(root.right, e, result);
            }

            return result;
        }

    }

    public void addLeft(E e, E p) {
        TreeNode<E> n = search(Root, p, null);
        if (n != null) {
            if (n.left != null) {
                System.out.println("parent already has a left child");
            } else {
                TreeNode<E> child = new TreeNode(e);
                n.left = child;
                child.parent = n;
                size++;
            }
        } else {
            System.out.println("parent does not exist");
        }
    }

    public void addRight(E e, E p) {
        TreeNode<E> n = search(Root, p, null);
        if (n != null) {
            if (n.right != null) {
                System.out.println("parent already has a left child");
            } else {
                TreeNode<E> child = new TreeNode(e);
                n.right = child;
                child.parent = n;
                size++;
            }
        } else {
            System.out.println("parent does not exist");
        }
    }

    public TreeNode<E> RoomSearch(TreeNode<E> root, E ele, TreeNode<E> available) {
        if (root == null) {
            return null;
        }
        if (ele == root.element) {
            return root;
        } else {
            if (root.left != null) {
                available = search(root.left, ele, available);
            }

            if (root.right != null) {
                available = search(root.right, ele, available);
            }

            return available;
        }
    }

    public Booking searchByBookingNum(int num) {
        return searchByBookingNum(Root, num);
    }

    private Booking searchByBookingNum(TreeNode<E> root, int num) {
        if (root == null) {
            return null;
        }

        if (((Booking) root.element).getBookingNum() == num) {

            return (Booking) root.element;

        }
        if (num < ((Booking) root.element).getBookingNum()) {
            return searchByBookingNum(root.left, num);
        } else {
            return searchByBookingNum(root.right, num);
        }
    }

    private TreeNode<E> AddBooking(TreeNode<E> root, Booking booking) {
        if (root == null) {
            root = new TreeNode<E>((E) booking);
            return root;
        }

        if (booking.getBookingNum() < ((Booking) root.element).getBookingNum()) {
            root.left = AddBooking(root.left, booking);
        } else if (booking.getBookingNum() > ((Booking) root.element).getBookingNum()) {
            root.right = AddBooking(root.right, booking);
        }
        return root;
    }

    public TreeNode<E> AddBooking(Booking booking) {
        return AddBooking(Root, booking);

    }

    private TreeNode<E> cancel(TreeNode<E> root, int bookingNum) {
        if (root == null) {
            System.out.println("The Booking not found.");
            return null;
        }
        if (bookingNum < ((Booking) root.element).getBookingNum()) {
            root.left = cancel(root.left, bookingNum);
        } else if (bookingNum > ((Booking) root.element).getBookingNum()) {
            root.right = cancel(root.right, bookingNum);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;

            }
        }
        return root;
    }

    public void cancelBooking(int bookingNum) {
        Root = cancel(Root, bookingNum);
    }

    private void Display(TreeNode<E> node) {
        if (node != null) {
            Display(node.left);
            System.out.println(node.element + " ");
            System.out.println("");
            Display(node.right);
        }

    }

    public void Display() {
        Display(Root);
    }

}// End Tree Class
