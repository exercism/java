import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RailFenceCipherTest {

	private RailFenceCipher railFenceCipher;

	@Test
	public void encodeWithTwoRails() {
		railFenceCipher = new RailFenceCipher(2);
		Assert.assertEquals("XXXXXXXXXOOOOOOOOO", railFenceCipher.getEncryptedData("XOXOXOXOXOXOXOXOXO"));
	}

	@Test
	public void encodeWithThreeRails() {
		railFenceCipher = new RailFenceCipher(3);
		Assert.assertEquals("WECRLTEERDSOEEFEAOCAIVDEN", railFenceCipher.getEncryptedData("WEAREDISCOVEREDFLEEATONCE"));
	}

	@Test
	public void encodeWithEndingInTheMiddle() {
		railFenceCipher = new RailFenceCipher(4);
		Assert.assertEquals("ESXIEECSR", railFenceCipher.getEncryptedData("EXERCISES"));
	}

	@Test
	public void decodeWithThreeRails() {
		railFenceCipher = new RailFenceCipher(3);
		Assert.assertEquals("THEDEVILISINTHEDETAILS", railFenceCipher.getDecryptedData("TEITELHDVLSNHDTISEIIEA"));
	}

	@Test
	public void decodeWithFiveRails() {
		railFenceCipher = new RailFenceCipher(5);
		Assert.assertEquals("EXERCISMISAWESOME", railFenceCipher.getDecryptedData("EIEXMSMESAORIWSCE"));
	}

	@Test
	public void decodeWithSixRails() {
		railFenceCipher = new RailFenceCipher(6);
		Assert.assertEquals("112358132134558914423337761098715972584418167651094617711286", railFenceCipher.getDecryptedData("133714114238148966225439541018335470986172518171757571896261"));
	}
}