package test.patterns.structure.factory;

public class SmsSender implements Sender {
    @Override
    public void send(String msg) {
        //短信发送
        System.out.println("发送短信");
    }
}
