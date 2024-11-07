package P0729;

class MyCalendar {

    private Node root;

    public MyCalendar() {
        root = new Node(-1, -1);
    }

    public boolean book(int start, int end) {
        return root.book(start, end);
    }

    private class Node {
        int start, end;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }

        public boolean book(int start, int end) {
            if (end <= this.start) {
                if (this.left != null) return this.left.book(start, end);
                this.left = new Node(start, end);
                return true;
            }
            else if (start >= this.end) {
                if (this.right != null) return this.right.book(start, end);
                this.right = new Node(start, end);
                return true;
            }
            else return false;
        }
    }
}