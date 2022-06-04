# Little Sister's Vocabulary

Welcome to Little Sister's Vocabulary on Exercism's Python Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

A `str` in Python is an [immutable sequence][text sequence] of [Unicode code points][unicode code points].
These could include letters, diacritical marks, positioning characters, numbers, currency symbols, emoji, punctuation, space and line break characters, and more.
 Being immutable, a `str` object's value in memory doesn't change; methods that appear to modify a string return a new copy or instance of that `str` object.


A `str` literal can be declared via single `'` or double `"` quotes. The escape `\` character is available as needed.


```python

>>> single_quoted = 'These allow "double quoting" without "escape" characters.'

>>> double_quoted = "These allow embedded 'single quoting', so you don't have to use an 'escape' character".

>>> escapes = 'If needed, a \'slash\' can be used as an escape character within a string when switching quote styles won\'t work.'
```

Multi-line strings are declared with `'''` or `"""`.


```python
>>> triple_quoted =  '''Three single quotes or "double quotes" in a row allow for multi-line string literals.
  Line break characters, tabs and other whitespace are fully supported.

  You\'ll most often encounter these as "doc strings" or "doc tests" written just below the first line of a function or class definition.
    They\'re often used with auto documentation ✍ tools.
    '''
```

Strings can be concatenated using the `+` operator.
 This method should be used sparingly, as it is not very performant or easily maintained.


```python
language = "Ukrainian"
number = "nine"
word = "девять"

sentence = word + " " + "means" + " " + number + " in " + language + "."

>>> print(sentence)
...
"девять means nine in Ukrainian."
```

If a `list`, `tuple`, `set` or other collection of individual strings needs to be combined into a single `str`, [`<str>.join(<iterable>)`][str-join], is a better option:


```python
# str.join() makes a new string from the iterables elements.
>>> chickens = ["hen", "egg", "rooster"]
>>> ' '.join(chickens)
'hen egg rooster'

# Any string can be used as the joining element.
>>> ' :: '.join(chickens)
'hen :: egg :: rooster'

>>> ' 🌿 '.join(chickens)
'hen 🌿 egg 🌿 rooster'
```

Code points within a `str` can be referenced by `0-based index` number from the left:


```python
creative = '창의적인'

>>> creative[0]
'창'

>>> creative[2]
'적'

>>> creative[3]
'인'
```

Indexing also works from the right, starting with a `-1-based index`:


```python
creative = '창의적인'

>>> creative[-4]
'창'

>>> creative[-2]
'적'

>>> creative[-1]
'인'

```


There is no separate “character” or "rune" type in Python, so indexing a string produces a new `str` of length 1:


```python

>>> website = "exercism"
>>> type(website[0])
<class 'str'>

>>> len(website[0])
1

>>> website[0] == website[0:1] == 'e'
True
```

Substrings can be selected via _slice notation_, using [`<str>[<start>:stop:<step>]`][common sequence operations] to produce a new string.
 Results exclude the `stop` index.
 If no `start` is given, the starting index will be 0.
 If no `stop` is given, the `stop` index will be the end of the string.


```python
moon_and_stars = '🌟🌟🌙🌟🌟⭐'
sun_and_moon = '🌞🌙🌞🌙🌞🌙🌞🌙🌞'

>>> moon_and_stars[1:4]
'🌟🌙🌟'

>>> moon_and_stars[:3]
'🌟🌟🌙'

>>> moon_and_stars[3:]
'🌟🌟⭐'

>>> moon_and_stars[:-1]
'🌟🌟🌙🌟🌟'

>>> moon_and_stars[:-3]
'🌟🌟🌙'

>>> sun_and_moon[::2]
'🌞🌞🌞🌞🌞'

>>> sun_and_moon[:-2:2]
'🌞🌞🌞🌞'

>>> sun_and_moon[1:-1:2]
'🌙🌙🌙🌙'
```

Strings can also be broken into smaller strings via [`<str>.split(<separator>)`][str-split], which will return a `list` of substrings.
 The list can then be further indexed or split, if needed.
 Using `<str>.split()` without any arguments will split the string on whitespace.


```python
>>> cat_ipsum = "Destroy house in 5 seconds mock the hooman."
>>> cat_ipsum.split()
...
['Destroy', 'house', 'in', '5', 'seconds', 'mock', 'the', 'hooman.']


>>> cat_ipsum.split()[-1]
'hooman.'


>>> cat_words = "feline, four-footed, ferocious, furry"
>>> cat_words.split(', ')
...
['feline', 'four-footed', 'ferocious', 'furry']
```


Separators for `<str>.split()` can be more than one character.
The **whole string** is used for split matching.


```python

>>> colors = """red,
orange,
green,
purple,
yellow"""

>>> colors.split(',\n')
['red', 'orange', 'green', 'purple', 'yellow']
```

Strings support all [common sequence operations][common sequence operations].
 Individual code points can be iterated through in a loop via `for item in <str>`.
 Indexes _with_ items can be iterated through in a loop via `for index, item in enumerate(<str>)`.


```python

>>> exercise = 'လေ့ကျင့်'

# Note that there are more code points than perceived glyphs or characters
>>> for code_point in exercise:
...    print(code_point)
...
လ
ေ
့
က
ျ
င
်
့

# Using enumerate will give both the value and index position of each element.
>>> for index, code_point in enumerate(exercise):
...    print(index, ": ", code_point)
...
0 :  လ
1 :  ေ
2 :  ့
3 :  က
4 :  ျ
5 :  င
6 :  ်
7 :  ့
```


[common sequence operations]: https://docs.python.org/3/library/stdtypes.html#common-sequence-operations
[str-join]: https://docs.python.org/3/library/stdtypes.html#str.join
[str-split]: https://docs.python.org/3/library/stdtypes.html#str.split
[text sequence]: https://docs.python.org/3/library/stdtypes.html#text-sequence-type-str
[unicode code points]: https://stackoverflow.com/questions/27331819/whats-the-difference-between-a-character-a-code-point-a-glyph-and-a-grapheme

## Instructions

You are helping your younger sister with her English vocabulary homework, which she's finding very tedious.
 Her class is learning to create new words by adding _prefixes_ and _suffixes_.
 Given a set of words, the teacher is looking for correctly transformed words with correct spelling by adding the prefix to the beginning or the suffix to the ending.

There's four activities in the assignment, each with a set of text or words to work with.


## 1. Add a prefix to a word

One of the most common prefixes in English is `un`, meaning "not".
 In this activity, your sister needs to make negative, or "not" words by adding `un` to them.

Implement the `add_prefix_un()` function that takes `word` as a parameter and returns a new `un` prefixed word:


```python
>>> add_prefix_un("happy")
'unhappy'

>>> add_prefix_un("manageable")
'unmanageable'
```


## 2. Add prefixes to word groups

There are four more common prefixes that your sister's class is studying:
 `en` (_meaning to 'put into' or 'cover with'_),
 `pre` (_meaning 'before' or 'forward'_),
 `auto` (_meaning 'self' or 'same'_),
  and `inter` (_meaning 'between' or 'among'_).

 In this exercise, the class is creating groups of vocabulary words using these prefixes, so they can be studied together.
 Each prefix comes in a list with common words it's used with.
 The students need to apply the prefix and produce a string that shows the prefix applied to all of the words.

Implement the `make_word_groups(<vocab_words>)` function that takes a `vocab_words` as a parameter in the following form:
 `[<prefix>, <word_1>, <word_2> .... <word_n>]`, and returns a string with the prefix applied to each word that looks like:
  `'<prefix> :: <prefix><word_1> :: <prefix><word_2> :: <prefix><word_n>'`.


```python
>>> make_word_groups(['en', 'close', 'joy', 'lighten'])
'en :: enclose :: enjoy :: enlighten'

>>> make_word_groups(['pre', 'serve', 'dispose', 'position'])
'pre :: preserve :: predispose :: preposition'

>> make_word_groups(['auto', 'didactic', 'graph', 'mate'])
'auto :: autodidactic :: autograph :: automate'

>>> make_word_groups(['inter', 'twine', 'connected', 'dependent'])
'inter :: intertwine :: interconnected :: interdependent'
```


## 3. Remove a suffix from a word

`ness` is a common suffix that means _'state of being'_.
 In this activity, your sister needs to find the original root word by removing the `ness` suffix.
  But of course there are pesky spelling rules: If the root word originally ended in a consonant followed by a 'y', then the 'y' was changed to 'i'.
 Removing 'ness' needs to restore the 'y' in those root words. e.g. `happiness` --> `happi` --> `happy`.

Implement the `remove_suffix_ness(<word>)` function that takes in a word `str`, and returns the root word without the `ness` suffix.


```python
>>> remove_suffix_ness("heaviness")
'heavy'

>>> remove_suffix_ness("sadness")
'sad'
```

## 4. Extract and transform a word

Suffixes are often used to change the part of speech a word has.
 A common practice in English is "verbing" or "verbifying" -- where an adjective _becomes_ a verb by adding an `en` suffix.

In this task, your sister is going to practice "verbing" words by extracting an adjective from a sentence and turning it into a verb.
 Fortunately, all the words that need to be transformed here are "regular" - they don't need spelling changes to add the suffix.

Implement the `adjective_to_verb(<sentence>, <index>)` function that takes two parameters.
 A `sentence` using the vocabulary word, and the `index` of the word, once that sentence is split apart.
 The function should return the extracted adjective as a verb.


```python
>>> adjective_to_verb('I need to make that bright.', -1 )
'brighten'

>>> adjective_to_verb('It got dark as the sun set.', 2)
'darken'
```

## Source

### Created by

- @aldraco
- @bethanyg