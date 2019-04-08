package foo;

import java.util.Collections;
import java.util.List;

public final class Foo {

    public final int intValue;
    public final String strValue;
    public final List<Integer> listValue; 

    public Foo(final int intValue, final String strValue, final List<Integer> listValue) {
        this.intValue = intValue;
        this.strValue = strValue;
        this.listValue = Collections.unmodifiableList(listValue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("INT: ").append(intValue).append("\n")
          .append("STRING: ").append(strValue).append("\n")
          .append("LIST: ").append(listValue.toString());
        return sb.toString();
    }
}

