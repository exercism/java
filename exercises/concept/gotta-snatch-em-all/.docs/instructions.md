# Instructions

Your nostalgia for Blorkemon™️ cards is showing no sign of slowing down, you even started collecting them again, and you
are getting your friends to join you.

In this exercise, you will use the `Set` interface to help you manage your collection, since duplicate cards are not
important when your goal is to get all existing cards.

## 1. Start a collection

You just found your old stash of Blorkemon™️ cards!
The stash contains a bunch of duplicate cards, so it's time to start a new collection by removing the duplicates.

You really want your friends to join your Blorkemon™️ madness, and the best way is to kickstart their collection by
giving them one card.

Implement the `newCollection` method, which transforms a list of cards into a `Set` representing your new collection.

```java
GottaSnatchEmAll.newCollection(List.of("Newthree", "Newthree", "Newthree"));
// => {"Newthree"}
```

## 2. Grow the collection

Once you have a collection, it takes a life of its own and must grow.

Implement the `addCard` method, which takes a new card and your current set of collected cards.
The method should add the new card to the collection if it isn't already present, and should return a `boolean`
indicating whether the collection was updated.

```java
Set<String> collection = GottaSnatchEmAll.newCollection("Newthree");
GottaSnatchEmAll.addCard("Scientuna",collection);
// => true

collection.contains("Scientuna");
// => true
```

## 3. Start trading

You really want your friends to join your Blorkemon™️ madness, so it's time to start trading!

When trading with friends not every trade is worth doing, or can be done at all.
You should only trade if both you and your friend have a card the other does not have.

Implement the `canTrade` method, that takes your current collection and the collection of one of your friends.
It should return a `boolean` indicating whether a trade is possible, following the rules above.

```java
Set<String> myCollection = Set.of("Newthree");
Set<String> theirCollection = Set.of("Scientuna");
GottaSnatchEmAll.canTrade(myCollection, theirCollection);
// => true
```

## 4. Identify common cards

You and your Blorkemon™️ enthusiast friends gather and wonder which cards are the most common.

Implement the `commonCards` method, which takes a list of collections and returns a collection of cards that all collections
have.

```java
GottaSnatchEmAll.commonCards(List.of(Set.of("Scientuna"), Set.of("Newthree","Scientuna")));
// => {"Scientuna"}
```

## 5. All of the cards

Do you and your friends collectively own all of the Blorkemon™️ cards?

Implement the `allCards` method, which takes a list of collections and returns a collection of all different cards in
all the collections combined.

```java
GottaSnatchEmAll.allCards(List.of(Set.of("Scientuna"), Set.of("Newthree","Scientuna")));
// => {"Newthree", "Scientuna"}
```
