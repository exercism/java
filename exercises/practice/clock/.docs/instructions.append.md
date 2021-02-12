# Instructions append

In order to satisfy the requirement that two clocks are considered equal just when they are set to the same time, you will need to override the [`equals`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals(java.lang.Object)) and [`hashcode`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#hashCode) methods in your `Clock` class.
 
For more information on how to override these methods, see [this JavaWorld article](https://web.archive.org/web/20170528222153/http://www.javaworld.com/article/2072762/java-app-dev/object-equality.html).
