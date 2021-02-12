# Hints

In Java it's considered best practice to use instance methods over class methods. However, there are conditions in which it is absolutely appropriate for a function to be `static`. Since classes in Java are closed for modification (i.e. you cannot add members to a class outside its definition like you can in other languages like Ruby or JavaScript), you cannot add new behavior to the class directly. What to do if you still want to define behavior for a given type? The idiomatic solution in this case is to write a utility method. 
Collections of these kinds of methods are often referred to as "utility classes". Examples of such classes from within the JRE include [Arrays](https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html) and [Collections](https://docs.oracle.com/javase/9/docs/api/java/util/Collections.html).
In this exercise we want a List to have `map()`, `reduce()`, `filter()`, etc. methods. It doesn't, so we're using static methods.

The `foldLeft` and `foldRight` methods are "fold" functions, which is a concept well-known in the functional programming world, but less so in the object-oriented one. See the Wikipedia page on folding for [general background](https://en.wikipedia.org/wiki/Fold_(higher-order_function)) and [signature/implementation hints](https://en.wikipedia.org/wiki/Fold_(higher-order_function)#Linear_folds).
