The default implementation for this exercise uses an [exception](https://docs.oracle.com/javase/tutorial/essential/exceptions/) 
which will cause the test to fail with the provided error message.
This particular exception type, [UnsupportedOperationException](http://docs.oracle.com/javase/8/docs/api/?java/lang/UnsupportedOperationException.html), 
is commonly thrown to alert developers that a method has not yet been implemented.
Throwing exceptions in this manner means the tests will compile but not pass right away.

To make the test pass you need to remove the line which throws the exception and replace it with your implementation of the method.