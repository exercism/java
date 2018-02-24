import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
        BigInteger primeP = BigInteger.valueOf(23);
        List<BigInteger> privateKeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) privateKeys.add(diffieHellman.privateKey(primeP));

        for (BigInteger privateKey : privateKeys) {
            assertTrue((privateKey.compareTo(BigInteger.ONE) >= 0) && (privateKey.compareTo(primeP) < 0));
        }
    }

    // Note: due to the nature of randomness, there is always a chance that this test fails
    // Be sure to check the actual generated values
    @Ignore("Remove to run test")
    @Test
    public void testPrivateKeyRandomlyGenerated() {
        BigInteger primeP = BigInteger.valueOf(7919);
        Set<BigInteger> privateKeys = new HashSet<>();
        for (int i = 0; i < 5; i++) privateKeys.add(diffieHellman.privateKey(primeP));

        assertEquals(5, privateKeys.size());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPublicKeyCorrectlyCalculated() {
        BigInteger primeP = BigInteger.valueOf(23);
        BigInteger primeG = BigInteger.valueOf(5);
        BigInteger privateKey = BigInteger.valueOf(6);
        BigInteger expected = BigInteger.valueOf(8);

        assertEquals(expected, diffieHellman.publicKey(primeP, primeG, privateKey));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecretKeyCorrectlyCalculated() {
        BigInteger primeP = BigInteger.valueOf(23);
        BigInteger publicKey = BigInteger.valueOf(19);
        BigInteger privateKey = BigInteger.valueOf(6);
        BigInteger expected = BigInteger.valueOf(2);

        assertEquals(expected, diffieHellman.secret(primeP, publicKey, privateKey));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSecretKeyCorrectlyCalculatedWhenUsingLargePrimes() {
        BigInteger primeP = new BigInteger("120227323036150778550155526710966921740030662694578947298423549235265759593711587341037426347114541533006628856300552706996143592240453345642869233562886752930249953227657883929905072620233073626594386072962776144691433658814261874113232461749035425712805067202910389407991986070558964461330091797026762932543");
        BigInteger publicKey = new BigInteger("75205441154357919442925546169208711235485855904969178206313309299205868312399046149367516336607966149689640419216591714331722664409474612463910928128055994157922930443733535659848264364106037925315974095321112757711756912144137705613776063541350548911512715512539186192176020596861210448363099541947258202188");
        BigInteger privateKey = new BigInteger("2483479393625932939911081304356888505153797135447327501792696199190469015215177630758617902200417377685436170904594686456961202706692908603181062371925882");
        BigInteger expected = new BigInteger("70900735223964890815905879227737819348808518698920446491346508980461201746567735331455825644429877946556431095820785835497384849778344216981228226252639932672153547963980483673419756271345828771971984887453014488572245819864454136618980914729839523581263886740821363010486083940557620831348661126601106717071");


        assertEquals(expected, diffieHellman.secret(primeP, publicKey, privateKey));
    }

    @Ignore("Remove to run test")
    @Test
    public void testExchange() {
        BigInteger primeP = BigInteger.valueOf(23);
        BigInteger primeG = BigInteger.valueOf(5);

        BigInteger privateKeyA = diffieHellman.privateKey(primeP);
        BigInteger privateKeyB = diffieHellman.privateKey(primeP);

        BigInteger publicKeyA = diffieHellman.publicKey(primeP, primeG, privateKeyA);
        BigInteger publicKeyB = diffieHellman.publicKey(primeP, primeG, privateKeyB);

        BigInteger secretA = diffieHellman.secret(primeP, publicKeyB, privateKeyA);
        BigInteger secretB = diffieHellman.secret(primeP, publicKeyA, privateKeyB);

        assertEquals(secretA, secretB);
    }

}
