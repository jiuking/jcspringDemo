package test.patterns.structure.factory;

public class SendFactory {

    public static Sender produceSmsSender() {
        return new SmsSender();
    }

    public static Sender produceMailSender() {
        return new MailSender();
    }

}
