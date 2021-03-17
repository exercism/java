# Instructions

In this exercise you'll be writing code to analyze the production of an assembly line in a car factory. The assembly line's speed can range from `0` (off) to `10` (maximum).

At its lowest speed (`1`), `221` cars are produced each hour. The production increases linearly with the speed. So with the speed set to `4`, it should produce `4 * 221 = 884` cars per hour. However, higher speeds increase the likelihood that faulty cars are produced, which then have to be discarded. The following table shows how speed influences the success rate:

- `1` to `4`: 100% success rate.
- `5` to `8`: 90% success rate.
- `9`: 80% success rate.
- `10`: 77% success rate.

You have two tasks.

## 1. Calculate the production rate per hour

Implement the `CarsAssemble.productionRatePerHour()` method to calculate the assembly line's production rate per hour, taking into account its current assembly line's speed :

```Java
CarsAssemble.productionRatePerHour(6)
// => 1193.4
```

Note that the value returned is a `double`.

## 2. Calculate the number of working items produced per minute

Implement the `CarsAssemble.workingItemsPerMinute()` method to calculate how many working cars are produced per minute:

```Java
CarsAssemble.workingItemsPerMinute(6)
// => 19
```

Note that the value returned is an `int`.
