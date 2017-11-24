package test.patterns.structure.abstractFactory;

public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("邮件发送");
    }
}
