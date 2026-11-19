# Bank Account: Mutation and Regression Maintenance

## Overview

This document records the mutation and regression study for the `bank-account` practice exercise as part of Task R58-T003. It defines a deliberate, semantic mutant of `BankAccount`, identifies the existing test case that rejects it, reduces the rejecting input to the smallest boundary permitted by the specification, and records the named anchor cases.

---

## Contract Under Examination

The `bank-account` exercise specifies a thread-safe bank account with the following lifecycle and state transitions:
1. **Opening / Closing**: Accounts start closed. Calling `open()` opens the account and initializes its balance to `0`. Re-opening an already open account or closing an already closed/unopened account throws `BankAccountActionInvalidException`.
2. **Deposit**: Money can only be deposited into an open account. The deposited amount must be non-negative (`amount >= 0`). A valid deposit adds the amount to the existing balance (`balance += amount`).
3. **Withdrawal**: Money can only be withdrawn from an open account. Withdrawals must not be negative, must not exceed the current balance, and cannot be made from an empty account.
4. **Balance Query**: `getBalance()` retrieves the current accumulated balance of an open account.

---

## Deliberate Scratch Mutation

**File mutated**: `exercises/practice/bank-account/.meta/src/reference/java/BankAccount.java`  
**Location**: `deposit(int amount)` method (line 29)

**Original code**:
```java
    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIfClosed();
        checkIfValidAmount(amount);

        balance += amount;
    }
```

**Mutant code** (inverting output balance accumulation):
```java
    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIfClosed();
        checkIfValidAmount(amount);

        balance -= amount; // MUTANT: inverts deposit arithmetic from addition to subtraction
    }
```

### Rationale and Nature of Mutation
This is a standard Arithmetic Operator Replacement (AOR) mutation. In real-world software, developers frequently copy-paste code between symmetrical operations (such as `deposit` and `withdraw`) and forget to switch `-=` to `+=`. This is a strict semantic mutation that changes the output state construction; it does not change formatting, comments, or whitespace.

---

## Rejecting Test Case

The existing test suite contains an explicit test case that immediately rejects this mutant:

| Property | Value |
|---|---|
| **Canonical UUID** | `e88d4ec3-c6bf-4752-8e59-5046c44e3ba7` |
| **Description** | `Single deposit` |
| **Test Method** | `singleDeposit()` |
| **Test Class** | `BankAccountTest` |
| **Operations** | `bankAccount.open()`, `bankAccount.deposit(100)` |
| **Named Assertion** | `assertThat(bankAccount.getBalance()).isEqualTo(100);` |
| **Original Reference Result** | `100` (Assertion **PASSED**) |
| **Mutant Result** | `-100` (Assertion **FAILED**: `expected: 100, but was: -100`) |

---

## Input Reduction to Smallest Specification Boundary

The existing test `singleDeposit()` uses an arbitrary deposit amount of `100`. We reduce this rejecting case to the smallest input allowed by the specification:

1. **Input `0`**:
   The specification disallows negative amounts (`amount < 0`). While `0` is non-negative and permitted by `checkIfValidAmount`, `0 + 0 = 0` and `0 - 0 = 0`. Because both the correct reference and the mutant produce a balance of `0`, a deposit of `0` cannot distinguish between correct and mutated implementations.
2. **Input `1`**:
   The smallest positive integer amount allowed by the specification is `1` (representing 1 unit or 1 cent).

| Input Operation | Expected Balance (Specification) | Mutant Balance | Outcome |
|---|---|---|---|
| `bankAccount.open()` | `0` | `0` | Match |
| `bankAccount.deposit(1)` | `1` (`0 + 1`) | `-1` (`0 - 1`) | **Distinguishes Mutant** |

### Proposed Minimal Test Case (Maintenance Reference)
If an explicit minimal boundary test is desired in future track revisions:
```java
@Test
@DisplayName("Deposit minimum valid amount")
public void depositMinimumValidAmount() throws BankAccountActionInvalidException {
    bankAccount.open();
    bankAccount.deposit(1);

    assertThat(bankAccount.getBalance()).isEqualTo(1);
}
```
*Note: The existing suite already catches this mutant with `singleDeposit(100)`. This proposed minimal case is documented here for maintenance reference; we do not assert that the current maintained implementation is defective.*

---

## Named Cases Anchored for Task R58-T003

The task anchors three sequential test cases from the bank-account test suite:

| UUID | Description | Java Method | Reference Status | Mutant Status |
|---|---|---|---|---|
| `983a1528-4ceb-45e5-8257-8ce01aceb5ed` | Newly opened account has zero balance | `newlyOpenedAccountHasEmptyBalance()` | PASSED | PASSED |
| `e88d4ec3-c6bf-4752-8e59-5046c44e3ba7` | Single deposit | `singleDeposit()` | PASSED | **FAILED** (rejects mutant) |
| `3d9147d4-63f4-4844-8d2b-1fee2e9a2a0d` | Multiple deposits | `multipleDeposits()` | PASSED | FAILED |

---

## Reproduction

Run the automated verification script from the repository root:
```bash
python3 work/R58-T003/check.py
```
Or via the course check harness:
```bash
python3 tools/course_checks/r58-t003.py
```
