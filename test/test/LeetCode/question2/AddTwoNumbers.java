package test.LeetCode.question2;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

/**
 * Created by Administrator on 2017/11/1 0001.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *130
 */
public class AddTwoNumbers {

//    TODO: 判断长度，然后做加运算 之后返回结果
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        if (l1 == null || l2 == null){
            throw new IllegalArgumentException();
        }
        return listNode;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        addTwoNumbers(l1,l2);
    }
}
