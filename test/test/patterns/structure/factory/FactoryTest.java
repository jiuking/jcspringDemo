package test.patterns.structure.factory;

import org.junit.Test;

public class FactoryTest {

    @Test
    public void test() {
        SendFactory.produceMailSender().send("");
    }
}
