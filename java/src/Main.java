import api.Api;
import foo.Foo;

import java.lang.reflect.Field;
// import java.util.Arrays;


public final class Main {

    private static void goodConsumer(final Foo foo) {
        // do nothing wrong with foo
    }

    private static void stupidConsumer(final Foo foo) {
        foo.listValue.add(100);
    }

    private static void evilConsumer(final Foo foo) throws Exception {
        final Field intField = Foo.class.getDeclaredField("intValue");
        intField.setAccessible(true);
        intField.set(foo, 7);

        final Field strField = Foo.class.getDeclaredField("strValue");
        strField.setAccessible(true);
        strField.set(foo, "James Bond");
    }

    private static void evilSubConsumer(final String value) throws Exception {
        final Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        // for JDK 11, for JDK 8 there should be toCharArray()
        field.set(value, "Loki".getBytes());
    }

    private static void goodSubConsumer(final String value) throws Exception {
        evilSubConsumer(value);
    }

    private static void evilCautiousConsumer(final Foo foo) throws Exception {
        final String strValue = foo.strValue;
        goodSubConsumer(strValue);
    }

    public static void main(String[] args) throws Exception {
        {
            final Api api = new Api();
            goodConsumer(api.getFoo());
            System.out.println("*** After good consumer ***");
            System.out.println(api.getFoo());
            System.out.println();
        }

        // this will cause an exception
        // {
        //     final Api api = new Api();
        //     stupidConsumer(api.getFoo());
        //     System.out.println("*** After stupid consumer ***");
        //     System.out.println(api.getFoo());
        //     System.out.println();
        // }

        {
            final Api api = new Api();
            evilConsumer(api.getFoo());
            System.out.println("*** After evil consumer ***");
            System.out.println(api.getFoo());
            System.out.println();
        }

        {
            final Api api = new Api();
            evilCautiousConsumer(api.getFoo());
            System.out.println("*** After evil but cautious consumer ***");
            System.out.println(api.getFoo());
            System.out.println();
        }
    }
}

