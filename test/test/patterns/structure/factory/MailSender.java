package test.patterns.structure.factory;

public class MailSender implements Sender {
    @Override
    public void send(String msg) {
        //发送邮件
        System.out.println("发送邮件");
    }
}
