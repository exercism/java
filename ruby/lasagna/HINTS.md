# Hints

## 1. Define the expected oven time in minutes

- You need to define a [constant][constants] that should contain the [integer][integers] value specified in the recipe.
- The `::` used in `Lasagna::EXPECTED_MINUTES_IN_OVEN` means that `EXPECTED_MINUTES_IN_OVEN` needs to be defined within the `Lasagna` class.

## 2. Calculate the remaining oven time in minutes

- You need to define a [method][methods] with a single parameter for the actual time so far.
- You can [implicitly return an integer][return] from the method.
- You can use the [mathematical operator for subtraction][operators] to subtract values.

## 3. Calculate the preparation time in minutes

- You need to define a [method][methods] with a single parameter for the number of layers.
- You can [implicitly return an integer][return] from the method.
- You can use the [mathematical operator for multiplication][operators] to multiply values.
- You could define an extra constant for the time in minutes per layer, or use a "magic number" in the code.

## 4. Calculate the total working time in minutes

- You need to define a [method][methods] with two named parameters: `number_of_layers` and `actual_minutes_in_oven`.
- You can [implicitly return an integer][return] from the method.
- You can [invoke][invocation] one of the other methods you've defined previously.
- You can use the [mathematical operator for addition][operators] to add values.

[methods]: https://launchschool.com/books/ruby/read/methods
[return]: https://www.freecodecamp.org/news/idiomatic-ruby-writing-beautiful-code-6845c830c664/#implicit-return
[operators]: https://www.w3resource.com/ruby/ruby-arithmetic-operators.php
[constants]: https://www.rubyguides.com/2017/07/ruby-constants/
[invocation]: http://ruby-for-beginners.rubymonstas.org/objects/calling.html
[integers]: https://ruby-doc.org/core-2.7.0/Integer.html