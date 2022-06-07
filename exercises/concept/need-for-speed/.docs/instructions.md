# Instructions

In this exercise you'll be organizing races between various types of remote controlled cars. Each car has its own speed and battery drain characteristics.

Cars start with full (100%) batteries. Each time you drive the car using the remote control, it covers the car's speed in meters and decreases the remaining battery percentage by its battery drain.

If a car's battery is below its battery drain percentage, you can't drive the car anymore.

Each race track has its own distance. Cars are tested by checking if they can finish the track without running out of battery.

You have six tasks, each of which will work with remote controller car instances.

## 1. Creating a remote controlled car

Allow creating a remote controller car by defining a constructor for the `NeedForSpeed` class that takes the speed of the car in meters and the battery drain percentage as its two parameters (both of type `int`):

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
```

## 2. Creating a race track

Allow creating a race track by defining a constructor for the `RaceTrack` class that takes the track's distance in meters as its sole parameter (which is of type `int`):

```java
int distance = 800;
var raceTrack = new RaceTrack(distance);
```

## 3. Drive the car

Implement the `NeedForSpeed.drive()` method that updates the number of meters driven based on the car's speed. Also implement the `NeedForSpeed.distanceDriven()` method to return the number of meters driven by the car:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
car.drive();

car.distanceDriven();
// => 5
```

## 4. Check for a drained battery

Update the `NeedForSpeed.drive()` method to drain the battery based on the car's battery drain. Also implement the `NeedForSpeed.batteryDrained()` method that indicates if the battery is drained:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);
car.drive();

car.batteryDrained();
// => false
```

## 5. Create the Nitro remote control car

The best-selling remote control car is the Nitro, which has a stunning top speed of 50 meters with a battery drain of 4%. Implement the (static) `NeedForSpeed.nitro()` method to return this type of car:

```java
var car = NeedForSpeed.nitro();
car.drive();
car.distanceDriven();
// => 50
```

## 6. Check if a remote control car can finish a race

To finish a race, a car has to be able to drive the race's distance. This means not draining its battery before having crossed the finish line. Implement the `RaceTrack.tryFinishTrack()` method that takes a `NeedForSpeed` instance as its parameter and returns `true` if the car can finish the race; otherwise, return `false`. To see if the car can finish the race, you should try to drive the car until either you reach the end of the track or the battery drains:

```java
int speed = 5;
int batteryDrain = 2;
var car = new NeedForSpeed(speed, batteryDrain);

int distance = 100;
var race = new RaceTrack(distance);

car.distanceDriven()
// => 0

race.tryFinishTrack(car);
// => true

car.distanceDriven()
// => 100
