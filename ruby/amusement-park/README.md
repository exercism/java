# Amusement Park

Welcome to Amusement Park on Exercism's Ruby Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Instance Variables

Objects can hold their own state by setting _instance variables_.
These variables live within an object and are normally used to store some internal state.

Instance variables always start with an `@`.
You can create a new instance variable by setting a variable starting with an `@`.
For example:

```ruby
class Repeater
  def hear(something)
    # Save what's been heard into a new instance variable called @heard
    @heard = something
  end

  def repeat
    # Return the value of the instance variable
    @heard
  end
end

repeater = Repeater.new
repeater.hear("Hello, friend!")
print repeater.repeat # Prints "Hello, friend!"
```

Objects usually set their initial state in an `initialize` method, which is automatically called when calling `new` on a class.

```ruby
class Airplane
  def initialize
    @wings = 2
  end

  def wings
    @wings
  end
end

plane = Airplane.new
plane.wings # returns 2
```

The `initialize` method may also take arguments, so that each instance can start with a custom state:

```ruby
class Suitcase
  def initialize(locked)
    @locked = locked
  end
end
```

It is good practice to consider _instance_ variables to be private from external read and writes.
We instead define methods to get and set their values.
For example:

```ruby
class Suitcase
  def initialize
    @locked = false
  end

  def locked? # Query methods should be named with a trailing `?`
    @locked
  end

  def lock! # Methods which mutate state should have trailing `!`
    @locked = true
  end
end

suitcase = Suitcase.new
suitcase.locked? # false
suitcase.lock!
suitcase.locked? # true
```

## Nil

[Nil][nil-dictionary] is an English word meaning "nothing" or "zero".
In Ruby, `nil` is used to express the _absence_ of an object.
In other programming languages, `null` or `none` values may play a similar role.

```ruby
# I do not have a favorite color
favorite_color = nil
```

Ruby gives any instance variable the default value of `nil` when it is first encountered, until it is otherwise given a value.

```ruby
print @favourite_color # prints nil
@favourite_color = "blue"
print @favourite_color # prints "blue"
```

[nil-dictionary]: https://www.merriam-webster.com/dictionary/nil

## Instructions

Working with an amusement park, you've been handed a specification to design a system to administer attendance and rides. You've been tasked with modeling the Attendee (person visiting the park).

## 1. Make new attendees

Implement the `Attendee#initialize` method of the `Attendee` class, it should take a height (in centimeters) and store it as an instance variable

```ruby
Attendee.new(106)
# => #<Attendee:0x000055c33e6c7e18 @height=106>
```

## 2. How tall is the attendee

Implement the `Attendee#height` getter of the `Attendee` class, it should return the instances height

```ruby
Attendee.new(106).height
# => 106
```

## 3. What is the ride pass id

Not all attendees have bought a ride pass, but we need to know if they have a pass or not. Implement the `Attendee#pass_id` getter for the `Attendee` class, it should return the instance's pass_id or `nil` if the Attendee doesn't have one.

```ruby
Attendee.new(106).pass_id
# => nil
```

## 4. Allow people to buy a pass

Implement `Attendee#issue_pass!` to mutate the state of the instance, and set the pass id instance variable to the argument. It should return the pass id.

```ruby
attendee = Attendee.new(106)
attendee.issue_pass!(42)
attendee.pass_id
# => 42
```

## 4. Revoke the pass

Some guests break the rules with unsafe behavior, so the park wants to be able to revoke passes. Implement `Attendee#revoke_pass` to mutate the state of the instance, and set the pass id to `nil`

```ruby
attendee = Attendee.new(106)
attendee.issue_pass!(42)
attendee.revoke_pass!
attendee.pass_id
# => nil
```

## Source

### Created by

- @neenjaw
- @iHiD

### Contributed to by

- @kotp