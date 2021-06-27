package learningLeetCode;


class ListNode {
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


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Head = null;
        ListNode resultPointer = null;
        var pointer2 = l2;
        var pointer1 = l1;
        int carry  = 0;
        while (pointer2!= null || pointer1 != null){
            int firstNumber = (pointer1!=null)? pointer1.val: 0;
            int secondNumber = (pointer2!=null)? pointer2.val:0;
            int sum = carry + firstNumber + secondNumber;
            carry = sum / 10;
            if (Head == null){
                Head = new ListNode(sum % 10);
                resultPointer = Head;
            }else {
                resultPointer.next = new ListNode(sum %10);
                resultPointer = resultPointer.next;
            }
            if (pointer1!=null){
                pointer1 = pointer1.next;
            }
            if(pointer2!=null){
                pointer2 = pointer2.next;
            }

        }
        if(carry > 0){
            resultPointer.next = new ListNode(carry);
        }
        return Head;
    }
}