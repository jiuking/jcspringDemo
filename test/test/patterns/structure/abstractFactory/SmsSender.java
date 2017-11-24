package test.patterns.structure.abstractFactory;

public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("邮件发送");
    }
}
