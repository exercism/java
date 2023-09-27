# `charAt()` and `substring()`

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class PigLatinTranslator {

    private static final HashSet < Character > vowels = new HashSet < Character > (Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final HashSet < String > specials = new HashSet < String > (Arrays.asList("xr", "yt"));

    public String translate(String phrase) {
        ArrayList < String > piggyfied = new ArrayList < String > ();
        var words = phrase.split(" ");

        for (String word: words) {
            if (vowels.contains(word.charAt(0)) || specials.contains(word.substring(0, 2))) {
                piggyfied.add(word + "ay");
                continue;
            }

            var length = word.length();
            
            for (int pos = 1; pos < length; pos++) {
                var letter = word.charAt(pos);
                if (vowels.contains(letter) || letter == 'y') {
                    if (letter == 'u' && word.charAt(pos - 1) == 'q') pos += 1;
                    piggyfied.add(word.substring(pos) + word.substring(0, pos) + "ay");
                    break;
                }
            }
        }
        return String.join(" ", piggyfied);
    }
}
```

This approach starts by importing from packages for what will be needed.

The class defines two [`private`][private] [`static`][static] [`final`][final] [`HashSet`][hashset]s to define the vowels
and special letter sequences.
They are `private` because they don't need to be directly accessed from outside the class, and `final`
because they don't need to be reassigned after being created.
They are `static` because they don't need to differ between object instantiations, so they can belong to the class itself.

The `translate()` method starts by defining the [`ArrayList()`][arraylist] to hold the words to be output.
The input `String` is then [`split()`][split] on a space to create the array of words.

A [for-each][for-each] loop is used to iterate the words.

An `if` statement checks if the first character in the word is a vowel.
It does this by using the `String` [`charAt()`][charat] method to get the character at the first index of the word.
It then uses the `HashSet` [`contains()`][contains] method to see if the `HashSet` of vowels contains the character.
If so, the logical OR operator (`||`) [short circuits][short-circuit] and `ay` is concatenated to the word, which is then
[`add`][add]ed to the output `ArrayList`, and the loop [continue][continue]s.

If the first character is not a vowel, the other side of the `OR` operator checks if the first two characters
of the word are a special sequence.
It does this by using the `String` [`substring()`][substring-two] method to get a `String` of the first two characters
of the word.
It then uses the `HashSet.contains()` method to see if the `HashSet` of special sequences contains the substring.
If so, then `ay` is concatenated to the word, which is then added to the `ArrayList`, and the loop continues.

If the word does not start with a vowel or special sequence of letters, then the length of the word
is set to prepare for iterating through the word characters, starting with the second character at index `1`.

Inside a [`for`][for-loop] loop, the character at the current iterating index is set.
The `HashSet.contains()` method is used to see if the `HashSet` of vowels contains the character.
If not, the other side of the logical `OR` operator checks to see if the character is a `y`.
If the character is a vowel or `y`, then the character is checked to see if it is a `u`, and, if so,
if the previous character is a `q`.
If the index is at the end of a `qu` sequence, then the index is incremented by `1`, otherwise the index is left as is.
Finally, the word is made into Pig Latin by getting a [`substring()`][substring-one] from the index until the end of the word,
to which is concatenated a [`substring()`][substring-two] from the beginning of the word up to but not including the indexed character,
and concatenating `ay`.

~~~~exercism/note
Note that there are two overloads of the `substring()` method.
One takes one argument which will return a substring from the index of the argument until the end of the `String`.
The other takes two arguments: the starting index and the ending index.
It returns a substring from the starting index up to but not including the ending index.
~~~~

After all of the words are iterated, the `ArrayList` of words is assembled into a single `String` by using the
[`String.join()`][join] method to join all of the words together, separated by a single space,
and that `String` is returned from the function.

[charat]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int)
[substring-one]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#substring(int)
[substring-two]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#substring(int,%20int)
[split]: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String)
[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[hashset]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html
[arraylist]: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
[for-each]: https://www.geeksforgeeks.org/for-each-loop-in-java/
[contains]: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/HashSet.html#contains(java.lang.Object)
[add]: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#add-E-
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
[continue]: https://www.geeksforgeeks.org/continue-statement-in-java/
[for-loop]: https://www.geeksforgeeks.org/java-for-loop-with-examples/
[join]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#join(java.lang.CharSequence,java.lang.Iterable)
