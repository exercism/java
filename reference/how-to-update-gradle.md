# How to update the Gradle version

To update the Gradle version of each Gradle wrapper in this repository, start by updating the Gradle wrapper in the `exercises` directory:

```sh
./gradlew wrapper --gradle-version=X.Y
```

Then, update the Gradle wrappers for each exercise to match the root version:

```sh
./gradlew allWrappers
```

Copy the updated Gradle resources to the [exercise template directory][template-resource].

Finally, commit and push your changes.

[template-resource]: https://github.com/exercism/java/tree/main/resources/exercise-template
