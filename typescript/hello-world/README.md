# Hello World

The classical introductory exercise. Just say "Hello, World!".

["Hello, World!"](http://en.wikipedia.org/wiki/%22Hello,_world!%22_program) is
the traditional first program for beginning programming in a new language
or environment.

The objectives are simple:

- Write a function that returns the string "Hello, World!".
- Run the test suite and make sure that it succeeds.
- Submit your solution and check it at the website.

If everything goes well, you will be ready to fetch your first real exercise.

## Setup

Go through the setup instructions for TypeScript to
install the necessary dependencies:

http://exercism.io/languages/typescript

## Requirements

Install assignment dependencies:

```bash
$ yarn install
```

## Making the test suite pass

Execute the tests with:

```bash
$ yarn test
```

In many test suites all but the first test have been skipped.

Once you get a test passing, you can unskip the next one by
changing `xit` to `it`.

## Tutorial

This section is a step-by-step guide to solving this exercise.

This exercise has two files:

- hello-world.ts
- hello-world.test.ts

The first file is where you will write your code.
The second is where the tests are defined.

The tests will check whether your code is doing the right thing.
You don't need to be able to write a test suite from scratch,
but it helps to understand what a test looks like, and what
it is doing.

Open up the test file, hello-world.test.ts.
There is a single test inside:

```typescript
  it('says hello world with no name', () => {
    expect(HelloWorld.hello()).toEqual('Hello, World!')
  })
```


Run the tests now, with the following command on the command-line:

```bash
$ yarn test
```

The test fails, which makes sense since you've not written any code yet.

The failure looks like this:

```
    × says hello world with no name (5ms)

  ● Hello World › says hello world with no name

    expect(received).toEqual(expected) // deep equality

    Expected: "Hello, World!"
    Received: undefined

      4 |
      5 |   it('says hello world with no name', () => {
    > 6 |     expect(HelloWorld.hello()).toEqual('Hello, World!')
        |                                ^
      7 |   })
      8 |
      9 | })

      at Object.it (hello-world.test.ts:6:32)
```

And these are those code lines with probable defects in the `hello-world.test.ts` file:

the 6th line:
```
    expect(HelloWorld.hello)).toEqual('Hello, World!')
                              ^
```


Hence the problem is with the `HelloWorld.hello()` call where we are calling the `hello` static method from the `HelloWorld` class.
We can see that the test is expecting `'Hello, World!'` as output, but instead is getting `undefined`.

So let's check now this method in the `hello-worlds.ts` file:

```typescript
class HelloWorld {
    static hello() {
        // Your code here
    }
}

export default HelloWorld
```

Now we see that the method doesn't return anything, which is the reason for our failure. Let's fix this by adding a return value:

```typescript
class HelloWorld {
    static hello(message:string) {
        return 'Hello, World!'
    }
}

export default HelloWorld
```

Run tests again:
```bash
 PASS  ./hello-world.test.ts
  Hello World
    √ says hello world with no name (4ms)
```
And they pass!

Now when we are done, let's submit our solution to exercism:

```bash
$ exercism submit hello-world.ts
```


## Setup

Go through the setup instructions for TypeScript to install the necessary
dependencies:

[https://exercism.io/tracks/typescript/installation](https://exercism.io/tracks/typescript/installation)

## Requirements

Install assignment dependencies:

```bash
$ yarn install
```

## Making the test suite pass

Execute the tests with:

```bash
$ yarn test
```

## Source

This is an exercise to introduce users to using Exercism [http://en.wikipedia.org/wiki/%22Hello,_world!%22_program](http://en.wikipedia.org/wiki/%22Hello,_world!%22_program)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
