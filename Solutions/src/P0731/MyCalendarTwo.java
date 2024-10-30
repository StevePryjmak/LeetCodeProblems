package P0731;


// Clean code
public class MyCalendarTwo {
    private class Node {
        int start, end;
        int intersection;
        Node left, right;

        public Node(int start, int end, int intersection) {
            this.start = start;
            this.end = end;
            this.intersection = intersection;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int maxOverlaps = 2; // Works for any number

    public MyCalendarTwo() {
        root = null;
    }

    public boolean book(int start, int end) {
        if (canBook(root, start, end)) {
            root = insert(root, start, end, 0);
            return true;
        }

        return false;
    }

    private boolean canBook(Node node, int start, int end) {
        if (node == null) return true;

        if (end <= node.start) return canBook(node.left, start, end);
        if (start >= node.end) return canBook(node.right, start, end);
        
        if (node.intersection >= maxOverlaps - 1) return false;

        return canBook(node.left, start, Math.min(node.start, end)) && 
               canBook(node.right, Math.max(node.end, start), end);
    }

    private Node insert(Node node, int start, int end, int intersection) {
        if (node == null) return new Node(start, end, intersection);

        if (end <= node.start) node.left = insert(node.left, start, end, intersection);
        else if (start >= node.end) node.right = insert(node.right, start, end, intersection);
        
        else {
            
            // Split intervals
            int s1 = Math.min(start, node.start);
            int e1 = Math.max(start, node.start);

            int s2 = e1;
            int e2 = Math.min(end, node.end);

            int s3 = e2;
            int e3 = Math.max(end, node.end);

            // Update current node to the overlapping part
            node.start = s2;
            node.end = e2;
            node.left = insert(node.left, s1, e1, intersection);
            node.right = insert(node.right, s3, e3, node.intersection);

            node.intersection += intersection + 1;
        }

        return node;
    }
}
