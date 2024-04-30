# Instructions

In this exercise you will be doing some more work on remote control cars.

An experimental car has been developed and the test track needs to be adapted to handle both production and experimental models.
The two types of car have already been built and you need to find a way to deal with them both on the test track.

In addition, production cars are beginning to have some success.
The team boss is keen to maintain the competitive spirit by publishing a ranking of the production cars.

## 1. Implement the Interface

Please add two methods to the `RemoteControlCar` interface:

- `drive()`, returning nothing, and
- `getDistanceTravelled()`, returning an `int`.

Then make `ProductionRemoteControlCar` and `ExperimentalRemoteControlCar` implement the `RemoteControlCar` interface.
This includes implementing all methods required by the interface.

## 2. Drive

Each call of `.drive()` should make the car travel a certain distance:

- a `ProductionRemoteControlCar` drives 10 units,
- an `ExperimentalRemoteControlCar` drives 20 units.

The `.getDistanceTravelled()` method should return the number of units that the car has travelled in its lifetime.

```java
ProductionRemoteControlCar prod = new ProductionRemoteControlCar();
prod.drive();
prod.getDistanceTravelled();
// => 10
        
ExperimentalRemoteControlCar exp = new ExperimentalRemoteControlCar();
exp.drive();
exp.getDistanceTravelled();
// => 20
```

## 3. Race

Implement the `TestTrack.race(RemoteControlCar car)` method in which the `car`s get to `drive()`.

```java
TestTrack.race(new ProductionRemoteControlCar());
TestTrack.race(new ExperimentalRemoteControlCar());
// this should execute without an exception being thrown
```

## 4. Allow the production cars to be sorted

Please implement the `Comparable<T>` interface in the `ProductionRemoteControlCar` class.
The default sort order for cars should be descending order of victories.

Implement the static `TestTrack.getRankedCars()` to return the cars passed in, sorted in descending order of number of victories.

```java
ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
prc1.setNumberOfVictories(2);
prc2.setNumberOfVictories(3);
List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
unsortedCars.add(prc1);
unsortedCars.add(prc2);
List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
// => rankings.get(0) == prc2
// => rankings.get(1) == prc1
```
