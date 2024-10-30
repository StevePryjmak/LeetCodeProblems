package P0731;

// solution Debugging verstion
public class SolutionDebugging {
    private class Node {
        int start, end;
        int intersection; // Count of overlaps
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

    public SolutionDebugging() {
        root = null;
    }

    public boolean book(int start, int end) {
        System.out.println("Trying to book interval: [" + start + ", " + end + ")");
        if (canBook(root, start, end)) {
            root = insert(root, start, end, 0); // Assign back to root
            System.out.println("Booking successful!");
            printTree();
            System.out.println("");
            return true;
        }
        System.out.println("Booking failed!");
        System.out.println("");
        return false;
    }

    // Check if we can book without causing a triple booking
    private boolean canBook(Node node, int start, int end) {
        if (node == null) return true;

        // If completely to the left
        if (end <= node.start) {
            return canBook(node.left, start, end);
        }

        // If completely to the right
        if (start >= node.end) {
            return canBook(node.right, start, end);
        }

        // Overlap found, check if there's already an intersection (double booking)
        if (node.intersection >= 1) {
            return false; // Triple booking not allowed
        }

        // Recursively check left and right parts
        return canBook(node.left, start, Math.min(node.start, end)) && 
               canBook(node.right, Math.max(node.end, start), end);
    }

    // Insert a new interval into the binary tree
    private Node insert(Node node, int start, int end, int intersection) {
        if (node == null) {
            System.out.println("Inserting new node: [" + start + ", " + end + "), intersection: " + intersection);
            return new Node(start, end, intersection);
        }

        // If new event is to the left of the current node
        if (end <= node.start) {
            node.left = insert(node.left, start, end, intersection);
        }
        // If new event is to the right of the current node
        else if (start >= node.end) {
            node.right = insert(node.right, start, end, intersection);
        }
        // Overlapping part
        else {
            System.out.println("Splitting overlap with node: [" + node.start + ", " + node.end + ")");
            
            // Split intervals
            int s1 = Math.min(start, node.start);
            int e1 = Math.max(start, node.start);

            int s2 = e1;
            int e2 = Math.min(end, node.end);

            int s3 = e2;
            int e3 = Math.max(end, node.end);

            System.out.println("Splitting into: [" + s1 + ", " + e1 + "), [" + s2 + ", " + e2 + "), [" + s3 + ", " + e3 + ")");

            // Update current node to the overlapping part
            node.start = s2;
            node.end = e2;

            // Insert non-overlapping parts
            if(s1 != e1)
            node.left = insert(node.left, s1, e1, intersection);
            if(s3 != e3)
            node.right = insert(node.right, s3, e3, node.intersection);

            // Update intersection count for the overlapping part
            node.intersection += intersection + 1;
        }

        return node;
    }

    // Helper function to print tree for debugging
    public void printTree(Node node, int level) {
        if (node == null) return;

        // Print right subtree first
        printTree(node.right, level + 1);

        // Print the current node with indentation
        for (int i = 0; i < level; i++) {
            System.out.print("        "); // 8 spaces for padding
        }
        System.out.println("[" + node.start + ", " + node.end + ") - " + node.intersection);

        // Print left subtree
        printTree(node.left, level + 1);
    }

    // Public method to start printing from the root
    public void printTree() {
        printTree(root, 0);
    }
}

