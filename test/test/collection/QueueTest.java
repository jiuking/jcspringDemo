package test.collection;

import org.junit.Test;
import test.bean.AuditUser;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueTest {

    @Test
    public void testConCurrentLinkedQueue() {
        ConcurrentLinkedQueue<AuditUser> current = new ConcurrentLinkedQueue<>();
        for (int i = 1; i <= 500; i++) {
            AuditUser auditUser = new AuditUser();
            auditUser.setName("張"+i);
            auditUser.setPassword(i+"");
            current.offer(auditUser);
        }
        for (AuditUser temp : current) {
            System.out.println(temp.getName());
        }
        System.out.println(current.size());
        AuditUser audt = current.poll();
        AuditUser audit501 = new AuditUser();

        System.out.println(audt.getName());
        System.out.println(current.size());
        audit501.setPassword("1");
        audit501.setName("張1");

        AuditUser audu = new AuditUser();
        audu.setName("asd");
        current.offer(audit501);
        current.offer(audu);
        for (AuditUser user : current) {
            System.out.println(user.getName());
        }
        current.remove(audit501);
        for (AuditUser user : current) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testEquals() {
        AuditUser auditUser = new AuditUser();
        auditUser.setId("asdf");
        auditUser.setName("张三");
        auditUser.setPassword("124");
        System.out.println(auditUser.hashCode());
        AuditUser auditUser1 = new AuditUser();
        auditUser1.setId("zxcv");
        auditUser1.setName("李四");
        auditUser1.setPassword("567");
        System.out.println(auditUser1.hashCode());
        System.out.println(auditUser.equals(auditUser1));
        ConcurrentLinkedQueue<AuditUser> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer(auditUser);
        concurrentLinkedQueue.offer(auditUser1);
        AuditUser auditUser2 = new AuditUser();
        auditUser2.setId("qwer");
        auditUser2.setName("王二");
        System.out.println(auditUser2.hashCode());
        concurrentLinkedQueue.offer(auditUser2);
        for (AuditUser au : concurrentLinkedQueue) {
            System.out.println(au.getName());
        }
        System.out.println("------------分割线---------------");
        AuditUser del = new AuditUser();
        del.setId("zxcv");
        concurrentLinkedQueue.remove(del);
        System.out.println(del.hashCode());
        for (AuditUser au : concurrentLinkedQueue) {
            System.out.println(au.getName());
        }
    }

    @Test
    public void testThread() {
        ObjectQueueUtil<AuditUser> util = ObjectQueueUtil.getInstance();
        List<AuditUser> list = new LinkedList<>();
        AuditUser user = new AuditUser();
        user.setId("asdf");
        user.setName("张三");
        list.add(user);
        AuditUser user1 = new AuditUser();
        user1.setId("123");
        user1.setName("张四");
        list.add(user1);
        AuditUser user2 = new AuditUser();
        user2.setId("456");
        user2.setName("张五");
        list.add(user2);
        util.addAll(list);
//        util.offer(user2);
        AuditUser user3 = new AuditUser();
        user3.setId("456");
        user3.setName("张六");
        util.offer(user3);
        System.out.println(util.size());
        util.remove(user3);
        System.out.println("123".hashCode());
        System.out.println(util.size());
        StringBuilder sb = new StringBuilder();
        while (util.size() > 0) {
            System.out.println(util.poll().getName());
        }
        AuditUser user4 = new AuditUser();
        user4.setName("张张");
        user4.setId("123");
        util.offer(user4);
        System.out.println(util.peek().getName());
        System.out.println(util.size());
    }
}
