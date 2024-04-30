# Instructions

In this exercise you're playing a role-playing game where different types of fighters can combat each other.
The game has different rules for each type of fighter.
We are going to focus on two specific types: Wizards and Warriors.

For a Warrior, these are the rules:

- A Warrior is never vulnerable.
- A Warrior deals `6` points of damage if the fighter they are attacking is not vulnerable.
- A Warrior deals `10` points of damage if the fighter they are attacking is vulnerable.

For a Wizard, these are the rules:

- A Wizard can prepare a spell in advance.
- A Wizard is vulnerable unless they have prepared a spell in advance.
- A Wizard deals `12` points of damage if they prepared a spell in advance.
- A Wizard deals `3` points of damage if they did not prepare a spell in advance.

## 1. Create the Warrior class

Create a new class called `Warrior`.
This class should inherit from the existing `Fighter` class.

## 2. Describe a Warrior

Update the `Warrior` class so that its `toString()` method describes what kind of fighter they are.
The method should return the string `"Fighter is a Warrior"`.

```java
Warrior warrior = new Warrior();
warrior.toString();
// => "Fighter is a Warrior"
```

## 3. Make Warriors invulnerable

Update the `Warrior` class so that its `isVulnerable()` method always returns `false`.

```java
Warrior warrior = new Warrior();
warrior.isVulnerable();
// => false
```

## 4. Calculate the damage points for a Warrior

Update the `Warrior` class so that its `getDamagePoints(Fighter)` method calculates the damage dealt by a Warrior according to the rules above.

```java
Warrior warrior = new Warrior();
Wizard wizard = new Wizard();

warrior.getDamagePoints(wizard);
// => 10
```

## 5. Create the Wizard class

Create another new class called `Wizard`.
This class should also inherit from the existing `Fighter` class.

## 6. Describe a Wizard

Update the `Wizard` class so that its `toString()` method describes what kind of fighter they are.
The method should return the string `"Fighter is a Wizard"`.

```java
Wizard wizard = new Wizard();
wizard.toString();
// => "Fighter is a Wizard"
```

## 7. Allow Wizards to prepare a spell and make them vulnerable when not having prepared a spell

Update the `Wizard` class to add a method called `prepareSpell()`.
The class should remember when this method is called, and make sure that its `isVulnerable()` method returns `false` only when a spell is prepared.

```java
Wizard wizard = new Wizard();
wizard.prepareSpell();
wizard.isVulnerable();
// => false
```

## 8. Calculate the damage points for a Wizard

Update the `Wizard` class so that its `getDamagePoints(Fighter)` method calculates the damage dealt by a Wizard according to the rules above.

```java
Wizard wizard = new Wizard();
Warrior warrior = new Warrior();

wizard.prepareSpell();
wizard.getDamagePoints(warrior);
// => 12
```
