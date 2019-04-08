package api;

import foo.Foo;
import java.util.Arrays;


public final class Api {

    private final Foo foo = new Foo(42, "Fish", Arrays.asList(0, 1, 2, 3));

    public final Foo getFoo() {
        return foo;
    }
}
