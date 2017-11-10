package test.LeetCode.question2;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

import java.util.ArrayList;

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
        int listNode1Length = 1;
        int listNode2Length = 1;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ListNode listNode = new ListNode();
        if (l1 == null || l2 == null){
            throw new IllegalArgumentException();
        }
        list1.add(l1.val);
        list2.add(l2.val);
        while (true){
            if(l1.next != null){
                list1.add(l1.val);
                l1 = l1.next;
                listNode1Length++;
            }else
                break;

        }
        while (true) {
            if (l2.next != null) {
                list2.add(l2.val);
                l2 = l2.next;
                listNode2Length++;
            }else
                break;
        }
        int listMin = 0;
        if(listNode1Length < listNode2Length){
            listMin = listNode1Length;
        }else {
            listMin = listNode2Length;
        }
        int temp = 0;
        for (int i = 0; i < listMin; i++) {
            ListNode listNodeTemp = new ListNode();
            int a = list1.get(i);
            int b = list2.get(i);
            int sum = a + b + temp;
            int c = sum % 10;
            int d = sum / 10;
            if (d == 1){
                //进1
                temp = 1;
            }else
                temp = 0;
            listNode.val = c;
            listNode.next = listNodeTemp;
            listNodeTemp.val = sum;
        }
        return listNode;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(11%10);
        System.out.println(10/10);
    }
}
