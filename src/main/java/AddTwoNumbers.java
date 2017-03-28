/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class SumLink
{
    SumLink next;
    int data;

    public SumLink() {
    }

    public SumLink(int data) {
        this.data = data;
    }
}

class SumLinkList
{
    SumLink head;

    public SumLinkList() {
        head = null;
    }

    public void insertFirst(SumLink node)
    {
        if(head == null)
            head = node;
        else
        {
            node.next = head;
            head = node;
        }
    }

    public void insertLast(SumLink node)
    {
        if(head == null)
            head = node;
        else
        {
            SumLink temp = head;
            while(temp.next!=null)
                temp = temp.next;
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void reverseList()
    {
        SumLink first = head;       // start at beginning of list
        SumLink previous = head;
        SumLink current = head.next;
        head.next = null;
        while(current != null)      // until end of list,
        {
            SumLink temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;

    }

    public void displayList()
    {
        SumLink temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.print("\n");
    }


}


public class AddTwoNumbers
{
    SumLinkList list1;
    SumLinkList list2;

    public AddTwoNumbers() {

        list1 = new SumLinkList();
        list2 = new SumLinkList();
    }

    public void addTwoList(SumLink l1, SumLink l2)
    {
        SumLinkList result = new SumLinkList();
        SumLink current = l1;
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
        int diff = Math.abs(list1Length - list2Length);
        while(diff > 0)
        {
            current = current.next;
            diff --;
        }
        int carry = addList(current,l2,result,0);
        diff = Math.abs(list1Length - list2Length);
        if(diff > 0)
            carry = addRemainderList(l1,result,carry,diff);
        if (carry > 0) {
            SumLink temp = new SumLink();
            temp.data = carry;
            result.insertLast(temp);
        }

        result.displayList();

    }

    public int addList(SumLink current,SumLink l2,SumLinkList result,int carry)
    {
        if(current == null)
            return 0;
        carry = addList(current.next,l2.next,result,carry);
        int sum;
        SumLink temp = new SumLink();
        sum = current.data + l2.data + carry;
        carry = sum/10;
        sum = sum%10;
        temp.data = sum;
        result.insertLast(temp);
        return carry;

    }

    public int addRemainderList(SumLink current,SumLinkList result,int carry,int diff)
    {
        if(current == null || diff == 0)
            return 0;
        carry = addRemainderList(current.next,result,carry,diff -1);
        int sum;
        SumLink temp = new SumLink();
        sum = current.data + carry;
        carry = sum/10;
        sum = sum%10;
        temp.data = sum;
        result.insertLast(temp);
        return carry;

    }

    public static void main(String[] args)
    {
        AddTwoNumbers sumLinkList = new AddTwoNumbers();
        sumLinkList.list1.insertLast(new SumLink(1));
        sumLinkList.list1.insertLast(new SumLink(8));
        sumLinkList.list2.insertLast(new SumLink(3));
        sumLinkList.list2.displayList();
        sumLinkList.addTwoList(sumLinkList.list1.head,sumLinkList.list2.head);

    }
}