package P1367;


class Solution {
    public boolean SubPathFrom(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if(root.val == head.val)
            return SubPathFrom(head.next, root.right) || SubPathFrom(head.next, root.left);
        return false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        if(SubPathFrom(head, root)) return true;
        return isSubPath(head, root.right) || isSubPath(head,root.left);
    }
}