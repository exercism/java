# Exercism Java Test Generator

The **Java Track Test Generator** is an automated tool that synchronizes and generates JUnit 5 practice exercise test suites directly from upstream canonical data ([`exercism/problem-specifications`](https://github.com/exercism/problem-specifications)) and the track's [`.meta/tests.toml`](https://exercism.org/docs/building/tracks/tests-toml) configuration.

## Features

- **Upstream Synchronization**: Fetches `canonical-data.json` directly from GitHub, local sibling directories (`../problem-specifications`), or cached downloads.
- **`tests.toml` Awareness**: Automatically includes active tests and excludes any tests marked `include = false`. Respects `reimplements` UUID mappings.
- **Idiomatic JUnit 5 + AssertJ**: Generates standard annotations (`@Test`, `@DisplayName`, `@Disabled("Remove to run test")` on subsequent tests, and `assertThat` / `assertThatExceptionOfType`).
- **Zero-Config Formatting**: Automatically cleans up and normalizes indentation and annotation spacing in generated files.
- **Template-Driven**: Uses Handlebars templates with a clean fallback system:
  1. If an exercise has `.meta/template.hbs`, that template is rendered.
  2. Otherwise, the built-in `default.hbs` template is used.
- **Dry-run Support**: Preview generated test suites in the console before writing to disk.

---

## Usage

### 1. Using the CLI Script (Recommended)

From the repository root, use the `bin/generate-tests` wrapper (it builds the distribution binary on first run):

```bash
# Show help and all CLI options
./bin/generate-tests --help

# Generate tests for a single exercise
./bin/generate-tests -e acronym

# Generate tests for multiple exercises
./bin/generate-tests -e acronym -e two-fer -e hamming

# Dry run (print generated test suite to console without writing to disk)
./bin/generate-tests -e two-fer -d

# Generate tests for all practice exercises
./bin/generate-tests -a

# Bypass cache and re-fetch canonical data from upstream GitHub
./bin/generate-tests -e acronym -f

# Use a local problem-specifications directory instead of downloading
./bin/generate-tests -a -p ../problem-specifications
```

### 2. Using Gradle Directly

From the `test-generator/` directory:

```bash
# Build & install the distribution binary
./gradlew installDist

# Run unit tests
./gradlew test

# Run generator via Gradle
./gradlew run --args="-e acronym"
./gradlew run --args="-a"
```

---

## Exercise-Specific Templates

If an exercise has a custom API (such as stateful objects, builder patterns, or custom method signatures), add a `template.hbs` inside the exercise's `.meta/` directory:

`exercises/practice/<slug>/.meta/template.hbs`

### Available Context Variables:
- `testClassName`: e.g. `AcronymTest`
- `solutionClassName`: e.g. `Acronym`
- `hasExceptions`: boolean (true if any active test case expects an error)
- `testCases`: list of active test cases, each containing:
  - `uuid`: canonical test UUID
  - `description`: canonical test description
  - `methodName`: sanitized camelCase Java method name
  - `disabled`: boolean (true for all tests after the first one)
  - `expectedError`: boolean (true if an exception is expected)
  - `expectedException`: e.g. `IllegalArgumentException`
  - `expectedErrorMessage`: message expected from the exception
  - `expectedValue`: formatted Java literal (e.g. `"PNG"`, `List.of(...)`, `42L`)
  - `formattedInputs`: map of parameter names to formatted Java literals (e.g. `formattedInputs.phrase`)
  - `invocationCode`: default method invocation string
  - `rawCase`: raw canonical JSON case node (for custom helper inspection)

### Built-in Helpers:
- `renderExceptionAssertion`: formats standard AssertJ `assertThatExceptionOfType` blocks
- `asIntList`, `asStringList`, `as2DIntArray`, `asStringArray`: helpers for array/list literals
- Exercise-specific helpers registered in `TemplateRenderer` (e.g., `renderClockCase`, `renderListOpsCase`, etc.)
