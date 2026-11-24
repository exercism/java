# Exercism Java Test Generator

The **Java Track Test Generator** is an automated tool that synchronizes and generates JUnit 5 practice exercise test suites directly from upstream canonical data ([`exercism/problem-specifications`](https://github.com/exercism/problem-specifications)) and the track's [`.meta/tests.toml`](https://exercism.org/docs/building/tracks/tests-toml) configuration.

## Features

- **Upstream Synchronization**: Fetches `canonical-data.json` directly from the raw GitHub content URL.
- **`tests.toml` Awareness**: Automatically includes active tests and excludes any tests marked `include = false`.
- **Idiomatic JUnit 5 + AssertJ**: Generates standard annotations (`@Test`, `@DisplayName`, `@Disabled("Remove to run test")` on subsequent tests, and `assertThat` / `assertThatExceptionOfType`).
- **Template-Driven**: Uses Handlebars templates with a clean fallback system:
  1. If an exercise has `.meta/template.hbs`, that template is rendered.
  2. Otherwise, the built-in `default.hbs` template is used.
- **Dry-run Support**: Preview generated test suites in the console before writing to disk.

---

## Prerequisites

- Java 17 or higher
- Gradle wrapper (included: `./gradlew`)

---

## Usage

From the `test-generator/` directory:

### 1. Show Help & Options
```bash
./gradlew run --args="--help"
```

### 2. Dry Run (Preview without writing)
```bash
./gradlew run --args="-e two-fer -d"
```

### 3. Generate Tests for a Single Exercise
```bash
./gradlew run --args="-e acronym"
```

### 4. Generate Tests for Multiple Exercises
```bash
./gradlew run --args="-e acronym -e two-fer -e hamming"
```

### 5. Generate Tests for All Practice Exercises
```bash
./gradlew run --args="--all"
```

---

## Exercise-Specific Templates

If an exercise has a non-standard API (e.g., stateful classes or custom constructor signatures), you can place a `template.hbs` inside the exercise's `.meta/` directory:

`exercises/practice/<slug>/.meta/template.hbs`

### Available Template Context:
- `testClassName`: e.g. `AcronymTest`
- `solutionClassName`: e.g. `Acronym`
- `hasExceptions`: boolean (true if any test case expects an error)
- `testCases`: list of active test cases, each containing:
  - `uuid`: test UUID
  - `description`: canonical description
  - `methodName`: sanitized camelCase Java method name
  - `disabled`: true for all tests after the first one
  - `expectedError`: true if an exception is expected
  - `expectedException`: e.g. `IllegalArgumentException`
  - `expectedErrorMessage`: message expected from the exception
  - `expectedValue`: formatted Java literal (e.g. `"PNG"`, `List.of(...)`, `42L`)
  - `formattedInputs`: map of parameter name to formatted Java literal (e.g. `formattedInputs.phrase`)
  - `invocationCode`: default method invocation string
