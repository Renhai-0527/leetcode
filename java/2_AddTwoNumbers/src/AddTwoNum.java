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

/*class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        while (l1!=null){
            list1.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list2.add(l2.val);
            l2=l2.next;
        }
        Long num1=0L,num2=0L;

        for(int i=0;i<list1.size();i++){
            num1 += list1.get(i) * getNum(i);
        }
        for(int i=0;i<list2.size();i++){
            num2 += list2.get(i) * getNum(i);
        }

        ListNode header = new ListNode();
        ListNode l3 = new ListNode();
        int c=0;
        Long num3;
        num3=num1+num2;
        System.out.println(num3);
        if (num3<10){
            return new ListNode(num3.intValue());
        }

        while (num3>=10){

            Long d =num3%10;

            l3.val = d.intValue();
            l3.next = new ListNode();
            if (c==0){
                header = l3;
                c=1;
            }
            l3=l3.next;
            num3 = num3 / 10;
        }

        l3.val = num3.intValue() % 10;
        l3.next = null;

        return header;
    }

    public static Long getNum(int num){
        Long sum = 1L;
        for (int i=0;i<num;i++){
            sum = sum * 10;
        }
        return sum;
    }
}*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
