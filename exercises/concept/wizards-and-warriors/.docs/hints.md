# Hints

## General

Detailed explanation of inheritance can be found at [Inheritance][inheritance-concept].
The whole inheritance concept has a lot to do with the concepts around [overriding][java-overriding].

## 1. Create the Warrior and Wizard classes

- Review the [class][class-concept] concept.

## 2. Extend Wizard and Warrior classes with Fighter class

- Review the [inheritance][inheritance-concept] concept.

## 3. Describe a Fighter

- In Java, the `toString()` method is actually present inside the `Object` class (which is a superclass to all the classes in Java).
  You can read more about it [here][object-class-java].
- To override this method inside your implementation class, you should have a method with same name i.e. `toString()` and same return type i.e. `String`.

## 4. Making Fighters not vulnerable by default

- Consider having a method `isVulnerable()` inside the `Fighter` class which states vulnerability of the fighter, return `false` to make it non-vulnerable by default.
- This can than be overridden by any child class(the class extending `Fighter`), according to its requirements.
- Again the [overriding][java-overriding] concept will come handy.

## 5. Allowing wizards to prepare a spell

- Preparing a spell can only be done by a wizard.
  So, it makes sense to have this property defined inside the `Wizard` class.
- Create `prepareSpell()` method inside `Wizard` class.
- Remember: Parent class (here `Fighter`) has no access to the properties of the child class (for example, `Wizard`)
- Remember: As the method does not have a return type you should use `void` instead.

## 6. Make Wizards vulnerable when not having prepared a spell

- Override the `isVulnerable()` method in the `Wizard` class to make Wizards vulnerable if they haven't prepared a spell.

## 7. Calculate the damage points for a Wizard

- Use a [conditional statement][if-else] to return the damage points, taking into account the value of the prepare spell field.

## 8. Calculate the damage points for a Warrior

- Use a [conditional statement][if-else] to return the damage points, taking into account the vulnerability of the target.

[inheritance-concept]: https://www.geeksforgeeks.org/inheritance-in-java/
[object-class-java]: https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
[java-overriding]: https://docs.oracle.com/javase/tutorial/java/IandI/override.html
[if-else]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
[class-concept]: https://github.com/exercism/java/blob/main/concepts/classes/introduction.md
