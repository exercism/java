# Instructions

In this exercise you'll be writing code to manage a dictionary of international dialing codes using a `Map`.

The dictionary allows looking up the name of a country (the map's value, as a `String`) by the international dialing code (the map's key, as an `Integer`),

## 1. Return the codes in a map

Implement the method `getCodes` that takes no parameters and returns a map of the dialing codes to country currently in the dictionary.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.getCodes();
// => empty map 
```

## 2. Add entries to the dictionary

The dictionary needs to be populated.
Implement the `setDialingCode` method that takes a dialing code and the corresponding country and adds the dialing code and country.
If the dialing code is already in the map, update the map with the provided code and country.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.setDialingCode(679, "Unknown");
// => { 679 => "Unknown" }

dialingCodes.setDialingCode(679, "Fiji");
// => { 679 => "Fiji" }
```

## 3. Lookup a dialing code's country

Implement the `getCountry` method that takes a map of dialing codes and a dialing code and returns the country name with the dialing code.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.setDialingCode(55, "Brazil");
dialingCodes.getCountry(55);
// => "Brazil"
```

## 4. Don't allow duplicates

When adding a dialing code, care needs to be taken to prevent a code or country to be added twice.
In situations where this happens, it can be assumed that the first entry is the right entry.
Implement the `addNewDialingCode` method that adds an entry for the given dialing code and country.
However, unlike `setDialingCode`, it does nothing if the dialing code or the country is already in the map.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addNewDialingCode(32, "Belgium");
dialingCodes.addNewDialingCode(379, "Vatican City");
// => { 39 => "Italy", 379 => "Vatican City" }


dialingCodes.addNewDialingCode(32, "Other");
dialingCodes.addNewDialingCode(39, "Vatican City");
// => { 32 => "Belgium", 379 => "Vatican City" }
```

## 5. Find a country's dialing code

Its rare, but mistakes can be made.
To correct the mistake, we will need to know what dialing code the country is currently mapped to.
To find which dialing code needs to be corrected, implement the `findDialingCode` method that takes in a map of dialing codes and a country and returns the country's dialing code.
Return `null` if the country is _not_ in the map.

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addDialingCode(44, "UK");
dialingCodes.findDialingCode("UK");
// => 44

dialingCodes.findDialingCode("Unlisted");
// => null
```

## 6. Update the country's dialing code

Now that we know which dialing code needs to be corrected, we proceed to update the code.
Implement the `updateCountryDialingCode` method that takes the country's new dialing code and the country's name and updates accordingly.
Do nothing if the country is _not_ in the map (as this method is meant to only help correct mistakes).

```java
DialingCodes dialingCodes = new DialingCodes();
dialingCodes.addDialingCode(88, "Japan");
// => { 88 => "Japan" }

dialingCodes.updateCountryDialingCode(81, "Japan");
// => { 81 => "Japan" }

dialingCodes.updateCountryDialingCode(32, "Mars");
// => { 81 => "Japan"}
```
