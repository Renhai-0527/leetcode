import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AddTwoNum {


    public static void main(String[] args) {
        //ListNode l1 = new ListNode(1,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        //ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))));
        ListNode l2 = new ListNode(1,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));

//      ListNode l1=new ListNode(0);
        ListNode l1=new ListNode(9);
        ListNode l3;
        l3 = new Solution().addTwoNumbers(l1,l2);

        while (l3!=null){
            System.out.print(l3.val+"->");
            l3 = l3.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}

//哈哈哈我真的是服了

//这个题出的挺好，让我不能直接用加法做，而是只能采用链表的每项相加来做，题目不错，测试数据不错
