package test.patterns.structure.singleton;

public class NestSingleton {
    private NestSingleton() {

    }

    private static class SingletonHolder{
        private static final NestSingleton INSTANCE = new NestSingleton();
    }

    public static NestSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
