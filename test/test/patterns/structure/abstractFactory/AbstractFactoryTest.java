package test.patterns.structure.abstractFactory;

import org.junit.Test;

public class AbstractFactoryTest {
    @Test
    public void test() {
        Factory factory = new MailFactory();
        factory.produce().sender();
    }
}
