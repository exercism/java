# Introduction

An interface is a type containing members defining a group of related functionality. It distances the uses of a class from the implementation allowing multiple different implementations or support for some generic behavior such as formatting, comparison or conversion.

The syntax of an interface is similar to that of a class except that methods appear as the signature only and no body is provided.

```java
public interface Language {
    String getLanguageName();
    String speak();
}

public class ItalianTraveller implements Language, Cloneable {

    // from Language interface
    public String getLanguageName() {
        return "Italiano";
    }

    // from Language interface
    public String speak() {
        return "Ciao mondo";
    }

    // from Cloneable interface
    public Object clone() {
        ItalianTaveller it = new ItalianTaveller();
        return it;
    }
}
```

All operations defined by the interface must be implemented by the implementing class.

Interfaces usually contain instance methods.

An example of an interface found in the Java Class Library, apart from `Cloneable` illustrated above, is `Comparable<T>`. The `Comparable<T>` interface can be implemented where a default generic sort order in collections is required.
