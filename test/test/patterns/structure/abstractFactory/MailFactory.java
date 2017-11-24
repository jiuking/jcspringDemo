package test.patterns.structure.abstractFactory;

public class MailFactory implements Factory {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
