# Custom Signs

Welcome to Custom Signs on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In JavaScript, _template strings_ allows for embedding expressions in strings, also referred to as string interpolation.
This functionality extends the functionality of the built-in [`String`][string-reference] global object.

You can create template strings in JavaScript by wrapping text in backticks.
They not only allow the text to include new lines and other special characters, but you can also embed variables and other expressions.

```javascript
const num1 = 1;
const num2 = 2;

`Adding ${num1} and ${num2} gives ${num1 + num2}.`;
// => Adding 1 and 2 gives 3.
```

In the example above, backticks - (<code>\`\`</code>) - are used to represent a template string. The`${...}` is the placeholder that is used for substitution.
Any non-string types are _implicitly_ converted to strings.
This topic is covered in the [type conversion][type-conversion-concept] concept.
All types of expressions can be used with template strings.

```javascript
const track = 'JavaScript';

`This track on exercism.org is ${track.toUpperCase()}.`;
// => This track on exercism.org is JAVASCRIPT.
```

When you are needing to have strings formatted on multiple lines:

```javascript
`This is an example of using template
strings to accomplish multiple
lines`;
```

With the available substitution capabilities, you can also introduce logic into the process to determine what the output string should be.

An example of this is embedding a [ternary operator][ternary-operator].
This operator is a short form for writing an `if/else` statement.
The syntax is `condition ? consequent-expression : alternative-expression`.
If the condition is truthy, the operand on the left-hand side of the colon will be returned.
Otherwise, the result of the ternary expression is the operand on the right-hand side of the colon.

```javascript
const grade = 95;

`You have ${grade > 90 ? 'passed' : 'failed'} the exam.`;
// => You have passed the exam.
```

[string-reference]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
[type-conversion-concept]: /tracks/javascript/concepts/type-conversion
[ternary-operator]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_Operator

## Instructions

In this exercise you'll be writing code to help a sign company create custom messages for their signs.

## 1. Build an occasion sign

Implement the function `buildSign(occasion, name)` that accepts a string as the `occasion` parameter and a string holding someone's name as the `name` parameter. The two parameters will be embedded into a template string to output the message on the sign.

```javascript
buildSign('Birthday', 'Rob');
// => "Happy Birthday Rob!"
```

## 2. Build a birthday sign

Implement the function `buildBirthdaySign(age)` that accepts an age and based on the age will determine part of the message on the sign. If the age is 50 or older, the sign will include the word _mature_, otherwise the sign will include the word _young_.

```javascript
buildBirthdaySign(45);
// => "Happy Birthday! What a young fellow you are."
```

## 3. Build a graduation sign

Implement the function `graduationFor(name, year)` which takes a name as a string parameter and a year as a number parameter and uses string interpolation to create a phrase for a sign that uses a newline to separate the two lines of the message.

```javascript
graduationFor('Hannah', 2022);
// => "Congratulations Hannah!\nClass of 2022"
```

## 4. Compute the cost of a sign

Implement the function `costOf(sign, currency)` which takes a string that holds the contents of the sign and a string that represents the currency.
The sign has a base price of 20 in the given currency. Additionally each letter costs 2. (Whitespaces are included in the calculation.)
The phrase returned includes the cost to create the sign, written with two digits after the decimal point, followed by the currency string.

```javascript
costOf('Happy Birthday Rob!', 'dollars');
// => "Your sign costs 58.00 dollars."
```

## Source

### Created by

- @pertrai1