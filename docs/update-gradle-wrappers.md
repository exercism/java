### Update Gradle Wrappers Across All Exercises

This repository contains many independent Gradle projects (one per exercise). 
To update all Gradle wrappers to a specific version (e.g., to support Java 25), use the helper script below.

#### Script name

Suggested name: `update-gradle-wrappers` (added under `bin/`).

#### Requirements

- macOS/Linux shell with Bash
- Internet access (the first update will download the target Gradle distribution)

#### Usage

```
bin/update-gradle-wrappers [<gradle-version>]
```

- If omitted, the version defaults to `9.2.1`.
- Example: update everything to Gradle 9.2.1

```
bin/update-gradle-wrappers 9.2.1
```

#### What the script does

1. Uses the fixed seed at `exercises/gradle` and runs:
   ```
   ./gradlew wrapper --gradle-version <version>
   ```
   This produces the correct `gradle-wrapper.jar` and `gradle-wrapper.properties` for the requested version.
2. Copies the wrapper files from the seed to every exercise’s `gradle/wrapper/` directory

This aligns with the requested approach: update via Gradle, and ensure consistency by copying the wrapper files everywhere.

#### Notes

- The script uses `exercises/gradle` as the single source of truth (seed) and does not run Gradle in each exercise; it only copies the wrapper files.
- The operation can take time on the first run due to Gradle downloads.

#### Troubleshooting

- If you see permission issues, make the script executable:
  ```
  chmod +x bin/update-gradle-wrappers
  ```
