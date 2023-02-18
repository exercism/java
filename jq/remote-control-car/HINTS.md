# Hints

## 1. Create a brand-new remote controlled car

- The result can use a constant object.

## 2. Create a brand-new remote controlled car with a nickname

- Consider calling the 0-arity function and piping the result to assign the nickname.

## 3. Display the distance

- [String interpolation][string-interpolation] would be useful here.

## 4. Display the battery percentage

- The [if][if-then-else] expression is needed.

## 5. Driving changes the battery and distance driven

- [Arithmetic update-assignments][update-assn] will be useful here.

## 6. Account for driving with a dead battery

- If the battery is dead, it should return the object unchanged.

[string-interpolation]: https://stedolan.github.io/jq/manual/#Stringinterpolation-%5C(foo)
[if-then-else]: https://stedolan.github.io/jq/manual/#if-then-else
[update-assn]: https://stedolan.github.io/jq/manual/#Arithmeticupdate-assignment:+=,-=,*=,/=,%=,//=