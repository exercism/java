# Hints

## General

Detailed explanation of inheritance can be found at [Inheritance][inheritance-concept].
The whole inheritance concept has a lot to do with the concepts around [overriding][java-overriding].

## 1. Create the Warrior class

- Review the [concept:java/classes](https://github.com/exercism/java/tree/main/concepts/classes) concept.
- Review the [inheritance][inheritance-concept] concept.

## 2. Describe a Warrior

- In Java, the `toString()` method is actually present inside the `Object` class (which is a superclass to all the classes in Java).
  You can read more about it [here][object-class-java].
- To override this method inside your implementation class, you should have a method with same name i.e. `toString()` and same return type i.e. `String`.
- The `toString()` method must be `public`.

## 3. Make Warriors invulnerable

- Override the `isVulnerable()` method in the `Warrior` class to make Warriors always invulnerable.

## 4. Calculate the damage points for a Warrior

- Override the `getDamagePoints(Fighter)` method in the `Warrior` class.
- Use a [conditional statement][if-else] to return the damage points, taking into account the vulnerability of the target.

## 5. Create the Wizard class

- Review the [concept:java/classes](https://github.com/exercism/java/tree/main/concepts/classes) concept.
- Review the [inheritance][inheritance-concept] concept.

## 6. Describe a Wizard

- In Java, the `toString()` method is actually present inside the `Object` class (which is a superclass to all the classes in Java).
  You can read more about it [here][object-class-java].
- To override this method inside your implementation class, you should have a method with same name i.e. `toString()` and same return type i.e. `String`.
- The `toString()` method must be `public`.

## 7. Allow Wizards to prepare a spell and make them vulnerable when not having prepared a spell

- Preparing a spell can only be done by a wizard. So, it makes sense to have this property defined inside the `Wizard` class.
- Create `prepareSpell()` method inside `Wizard` class.
- Remember: Parent class (here `Fighter`) has no access to the properties of the child class (for example, `Wizard`)
- Remember: As the method does not have a return type you should use `void` instead.
- Override the `isVulnerable()` method in the `Wizard` class to make Wizards vulnerable if they haven't prepared a spell.

## 8. Calculate the damage points for a Wizard

- Override the `getDamagePoints(Fighter)` method in the `Wizard` class.
- Use a [conditional statement][if-else] to return the damage points, taking into account the value of the prepare spell field.

[inheritance-concept]: https://www.geeksforgeeks.org/inheritance-in-java/
[object-class-java]: https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
[java-overriding]: https://docs.oracle.com/javase/tutorial/java/IandI/override.html
[if-else]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
