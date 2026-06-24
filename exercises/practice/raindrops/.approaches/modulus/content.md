# modular arithmetic

```java
import java.math.BigInteger;
import static java.math.BigInteger.valueOf;

class RaindropConverter {

    String convert (int n) {
        return switch ( valueOf(n).modPow( valueOf(12), valueOf(105) ).intValue() ) {
            case 36 -> "Pling";
            case 85 -> "Plang";
            case 91 -> "Plong";
            case 15 -> "PlingPlang";
            case 21 -> "PlingPlong";
            case 70 -> "PlangPlong";
            case  0 -> "PlingPlangPlong";
            default -> String.valueOf(n); // 1
        };
    }

}
```

We can generalize raindrops to any factors if they are [co-prime][co-prime].
In raindrops the factors 3, 5 and 7 are co-prime (sets of prime numbers are all co-prime) and so we can use [Euler's totient function][euler-totient] to calculate `n¹² mod 105` to give us unique values for the various sounds.
The math behind how we find the right exponent and modulus is explained in an article on the related problem of [Fizz-Buzz][fizz-buzz].

[co-prime]: https://en.wikipedia.org/wiki/Coprime_integers
[euler-totient]: https://en.wikipedia.org/wiki/Euler's_totient_function
[fizz-buzz]: https://philcrissman.net/posts/eulers-fizzbuzz/
