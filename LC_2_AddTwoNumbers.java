import java.util.ArrayList;
import java.util.List;

public class LC_2_AddTwoNumbers {

    /*
        https://leetcode.com/problems/add-two-numbers/description/

        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
        and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println("l1:");
        printListNde(l1);
        System.out.println("l2:");
        printListNde(l2);
        System.out.println("Result:");
        printListNde(addTwoNumbers(l1, l2));
    }

    public static void printListNde(ListNode v) {
        List<String> toPrint = new ArrayList<>();
        while (v != null) {
            toPrint.add(String.valueOf(v.val));
            v = v.next;
        }
        String p = String.join("->", toPrint);
        System.out.println(p);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rNode = new ListNode();
        ListNode p = rNode;
        int carry = 0;
        while (true) {
            int sumVal = l1.val + l2.val + carry;
            p.val = sumVal % 10;
            carry = sumVal / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null || l2 == null)
                break;
            p.next = new ListNode();
            p = p.next;
        }
        if (l1 == null)
            l1 = l2;
        while (l1 != null) {
            p.next = new ListNode();
            p = p.next;
            int sumVal = l1.val + carry;
            p.val = sumVal % 10;
            carry = sumVal / 10;
            l1 = l1.next;
        }
        if (carry > 0)
            p.next = new ListNode(carry);
        return rNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
