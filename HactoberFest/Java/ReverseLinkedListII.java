/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;
        ListNode l1=head,l2=head,r1=head,r2=head;
        int l=left;
        while(left-->1)
        {
            l1=l2;
            l2=l2.next;
        }
        while(right-->0)
        {
            r2=r1;
            r1=r1.next;
        }
        if(l!=1) l1.next=null;
        r2.next=null;

        ListNode prev=null,succ=null,curr=l2;
        while(curr!=null)
        {
            succ=curr.next;
            curr.next=prev;
            prev=curr;
            curr=succ;
        }

        if(l==1)
        {
            head.next=r1;
            return prev;
        } 

        l1.next=prev;
        l2.next=r1;
        return head;
    }
}
