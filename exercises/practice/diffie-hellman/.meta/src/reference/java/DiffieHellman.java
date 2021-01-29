import java.math.BigInteger;
import java.util.Random;

class DiffieHellman {

    private Random random = new Random();

    BigInteger privateKey(BigInteger primeP) {
        BigInteger privateKey;
        do {
            privateKey = new BigInteger(primeP.bitLength(), random);
        } while (privateKey.compareTo(BigInteger.ZERO) == 0 || privateKey.compareTo(primeP) >= 0);
        return privateKey;
    }

    BigInteger publicKey(BigInteger primeP, BigInteger primeG, BigInteger privateKey) {
        return primeG.modPow(privateKey, primeP);
    }

    BigInteger secret(BigInteger primeP, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.modPow(privateKey, primeP);
    }

}
