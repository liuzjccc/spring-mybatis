package test;

public class NormalTest {
    public static void main(String[] args) {
        A a = new A();
        Class<?>[] clzz = a.getClass().getInterfaces();
    }
}

class A extends B implements C{
    class D{

    }
}

class B{

}

interface C{}
