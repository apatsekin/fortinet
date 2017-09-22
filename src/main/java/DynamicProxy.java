import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Example of Dynamic Proxy pattern which proxifies method invocations
 */
public class DynamicProxy {
    interface MyInterface {
        void MyMethod(String s);
    }

    /**
     * Implementation of InvocationHandler for dynamic proxy
     */
    static class MyInvocationHandler implements InvocationHandler {
        private final MyInterface original;

        public MyInvocationHandler(MyInterface original) {
            this.original = original;
        }

        //implementing method from InvocationHandler interface to catch method invocations
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println("Prepend:");
            method.invoke(original, args);
            System.out.println(":Append");
            return null;
        }
    }

    /**
     * Method to create dynamic proxy
     *
     * @param original
     * @return proxified object
     */
    private static MyInterface createDProxy(MyInterface original) {
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyInvocationHandler(original));
        return proxy;
    }

    static class MyClass implements MyInterface {
        public void MyMethod(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        MyInterface proxified = (MyInterface) createDProxy(myObject);
        proxified.MyMethod("Test");

    }
}