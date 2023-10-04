import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.*;

public class DiffieHellmanTest {

    private DiffieHellman diffieHellman;

    @Before
    public void setUp() {
        diffieHellman = new DiffieHellman();
    }

    @Test
    public void testPrivateKeyInRange() {
        BigInteger prime = BigInteger.valueOf(23);
        List<BigInteger> privateKeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            privateKeys.add(diffieHellman.privateKey(prime));
        }

        for (BigInteger privateKey : privateKeys) {
            assertThat(privateKey.compareTo(BigInteger.ONE) >= 0).isTrue();
            assertThat(privateKey.compareTo(prime) < 0).isTrue();
        }
    }

    // Note: due to the nature of randomness, there is always a chance that this test fails
    // Be sure to check the actual generated values
    @Ignore("Remove to run test")
    @Test
    public void testPrivateKeyRandomlyGenerated() {
        BigInteger prime = BigInteger.valueOf(7919);
        BigInteger privateKeyA = diffieHellman.privateKey(prime);
        BigInteger privateKeyB = diffieHellman.privateKey(prime);
        assertThat(privateKeyA).isNotEqualTo(privateKeyB);

    }

    @Ignore("Remove to run test")
    @Test
    public void testPublicKeyCorrectlyCalculated() {
        BigInteger primeA = BigInteger.valueOf(23);
        BigInteger primeB = BigInteger.valueOf(5);
        BigInteger privateKey = BigInteger.valueOf(6);
        BigInteger expected = BigInteger.valueOf(8);

        assertThat(diffieHellman.publicKey(primeA, primeB, privateKey)).isEqualTo(expected);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSecretKeyCorrectlyCalculated() {
        BigInteger prime = BigInteger.valueOf(23);
        BigInteger publicKey = BigInteger.valueOf(19);
        BigInteger privateKey = BigInteger.valueOf(6);
        BigInteger expected = BigInteger.valueOf(2);

        assertThat(diffieHellman.secret(prime, publicKey, privateKey)).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExchange() {
        BigInteger primeA = BigInteger.valueOf(23);
        BigInteger primeB = BigInteger.valueOf(5);

        BigInteger alicePrivateKey = diffieHellman.privateKey(primeA);
        BigInteger bobPrivateKey = diffieHellman.privateKey(primeB);

        BigInteger alicePublicKey = diffieHellman.publicKey(primeA, primeB, alicePrivateKey);
        BigInteger bobPublicKey = diffieHellman.publicKey(primeA, primeB, bobPrivateKey);

        BigInteger secretA = diffieHellman.secret(primeA, bobPublicKey, alicePrivateKey);
        BigInteger secretB = diffieHellman.secret(primeA, alicePublicKey, bobPrivateKey);


        assertThat(secretA).isEqualTo(secretB);
    }

}
