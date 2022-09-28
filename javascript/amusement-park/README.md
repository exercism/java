# Amusement Park

Welcome to Amusement Park on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In contrast to many other languages, there are two different entities in JavaScript that represent the absence of a (meaningful) value.
There is `null` and `undefined`.

## Null

The primitive value `null` is used as an intentional "empty value" for variables of any type.

```javascript
let name = null;
// name is intentionally set to "empty" because it is not
// available
```

You can check whether a variable is null by using the [strict equality operator][mdn-strict-equality] `===`.

```javascript
let name = null;

name === null;
// => true
```

## Undefined

> A variable that has not been assigned a value is of type `undefined`.<sup>1</sup>

That means while `null` represents an empty value (but still a value), `undefined` represents the total absence of a value. 🤯

`undefined` appears in different contexts.

- If a variable is declared without a value (initialization), it is `undefined`.
- If you try to access a value for a non-existing key in an object, you get `undefined`.
- If a function does not return a value, the result is `undefined`.
- If an argument is not passed to a function, it is `undefined`, unless that argument has a default value.

```javascript
let name;
console.log(name);
// => undefined
```

You can check whether a variable is undefined using the strict equality operator `===`.

```javascript
let name;

name === undefined;
// => true
```

## Optional Chaining

If you try to retrieve a nested value in an object but the parent key does not exist, JavaScript will throw an error.
To easily avoid this, optional chaining was added to the language specification in 2020.
With the optional chaining operator `?.` you can ensure that JavaScript only tries to access the nested key if the parent was not `null` or `undefined`.
Otherwise, `undefined` is returned.

```javascript
const obj = {
  address: {
    street: 'Trincomalee Highway',
    city: 'Batticaloa',
  },
};

obj.address.zipCode;
// => undefined

obj.residence.street;
// => TypeError: Cannot read property 'street' of undefined

obj.residence?.street;
// => undefined
```

## Nullish Coalescing

There are situations where you want to apply a default value in case a variable is null or undefined (but only then).
To address this, the nullish coalescing operator `??` was introduced in 2020.
It returns the right-hand side operand only when the left-hand side operand is `null` or `undefined`.
Otherwise, the left-hand side operand is returned.

```javascript
let amount = null;
amount = amount ?? 1;
// => 1

amount = 0;
amount = amount ?? 1;
// => 0
```

---

[1] Undefined, MDN. (2021). https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/undefined (accessed June 4, 2021).

[mdn-strict-equality]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Strict_equality

## Instructions

It is your job to provide and maintain parts of the IT system of an amusement park.
In particular, you are responsible for the program that manages visitors and tickets.

First, you will create a new visitor in the system.
Then you will provide a function for revoking a ticket.
In tasks 3 and 4, you will work on the ticket tracking system that helps to prevent forgery.
Lastly, you will help adapt the system to new legal requirements.

## 1. Create a new visitor

When visitors come to the amusement park for the first time, they need to register by entering their name and age in a terminal and agreeing to the terms and conditions.
Of course, they also need to buy a ticket.
Each ticket has an identifier like `H32AZ123`.

Write a function `createVisitor` that accepts three arguments.

- The name of the visitor.
- The age of the visitor.
- The identifier of the ticket that the visitor bought.

The function should return an object that holds this information.
The keys in the object should be called `name`, `age` and `ticketId`.

```javascript
createVisitor('Verena Nardi', 45, 'H32AZ123');
// => { name: 'Verena Nardi', age: 45, ticketId: 'H32AZ123' }
```

## 2. Revoke the ticket

When people leave the amusement park, their ticket gets revoked.
If they come back, they need to buy a new one.
To save regular visitors some time, they only need to register once and the visitor information will be kept for subsequent visits.

That means when a visitor leaves the park, only their ticket should be invalidated but the rest of the visitor object should stay the same.
Implement the function `revokeTicket` that accepts a visitor object, sets the ticket identifier to `null` and returns the object afterwards.

```javascript
const visitor = {
  name: 'Verena Nardi',
  age: 45,
  ticketId: 'H32AZ123',
};

revokeTicket(visitor);
// => { name: 'Verena Nardi', age: 45, ticketId: null }
```

## 3. Determine the ticket status

To prevent forgery, the ticket identifiers are unique.
Once a ticket is printed, its identifier is added as a key in an object in the system so it can be tracked.

Before the ticket is sold to a visitor, it is stored with the value `null` in the ticket tracking object.
When it is sold to a visitor, the visitor's name is assigned as a value.
When employees have doubts about the validity of a ticket, they need to check the status of the ticket in the system.

Implement a function `ticketStatus` that accepts the tracking object and a ticket identifier as arguments.
It should return one of the following results.

- `'unknown ticket id'` if the identifier was not found in the tracking object
- `'not sold'` in case the ticket was printed but not sold
- `'sold to {name}'` where `{name}` is the name of the visitor if the ticket was sold

```javascript
const tickets = {
  '0H2AZ123': null,
  '23LA9T41': 'Verena Nardi',
};

ticketStatus(tickets, 'RE90VAW7');
// => 'unknown ticket id'

ticketStatus(tickets, '0H2AZ123');
// => 'not sold'

ticketStatus(tickets, '23LA9T41');
// => 'sold to Verena Nardi'
```

## 4. Improve the ticket status response

After a while, you get feedback from the employees that they want the ticket status to be easier to understand at the first glance.
They only want to see either the name of the visitor or that the ticket is invalid.

Write a function `simpleTicketStatus` that accepts the same arguments as `ticketStatus` in task 3.
This function only returns one of two different results.

- the name of the visitor if the ticket was sold
- `'invalid ticket !!!'` if the ticket was not sold yet or the identifier was not found in the tracking object

```javascript
const tickets = {
  '0H2AZ123': null,
  '23LA9T41': 'Verena Nardi',
};

simpleTicketStatus(tickets, '23LA9T41');
// => 'Verena Nardi'

simpleTicketStatus(tickets, '0H2AZ123');
// => 'invalid ticket !!!'

simpleTicketStatus(tickets, 'RE90VAW7');
// => 'invalid ticket !!!'
```

## 5. Determine the version of terms and conditions

Due to new legal requirements, newly created visitor objects now also contain detailed information on the "General Terms & Conditions" (GTC) that the user agreed to.
You can see an example of the new visitor object below.

The cashiers of the amusement park now need to check whether a visitor needs to sign a new version of the GTC.
For this, implement a function `gtcVersion` that accepts a visitor object as an argument and returns the GTC version if it is available.
If the version information is not available, nothing should be returned.

```javascript
const visitorNew = {
  name: 'Verena Nardi',
  age: 45,
  ticketId: 'H32AZ123',
  gtc: {
    signed: true,
    version: '2.1',
  },
};

gtcVersion(visitorNew);
// => '2.1'

const visitorOld = {
  name: 'Verena Nardi',
  age: 45,
  ticketId: 'H32AZ123',
};

gtcVersion(visitorOld);
// => undefined
```

## Source

### Created by

- @junedev