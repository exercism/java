import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Step3IncorrectKeyCipherTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
    }

    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithUpperCaseKey() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid key");
        new Cipher("ABCDEF");
    }
    
    
    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithNumericKey() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid key");
        new Cipher("12345");
    }

   
    @Ignore("Remove to run test")
    @Test
    public void cipherThrowsWithEmptyKey() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid key");
        new Cipher("");
    }
    
}
