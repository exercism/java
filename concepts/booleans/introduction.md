# Java Booleans – Complete Beginner Guide

## What Are Booleans?

A **boolean** in Java can store only two values:

* `true`
* `false`

Booleans are widely used in **conditions, loops, decisions, validations, and logical operations**.

---

## Boolean Operators

Java supports three main boolean operators:

### NOT (`!`)

Reverses the value.

```
!true  → false
!false → true
```

### AND (`&&`)

True only if **both** values are true.

```
true && true   → true
true && false  → false
false && true  → false
false && false → false
```

### OR (`||`)

True if **any one** value is true.

```
true || false  → true
false || true  → true
false || false → false
```

---

## Truth Tables

### AND (&&)

| A | B | A && B |
| - | - | ------ |
| T | T | T      |
| T | F | F      |
| F | T | F      |
| F | F | F      |

### OR (||)

| A | B | A || B |
|---|---|---------|
| T | T | T       |
| T | F | T       |
| F | T | T       |
| F | F | F       |

### NOT (!)

| A | !A |
| - | -- |
| T | F  |
| F | T  |

---

## Operator Precedence

Java evaluates operators in this order:

1. Parentheses `()`
2. NOT `!`
3. AND `&&`
4. OR `||`

Example:

```
true || true && false
```

Steps:

* true && false → false
* true || false → true

Final result → `true`

To avoid confusion:

```
true || (true && false)
```

---

## Short-Circuit Evaluation

Java stops evaluation early if the final result is already known.

### AND (&&)

If first operand is false:

```
false && something → second part not checked
```

### OR (||)

If first operand is true:

```
true || something → second part not checked
```

This prevents errors like null pointer exceptions:

```
if (str != null && str.length() > 0)
```

If `str` is null, second part is NOT evaluated.

---

## Practical Examples

### Example 1 – Age Check

```
int age = 20;
boolean canVote = age >= 18; // true
```

### Example 2 – Multiple Conditions

```
int temperature = 35;
boolean isHot = temperature > 30 && temperature < 50; // true
```

### Example 3 – Login Validation

```
boolean usernameCorrect = true;
boolean passwordCorrect = false;

if (usernameCorrect && passwordCorrect) {
    System.out.println("Login successful");
} else {
    System.out.println("Invalid credentials");
}
```

### Example 4 – Checking Grades

```
char grade = 'A';

if (grade == 'A' || grade == 'B') {
    System.out.println("Pass");
}
```

---

## Common Mistakes

### ❌ Using `=` instead of `==`

```
if (isReady = true)  // WRONG: assignment
```

### ✔ Correct

```
if (isReady == true)
```

Even better:

```
if (isReady)
```

### ❌ Unnecessary comparison

```
if (isOpen == true) // redundant
```

✔ Use:

```
if (isOpen)
```

---

## Memory Tricks

* **AND (&&)** → both conditions must be true → "two locks must open"
* **OR (||)** → at least one must be true → "one key is enough"
* **NOT (!)** → flip value → "reverse mode"

---




