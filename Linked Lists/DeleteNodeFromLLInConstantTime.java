class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 


public class DeleteNodeFromLLInConstantTime {
    public void deleteNode(ListNode node) {
        // O(1) approach
        node.val = node.next.val;
        node.next = node.next.next;
    }
}