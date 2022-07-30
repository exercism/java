# Meteorology

Welcome to Meteorology on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

[Stringer][stringer-interface] is an interface for defining the string format of values.

The interface consists of a single `String` method:
 
```go
type Stringer interface {
    String() string
}
```
 
Types that want to implement this interface must have a `String()` method that returns a human-friendly string representation of the type. The [fmt][fmt-package] package (and many others) will look for this method to format and print values.

## Example: Distances

Assume we are working on an application that deals with geographical distances measured in different units. 
We have defined types `DistanceUnit` and `Distance` as follows: 
 
```go 
type DistanceUnit int

const (
	Kilometer    DistanceUnit = 0
	Mile         DistanceUnit = 1
)
 
type Distance struct {
	number float64
	unit   DistanceUnit
} 
```

In the example above, `Kilometer` and `Mile` are constants of type `DistanceUnit`.

These types do not implement interface `Stringer` as they lack the `String` method.
Hence `fmt` functions will print `Distance` values using Go's "default format":

```go
mileUnit := Mile
fmt.Sprint(mileUnit)
// => 1
// The result is '1' because that is the underlying value of the 'Mile' contant (see contant declarations above) 

dist := Distance{number: 790.7, unit: Kilometer}
fmt.Sprint(dist)
// => {790.7 0}
// not a very useful output!
```

In order to make the output more informative, we implement interface `Stringer` for `DistanceUnit` and `Distance` types by adding a `String` method to each type:

```go
func (sc DistanceUnit) String() string {
	units := []string{"km", "mi"}
	return units[sc]
}

func (d Distance) String() string {
	return fmt.Sprintf("%v %v", d.number, d.unit)
}
```
 
`fmt` package functions will call these methods when formatting `Distance` values:

```go
kmUnit := Kilometer
kmUnit.String()
// => km

mileUnit := Mile
mileUnit.String()
// => mi

dist := Distance{
	number: 790.7,
	unit: Kilometer,
}
dist.String()
// => 790.7 km
```

[stringer-interface]: https://pkg.go.dev/fmt#Stringer
[fmt-package]: https://pkg.go.dev/fmt

## Instructions

Your team is working on a meteorology application. 
They have defined an API with various types and constants representing meteorological data, see file `meteorology.go`. 
  
Your task is to add suitable `String` methods to all types so that they implement interface `Stringer`. 

## 1. Implement the `Stringer` interface for type `TemperatureUnit`

After some discussion, the team have agreed that the unit of temperature will be either `Celsius` or `Fahrenheit`. Values should be formatted as shown in the examples below.

Make the `TemperatureUnit` type implement the `Stringer` interface by adding a `String` method to it. This method must return the string `"°C"` if the temperature unit is Celsius or `"°F"` if the temperature unit is Fahrenheit.

```go 
temperatureUnit := Celsius
celsiusUnit := Celsius
fahrenheitUnit := Fahrenheit

celsiusUnit.String()
// => °C
fahrenheitUnit.String()
// => °F
fmt.Sprint(celsiusUnit)
// Output: °C
```

## 2. Implement the `Stringer` interface for type  `Temperature`

Temperature values consist of an integer and a temperature unit. They should be formatted as in the examples below.

For that to happen, make the `Temperature` type implement the `Stringer` interface by adding a `String` method to it. This method should return a string with the numeric value for the temperature and the temperature unit separated by a space: `<temperature> <unit>`:


```go
celsiusTemp := Temperature{
    degree: 21,
    unit: Celsius,
}
celsiusTemp.String()
// => 21 °C
fmt.Sprint(celsiusTemp)
// Output: 21 °C

fahrenheitTemp := Temperature{
    degree: 75,
    unit: Fahrenheit,
}
fahrenheitTemp.String()
// => 75 °F
fmt.Sprint(fahrenheitTemp) 
// Output: 75 °F
```

## 3. Implement the `Stringer` interface for type `SpeedUnit`

After lengthy discussions, the team has agreed that the unit of wind speed will be either `KmPerHour` or `MilesPerHour`. Values should be formatted as the examples below.

For that to happen, make the `SpeedUnit` type implement the `Stringer` interface by adding a `String` method to it. This method must return the string `"km/h"` if the speed unit is kilometers per hour or `"mph"` if the speed unit is miles per hour:


```go 
mphUnit := MilesPerHour
mphUnit.String()
// => mph
fmt.Sprint(mphUnit)
// Output: mph

kmhUnit := KmPerHour
kmhUnit.String()
// => km/h
fmt.Sprint(kmhUnit)
// Output: km/h
```

## 4. Implement the `Stringer` interface for `Speed` 

Wind speed values consist of an integer and a speed unit. They should be formatted as in the example below.

For that to happen, make the `Speed` type implement the `Stringer` interface by adding a `String` method to it. This method should return a string with the numeric value for the speed and the speed unit separated by a space: `<speed> <unit>`:

```go 
windSpeedNow := Speed{
    magnitude: 18,
    unit: KmPerHour,
}
windSpeedNow.String(windSpeedNow)
// => 18 km/h
fmt.Sprintf(windSpeedNow)
// Output: 18 km/h

windSpeedYesterday := Speed{
    magnitude: 22,
    unit: MilesPerHour,
}
windSpeedYesterday.String(windSpeedYesterday)
// => 22 mph
fmt.Sprint(windSpeedYesterday)
// Output: 22 mph
```

## 5. Implement the `Stringer` interface for type `MetData`

Meteorological data specifies location, temperature, wind direction, wind speed
and humidity. It should be formatted as in the example below:

For that to happen, make the `MeteorologyData` type implement the `Stringer` interface by adding a `String` method to it. This method should return the meteorology data in the following format:

```
<location>: <temperature>, Wind <wind_direction> at <wind_speed>, <humidity>% Humidity
```

```go 
sfData := MeteorologyData{
    location: "San Francisco",
    temperature: Temperature{
        degree: 57,
        unit: Fahrenheit
    },
    windDirection: "NW",
    windSpeed: Speed{
        magnitude: 19,
        unit: MilesPerHour
    },
    humidity: 60
}

sfData.String()
// => San Francisco: 57 °F, Wind NW at 19 mph, 60% Humidity
fmt.Sprint(sfData) 
// Output: San Francisco: 57 °F, Wind NW at 19 mph, 60% Humidity
```

## Source

### Created by

- @norbs57

### Contributed to by

- @andrerfcsantos
- @eklatzer