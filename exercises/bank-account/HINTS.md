This exercise introduces [concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html). 
To pass the last test you might find the 
[`synchronized` keyword or locks](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html) useful.

Problems arising from running code concurrently are often intermittent because they depend on the order the code is
executed. Therefore the last test runs many [threads](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) 
several times to increase the chances of catching a bug.