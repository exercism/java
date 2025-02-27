# About Maps

A **Map** is a data structure for storing key value pairs.
It is similar to dictionaries in other programming languages.
The [Map][map-javadoc] interface defines the operations you can make with a map.

## HashMap

Java has a number of different Map implementations.
[HashMap][hashmap-javadoc] is a commonly used one.

```java
// Make an instance
Map<String, Integer> fruitPrices = new HashMap<>();
```

~~~~exercism/note
When defining a `Map` variable, it is recommended to define the variable as a `Map` type rather than the specific type, as in the above example.
This practice makes it easy to change the `Map` implementation later.
~~~~

`HashMap` also has a copy constructor.

```java
// Make a copy of a map
Map<String, Integer> copy = new HashMap<>(fruitPrices);
```

Add entries to the map using [put][map-put-javadoc].

```java
fruitPrices.put("apple", 100);
fruitPrices.put("pear", 80);
// => { "apple" => 100, "pear" => 80 }
```

Only one value can be associated with each key.
Calling `put` with the same key will update the key's value.

```java
fruitPrices.put("pear", 40);
// => { "apple" => 100, "pear" => 40 }
```

Use [get][map-get-javadoc] to get the value for a key.

```java
fruitPrices.get("apple"); // => 100
```

Use [containsKey][map-containskey-javadoc] to see if the map contains a particular key.

```java
fruitPrices.containsKey("apple");   // => true
fruitPrices.containsKey("orange");  // => false
```

Remove entries with [remove][map-remove-javadoc].

```java
fruitPrices.put("plum", 90);  // Add plum to map
fruitPrices.remove("plum");   // Removes plum from map
```

The [size][map-size-javadoc] method returns the number of entries.

```java
fruitPrices.size();  // Returns 2
```

You can use the [keySet][map-keyset-javadoc] or [values][map-values-javadoc] methods to obtain the keys or the values in a Map as a Set or collection respectively.

```java
fruitPrices.keySet();  // Returns "apple" and "pear" in a set
fruitPrices.values();  // Returns 100 and 80, in a Collection
```

## HashMap uses `hashCode` and `equals`

HashMaps uses the object's [hashCode][object-hashcode-javadoc] and [equals][object-equals-javadoc] method to work out where to store and how to retrieve the values for a key.
For this reason, it is important that their return values do not change between storing and getting them, otherwise the HashMap may not be able to find the value.

For example, lets say we have the following class that will be used as the key to a map:

```java
public class Stock {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (Objects.equals(Stock.class, obj.getClass()) && obj instanceof Stock other) {
            return Objects.equals(name, other.name);
        }
        return false;
    }
}
```

The `hashCode` and `equals` depend on the  `name` field, which can be changed via `setName`.
Altering the `hashCode` can produce surprising results:

```java
Stock stock = new Stock();
stock.setName("Beanies");

Map<Stock, Integer> stockCount = new HashMap<>();
stockCount.put(stock, 80);

stockCount.get(stock); // Returns 80

Stock other = new Stock();
other.setName("Beanies");

stockCount.get(other); // Returns 80 because "other" and "stock" are equal

stock.setName("Choccies");
stockCount.get(stock); // Returns null because hashCode value has changed

stockCount.get(other);  // Also returns null because "other" and "stock" are not equal

stock.setName("Beanies");
stockCount.get(stock); // HashCode restored, so returns 80 again

stockCount.get(other); // Also returns 80 again because "other" and "stock" are back to equal
```

## Map.of and Map.copyOf

Another common way to create maps is to use [Map.of][map-of-javadoc] or [Map.ofEntries][map-ofentries-javadoc].

```java
// Using Map.of
Map<String, Integer> temperatures = Map.of("Mon", 30, "Tue", 28, "Wed", 32);

// or using Map.ofEntries
Map<String, Integer> temperatures2 = Map.ofEntries(Map.entry("Mon", 30, "Tue", 28, "Wed", 32));
```

Unlike `HashMap`, they populate the map upfront and become read-only once created.
[Map.copyOf][map-copyof-javadoc] makes a read-only copy of a map.

```java
Map<String, Integer> readOnlyFruitPrices = Map.copyOf(fruitPrices);
```

Calling methods like `put`, `remove` or `clear` results in an `UnsupportedOperationException`.

[map-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html
[hashmap-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
[map-put-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#put(K,V)
[map-get-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#get(java.lang.Object)
[map-containskey-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#containsKey(java.lang.Object)
[map-remove-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#remove(java.lang.Object)
[map-size-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#size()
[map-of-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#of()
[map-ofentries-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#ofEntries(java.util.Map.Entry...)
[map-copyof-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#copyOf(java.util.Map)
[object-hashcode-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#hashCode()
[object-equals-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)
[map-keyset-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#keySet()
[map-values-javadoc]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#values()
