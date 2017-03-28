/**
 * Created by sidmeister on 3/26/17.
 */
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class SumLinkRev
{
    SumLinkRev next;
    int data;

    public SumLinkRev() {
    }

    public SumLinkRev(int data) {
        this.data = data;
    }
}

class SumLinkListRev
{
    SumLinkRev head;

    public SumLinkListRev() {
        head = null;
    }

    public void insertLast(SumLinkRev node)
    {
        if(head == null)
            head = node;
        else
        {
            SumLinkRev temp = head;
            while(temp.next!=null)
                temp = temp.next;
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void displayList()
    {
        SumLinkRev temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.print("\n");
    }


}


public class AddTwoNumbersReverse
{
    SumLinkListRev list1;
    SumLinkListRev list2;

    public AddTwoNumbersReverse() {

        list1 = new SumLinkListRev();
        list2 = new SumLinkListRev();
    }

    public void addTwoList(SumLinkRev l1, SumLinkRev l2)
    {
        SumLinkListRev result = new SumLinkListRev();
        SumLinkRev current = l1;
        int list1Length = 0;
        int list2Length = 0;
        while(current!=null)
        {
            current = current.next;
            list1Length++;
        }
        current = l2;
        while(current!=null)
        {
            current = current.next;
            list2Length++;
        }
        if(list1Length < list2Length)
        {
            current = l1;
            l1 = l2;
            l2 = current;
        }
        current = l1;
        int carry = 0;
        int sum;
        while(l2 !=null)
        {
            SumLinkRev temp = new SumLinkRev();
            sum = l1.data + l2.data + carry;
            carry = sum/10;
            sum = sum%10;
            temp.data = sum;
            result.insertLast(temp);
            l2 = l2.next;
            l1 = l1.next;
        }
        while(l1 !=null)
        {
            SumLinkRev temp = new SumLinkRev();
            sum = l1.data + carry;
            carry = sum/10;
            sum = sum%10;
            temp.data = sum;
            result.insertLast(temp);
            l1 = l1.next;
        }
        if(carry > 0) {
            SumLinkRev temp = new SumLinkRev();
            sum = carry;
            temp.data = sum;
            result.insertLast(temp);
        }
        result.displayList();
    }


    public static void main(String[] args)
    {
        AddTwoNumbersReverse SumLinkListRev = new AddTwoNumbersReverse();
        SumLinkListRev.list1.insertLast(new SumLinkRev(1));
        SumLinkListRev.list1.insertLast(new SumLinkRev(8));
        SumLinkListRev.list2.insertLast(new SumLinkRev(0));
        SumLinkListRev.addTwoList(SumLinkListRev.list1.head,SumLinkListRev.list2.head);

    }
}



/*
Editorial solution  : leetcode


public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

 */