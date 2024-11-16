# Instructions

In this exercise, you'll implement the quest logic for a new RPG game that a friend is developing.
The game's main character is Annalyn, a brave girl with a fierce and loyal pet dog.
Unfortunately, disaster strikes: her best friend was kidnapped while searching for berries in the forest.
Annalyn will try to find and rescue her friend, optionally taking her dog along on the quest.

After some time spent following the trail, Annalyn discovers the camp where her friend is imprisoned.
It turns out there are two kidnappers: a mighty knight and a cunning archer.

Having found the kidnappers, Annalyn considers which of the following actions she can engage in:

- Fast attack: a fast attack can be made if the knight is sleeping, as it takes time for him to put on his armor, leaving him vulnerable.
- Spy: the group can be spied upon if at least one of them is awake.
  Otherwise, spying is a waste of time.
- Signal prisoner: the prisoner can be signaled using bird sounds if the prisoner is awake and the archer is sleeping.
  Archers are trained in bird signaling and could intercept the message if they are awake.
- _Free prisoner_: Annalyn can attempt to sneak into the camp to free the prisoner.
  This is risky and can only succeed in one of two ways:
  - If Annalyn has her pet dog, she can rescue the prisoner if the archer is asleep.
    The knight is scared of the dog and the archer will not have time to get ready before Annalyn and the prisoner can escape.
  - If Annalyn does not have her pet dog, then she and the prisoner must be very sneaky!
    Annalyn can free the prisoner if the prisoner is awake and both the knight and archer are sleeping.
    However, if the prisoner is sleeping, they can't be rescued, as the prisoner would be startled by Annalyn's sudden appearance and wake up the knight and archer.

You have four tasks: to implement the logic for determining if the above actions are available based on the state of the three characters in the forest and whether Annalyn's pet dog is present or not.

## 1. Check if a fast attack can be made

Implement the (_static_) `AnnalynsInfiltration.canFastAttack()` method, which takes a boolean value indicating whether the knight is awake.
This method returns `true` if a fast attack can be made based on the state of the knight.
Otherwise, it returns `false`:

```java
boolean knightIsAwake = true;
AnnalynsInfiltration.canFastAttack(knightIsAwake);
// => false
```

## 2. Check if the group can be spied upon

Implement the (_static_) `AnnalynsInfiltration.canSpy()` method, which takes three boolean values indicating whether the knight, archer, and prisoner, respectively, are awake.
The method returns `true` if the group can be spied upon based on the state of the three characters.
Otherwise, it returns `false`:

```java
boolean knightIsAwake = false;
boolean archerIsAwake = true;
boolean prisonerIsAwake = false;
AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake);
// => true
```

## 3. Check if the prisoner can be signaled

Implement the (_static_) `AnnalynsInfiltration.canSignalPrisoner()` method, which takes two boolean values indicating whether the archer and the prisoner, respectively, are awake.
The method returns `true` if the prisoner can be signaled based on the state of the two characters.
Otherwise, it returns `false`:

```java
boolean archerIsAwake = false;
boolean prisonerIsAwake = true;
AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake);
// => true
```

## 4. Check if the prisoner can be freed

Implement the (_static_) `AnnalynsInfiltration.canFreePrisoner()` method, which takes four boolean values.
The first three parameters indicate whether the knight, archer, and prisoner, respectively, are awake.
The last parameter indicates whether Annalyn's pet dog is present.
The method returns `true` if the prisoner can be freed based on the state of the three characters and the presence of Annalyn's pet dog.
Otherwise, it returns `false`:

```java
boolean knightIsAwake = false;
boolean archerIsAwake = true;
boolean prisonerIsAwake = false;
boolean petDogIsPresent = false;
AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent);
// => false
```
