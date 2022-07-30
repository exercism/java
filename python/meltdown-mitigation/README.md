# Meltdown Mitigation

Welcome to Meltdown Mitigation on Exercism's Python Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Python, [`if`][if statement], `elif` (_a contraction of 'else and if'_) and `else` statements are used to [control the flow][control flow tools] of execution and make decisions in a program.
Unlike many other programming languages, Python versions 3.9 and below do not offer a formal case-switch statement, instead using multiple `elif` statements to serve a similar purpose.

Python 3.10 introduces a variant case-switch statement called `pattern matching`, which will be covered separately in another concept.

Conditional statements use expressions that must resolve to `True` or `False` -- either by returning a `bool` directly, or by evaluating ["truthy" or "falsy"][truth value testing].

```python
x = 10
y = 5

# The comparison '>' returns the bool 'True',
# so the statement is printed.
if x > y:
    print("x is greater than y")
...
>>> x is greater than y
```

When paired with `if`, an optional `else` code block will execute when the original `if` condition evaluates to `False`:

```python
x = 5
y = 10

# The comparison '>' here returns the bool 'False',
# so the 'else' block is executed instead of the 'if' block.
if x > y:
    print("x is greater than y")
else:
    print("y is greater than x")
...
>>> y is greater than x
```

`elif` allows for multiple evaluations/branches.

```python
x = 5
y = 10
z = 20

# The 'elif' statement allows for the checking of more conditions.
if x > y:
    print("x is greater than y and z")
elif y > z:
    print("y is greater than x and z")
else:
    print("z is great than x and y")
...
>>> z is great than x and y
```

[Boolean operations][boolean operations] and [comparisons][comparisons] can be combined with conditionals for more complex testing:

```python

>>> def classic_fizzbuzz(number):
        if number % 3 == 0 and number % 5 == 0:
            return 'FizzBuzz!'
        elif number % 5 == 0:
            return 'Buzz!'
        elif number % 3 == 0:
            return 'Fizz!'
        else:
            return str(number)

>>> classic_fizzbuzz(15)
'FizzBuzz!'

>>> classic_fizzbuzz(13)
'13'
```

[if statement]: https://docs.python.org/3/reference/compound_stmts.html#the-if-statement
[control flow tools]: https://docs.python.org/3/tutorial/controlflow.html#more-control-flow-tools
[truth value testing]: https://docs.python.org/3/library/stdtypes.html#truth-value-testing
[boolean operations]: https://docs.python.org/3/library/stdtypes.html#boolean-operations-and-or-not
[comparisons]: https://docs.python.org/3/library/stdtypes.html#comparisons

## Instructions

In this exercise, we'll develop a simple control system for a nuclear reactor.

For a reactor to produce the power it must be in a state of _criticality_.
If the reactor is in a state less than criticality, it can become damaged.
If the reactor state goes beyond criticality, it can overload and result in a meltdown.
We want to mitigate the chances of meltdown and correctly manage reactor state.

The following three tasks are all related to writing code for maintaining ideal reactor state.

## 1. Check for criticality

The first thing a control system has to do is check if the reactor is balanced in criticality.
A reactor is said to be critical if it satisfies the following conditions:

- The temperature is less than 800 K.
- The number of neutrons emitted per second is greater than 500.
- The product of temperature and neutrons emitted per second is less than 500000.

Implement the function `is_criticality_balanced()` that takes `temperature` measured in kelvin and `neutrons_emitted` as parameters, and returns `True` if the criticality conditions are met, `False` if not.

```python
>>> is_criticality_balanced(750, 600)
True
```

## 2. Determine the Power output range

Once the reactor has started producing power its efficiency needs to be determined.
Efficiency can be grouped into 4 bands:

1. `green` -> efficiency of 80% or more,
2. `orange` -> efficiency of less than 80% but at least 60%,
3. `red` -> efficiency below 60%, but still 30% or more,
4. `black` ->  less than 30% efficient.

The percentage value can be calculated as `(generated_power/theoretical_max_power)*100`
where `generated_power` = `voltage` * `current`.
Note that the percentage value is usually not an integer number, so make sure to consider the
proper use of the `<` and `<=` comparisons.

Implement the function `reactor_efficiency(<voltage>, <current>, <theoretical_max_power>)`, with three parameters: `voltage`,
`current`, and `theoretical_max_power`.
This function should return the efficiency band of the reactor : 'green', 'orange', 'red', or 'black'.

```python
>>> reactor_efficiency(200,50,15000)
'orange'
```

## 3. Fail Safe Mechanism

Your final task involves creating a fail-safe mechanism to avoid overload and meltdown.
This mechanism will determine if the reactor is below, at, or above the ideal criticality threshold.
Criticality can then be increased, decreased, or stopped by inserting (or removing) control rods into the reactor.

Implement the function called `fail_safe()`, which takes 3 parameters: `temperature` measured in kelvin,
`neutrons_produced_per_second`, and `threshold`, and outputs a status code for the reactor.

- If `temperature * neutrons_produced_per_second` < 90% of `threshold`, output a status code of 'LOW'
  indicating that control rods must be removed to produce power.

- If `temperature * neutrons_produced_per_second` are within plus or minus 10% of the `threshold`
  the reactor is in _criticality_ and the status code of 'NORMAL' should be output, indicating that the
  reactor is in optimum condition and control rods are in an ideal position.

- If `temperature * neutrons_produced_per_second` is not in the above-stated ranges, the reactor is
  going into meltdown and a status code of 'DANGER' must be passed to immediately shut down the reactor.

```python
>>> fail_safe(temperature=1000, neutrons_produced_per_second=30, threshold=5000)
'DANGER'
```

## Source

### Created by

- @sachsom95
- @BethanyG

### Contributed to by

- @kbuc