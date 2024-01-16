# Hints

## 1. Shift back the bits

- There are two operators for shifting to the right, but only one will always insert a 0.

## 2. Set some bits

- One of the bit wise operators will always set a bit to 1 where the bits in both values are 1.

## 3. Flip specific bits

- There is an bit operation that will flip a bit where the mask is 1.

## 4. Clear specific bits

- One of the bit operations clears bits where the bit in the mask is 0.
- But you may need to combine it with another operator to clear bits where the mask is 1.
