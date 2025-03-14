# Hints

## General

- The [`Map` API documentation][map-docs] contains a list of methods available on the `Map` interface.

## 1. Return the codes in a map

- You will need to define a `Map` in [such a way][declaring-members] that you can use it in the class methods.

## 2. Add entries to the dictionary

- Maps have a [method][map-put-docs] to add and update the value for a key.

## 3. Lookup a dialing code's country

- Maps have a [method][map-get-docs] to get the key's value.

## 4. Don't allow duplicates

- There is a way to check if the map has a [key][map-contains-key-docs] or a [value][map-contains-value-docs].

## 5. Find a country's dialing code

- There is a [way][map-values-docs] to get an iterable collection of values in a map.

## 6. Update the country's dialing code

- Do not forget about the country's previous dialing code will be in the map.
- There is a [method][map-remove-docs] to remove an entry from the map.

[declaring-members]: https://dev.java/learn/classes-objects/creating-classes/#declaring-members
[map-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html
[map-put-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#put(K,V)
[map-get-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#get(java.lang.Object)
[map-contains-key-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#containsKey(java.lang.Object)
[map-contains-value-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#containsValue(java.lang.Object)
[map-values-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#values()
[map-remove-docs]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html#remove(java.lang.Object)
