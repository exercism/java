# Work Directory for Task R58-T003

## Exercise: `bank-account`

This directory contains the verification harness and recorded evidence for Task R58-T003.

### Purpose

The task verifies:
1. Dynamic path resolution from `exercises/practice/bank-account/.meta/config.json`.
2. Clean mapping of canonical test cases between `exercises/practice/bank-account/.meta/tests.toml` and `exercises/practice/bank-account/src/test/java/BankAccountTest.java`.
3. Maintenance of the learner starter stub (`exercises/practice/bank-account/src/main/java/BankAccount.java`), which must remain unsolved (`UnsupportedOperationException`) and unchanged.
4. Correctness of the maintained reference implementation (`exercises/practice/bank-account/.meta/src/reference/java/BankAccount.java`), passing all 17 tests in an isolated temporary environment.
5. Immediate rejection of a deliberate semantic mutant (`balance -= amount;` in `deposit`) by the named test case `singleDeposit` (`assertThat(bankAccount.getBalance()).isEqualTo(100);`).
6. Reduction of the rejecting case to the minimal input permitted by the specification (`deposit(1)` -> expected `1`, mutant `-1`).
7. Guidance and contract explanation provided in `exercises/practice/bank-account/.docs/hints.md`.
8. Complete documentation of the mutation analysis in `docs/maintenance/bank-account.md`.

### Running the Checks

To execute the verification script:
```bash
python3 work/R58-T003/check.py
```

Or via the course check harness:
```bash
python3 tools/course_checks/r58-t003.py
```

### Artifacts

- `check.py`: Automated verification script using subprocess and isolated temp directories.
- `results.json`: JSON output containing tool versions, test counts, named case statuses, and mutant rejection evidence.
- `latest-result.json`: Mirror of the latest check results for automated harness grading.
