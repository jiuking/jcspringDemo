package test.patterns.structure.abstractFactory;

public class SmsFactory implements Factory {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
