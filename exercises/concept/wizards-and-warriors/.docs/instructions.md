# Instructions

In this exercise you're playing a role-playing game named "Wizards and Warriors," which allows you to play as either a Wizard or a Warrior.

There are different rules for Warriors and Wizards to determine how much damage points they deal.

For a Warrior, these are the rules:

- Deal 6 points of damage if the fighter they are attacking is not vulnerable
- Deal 10 points of damage if the fighter they are attacking is vulnerable

For a Wizard, these are the rules:

- Deal 12 points of damage if the Wizard prepared a spell in advance
- Deal 3 points of damage if the Wizard did not prepare a spell in advance

In general, fighters are never vulnerable. However, Wizards _are_ vulnerable if they haven't prepared a spell.

You have nine tasks that work with Warriors and Wizard fighters.

## 1. Create the Warrior

Define the `Warrior` class and make it inherit the `Fighter` class

## 2. Describe a Warrior

Override the `toString()` method of the `Fighter` class for the `Warrior` to return a description of the fighter, formatted as `"Fighter is a <FIGHTER_TYPE>"`.

```java
Warrior warrior = new Warrior();
warrior.toString();
// => "Fighter is a Warrior"
```

## 3. Make Warriors invulnerable

Override the `isVulnerable()` method for the `Warrior` and make sure that returns always `false`.

```java
Warrior warrior = new Warrior();
warrior.isVulnerable();
// => false
```

## 4. Calculate the damage points for a Warrior

Override the `getDamagePoints()` method to return the damage points dealt by the warrior: 10 damage points when the target is vulnerable, 6 damage points when not.

```java
Warrior warrior = new Warrior();
Wizard wizard = new Wizard();

warrior.getgetDamagePoints(wizard);
// => 10
```

## 5. Create the Wizard

Define the `Wizard` class and make it inherit the `Fighter` class

## 6. Describe a Wizard

Override the `toString()` method of the `Fighter` class for the `Wizard` to return a description of the fighter, formatted as `"Fighter is a <FIGHTER_TYPE>"`.

```java
Wizard wizard = new Wizard();
wizard.toString();
// => "Fighter is a Wizard"
```

## 7. Allow Wizards to prepare a spell

Implement the `Wizard.prepareSpell()` method to allow a Wizard to prepare a spell in advance.

```java
Wizard wizard = new Wizard();
wizard.prepareSpell();
```

## 8. Make Wizards vulnerable when not having prepared a spell

Override the `isVulnerable()` method for the `Wizard` and make sure that returns `true` if the wizard did not prepare a spell; otherwise, return `false`.

```java
Fighter wizard = new Wizard();
wizard.isVulnerable();
// => true
```

## 9. Calculate the damage points for a Wizard

Override the `getgetDamagePoints()` method to return the damage points dealt by the wizard: 12 damage points when a spell has been prepared, 3 damage points when not.

```java
Wizard wizard = new Wizard();
Warrior warrior = new Warrior();

wizard.prepareSpell();
wizard.getgetDamagePoints(warrior);
// => 12
```
