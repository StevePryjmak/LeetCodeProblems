# Intuition
The core challenge in this problem is to efficiently manage event bookings in a calendar without causing a triple booking. My initial thought was to utilize a data structure that could handle dynamic insertion of intervals while tracking overlap counts for each interval. A binary tree seems like a good fit because it allows for efficient management of non-overlapping periods, and can help us check for conflicts during insertion.

Main idea is to create a binary tree of timeline if two events owerlap we can split those event to 3 new events which not overlaps, but they have information about how mush difrent books are in that time. And this aprouch help us to solve this problme for any overlaps count by only changin one varible `maxOverlaps`

# Approach
The approach uses a binary tree to represent the booked intervals. Each node in the tree stores:
- The start and end of a booked event.
- An `intersection` value that tracks how many overlaps (double bookings) exist for that event.

When a new booking is requested:
1. **Check for potential triple bookings**: We recursively traverse the tree and check if the new event would overlap with any previously booked events in a way that causes a triple booking (i.e., where the `intersection` count is already 2).
2. **Handle Overlapping Periods**: If an overlap is detected, we split the overlapping interval into three distinct parts:
   - A part for the non-overlapping portion of the new interval.
   - The overlapping portion, where the `intersection` count is incremented.
   - The remaining part of the old interval.
3. **Insert the new event**: After confirming no triple booking, the event is inserted into the binary tree. The tree is updated to reflect the new non-overlapping periods and their associated intersection counts.

The binary tree structure helps efficiently manage the insertion of new events and the detection of triple bookings.

### Steps in the Solution:
- **canBook**: This function checks if the new event can be inserted without causing a triple booking by traversing the tree and ensuring that no node already has 2 intersections for the same interval.
- **insert**: This function inserts the new event into the binary tree, updating any existing overlaps, and splitting intervals as needed to ensure that the periods are correctly represented.

# Complexity
- **Time complexity**:  
  The time complexity of this approach depends on the height of the binary tree. In the worst case (unbalanced tree), the height of the tree could be $$O(n)$$, where $$n$$ is the number of bookings made. Hence, each operation (checking and inserting) would take $$O(n)$$ in the worst case. However, with balanced intervals, it can perform better with $$O(\log n)$$ time per booking.

- **Space complexity**:  
  The space complexity is $$O(n)$$, where $$n$$ is the number of events booked. Each event is stored as a node in the tree, and in the worst case, we may store all the events without any overlap, making the tree size proportional to the number of events.

# Code
```java []
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
```
``` java []
// Code with comments
public class MyCalendarTwo {
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

    public MyCalendarTwo() {
        root = null;
    }

    public boolean book(int start, int end) {
        if (canBook(root, start, end)) {
            root = insert(root, start, end, 0); // Assign back to root
            return true;
        }
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
}


```
``` java []
//Debug version only difrence it just displays some ouput
public class MyCalendarTwo {
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

    public MyCalendarTwo() {
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


```
# Thank You for Reading

![upwotecat.png](https://assets.leetcode.com/users/images/65ffc567-9831-40e8-aec3-d3e908b9c07a_1727475586.6945655.png)
