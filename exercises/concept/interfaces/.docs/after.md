[`interfaces`][interfaces] are the primary means of [decoupling][wiki-loose-coupling] the uses of a class from its implementation. This decoupling provides flexibility for maintenance of the implementation and helps support type safe generic behavior.

The syntax of an interface is similar to that of a class except that methods appear as the signature only and no body is provided.

```java
public interface Language {
    String speak();
}

public interface ItalianLanguage extends Language {
    String speak();
    String speakItalian();
}

public interface ScriptConverter {
    void setVersion(String version);
    String getVersion();
    String convertCyrillicToLatin(String cyrillic);
}
```

The implementing class must implement all operations defined by the interface.

Interfaces typically do one or more of the following:

- allow a number of different classes to be treated generically by the using code. In this case interfaces are playing the same role as a base class. An example of this is [java.io.InputStream][input-stream],
- expose a subset of functionality for some specific purpose (such as [`Comparable<T>`][comparable]) or
- expose the public API of a class so that multiple implementations can co-exist. One example is that of a [test double][wiki-test-double]

```java
public class ItalianTraveller implements ItalianLanguage {

    public String speak() {
        return "Ciao mondo";
    }

    public String speakItalian() {
        return speak();
    }
}

public class ItalianTravellerV2 implements ItalianLanguage {

    public String speak() {
        return "migliorata - Ciao mondo";
    }

    public String speakItalian() {
        return speak();
    }
}

public class FrenchTraveller implements Language {
    public String speak() {
        return "Ça va?";
    }
}

public class RussianTraveller implements Language, ScriptConverter {

    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String speak()
    {
        return "Привет мир";
    }

    public String convertCyrillicToLatin(String cyrillic) {
        throw new UnsupportedOperationException();
    }
}

public class DocumentTranslator implements ScriptConverter {

    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String translate(String russian) {
        throw new UnsupportedOperationException();
    }

    public String convertCyrillicToLatin(String cyrillic) {
        throw new UnsupportedOperationException();
    }
}
```

Code which uses the above interfaces and classes can:

- treat all speakers in the same way irrespective of language.
- allow some subsystem handling script conversion to operate without caring about what specific types it is dealing with.
- remain unaware of the changes to the italian speaker which is convenient if the class code and user code are maintained by different teams

Interfaces are widely used to support testing as they allow for easy [mocking][so-mocking-interfaces].

Interfaces can extend other interfaces with the `extend` keyword.

Members of an interface are public by default.

Interfaces can contain nested types: `interfaces`, `enums` and `classes`. Here, the containing interfaces act as [namespaces][wiki-namespaces]. Nested types are accessed outside the interface by prefixing the interface name and using dot syntax to identify the member.

By design, Java does not support multiple inheritance, but it facilitates a kind of multiple inheritance through interfaces.

Moreover, the concept of [polymorphism can be implemented through interfaces][interface-polymorphism] underpins the interface mechanism.

[interface-polymorphism]: https://www.cs.utexas.edu/~mitra/csSummer2013/cs312/lectures/interfaces.html
[so-mocking-interfaces]: https://stackoverflow.com/a/9226437/96167
[comparable]: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
[wiki-test-double]: https://en.wikipedia.org/wiki/Test_double
[wiki-polymorphism]: https://en.wikipedia.org/wiki/Polymorphism_(computer_science)
[wiki-namespaces]: https://en.wikipedia.org/wiki/Namespace
[wiki-loose-coupling]: https://en.wikipedia.org/wiki/Loose_coupling
[interfaces]: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
[input-stream]: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
