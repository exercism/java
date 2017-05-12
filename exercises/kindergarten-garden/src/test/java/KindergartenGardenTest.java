import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class KindergartenGardenTest {
	@Test
	public void singleStudent() {
		String student = "Alice";
		String plants = "RC\nGG";
		String[] expected = {"radishes", "clover", "grass", "grass"};

		assertEquals(expected, new KindergartenGarden(plants)
								.getPlantsOfStudent(student));
	}

	@Ignore("Remove to run test")
	@Test
	public void singleStudent2() {
		String student = "Alice";
        String plants = "VC\nRC";
        String[] expected = {"violets", "clover", "radishes", "clover"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}

	@Ignore("Remove to run test")
	@Test
	public void twoStudents() {
		String student = "Bob";
        String plants = "VVCG\nVVRC";
        String[] expected = {"clover", "grass", "radishes", "clover"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}

	@Ignore("Remove to run test")
	@Test
	public void oneGardenSecondStudent() {
		String student = "Bob";
        String plants = "VVCCGG\nVVCCGG";
        String[] expected = {"clover", "clover", "clover", "clover"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}

	@Ignore("Remove to run test")
	@Test
	public void oneGardenThirdStudent() {
		String student = "Charlie";
        String plants = "VVCCGG\nVVCCGG";
        String[] expected = {"grass", "grass", "grass", "grass"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void fullGardenFirstStudent() {
		String student = "Alice";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String[] expected = {"violets", "radishes", "violets", "radishes"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void fullGardenSecondStudent() {
		String student = "Bob";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String[] expected = {"clover", "grass", "clover", "clover"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void fullGardenSecondToLastStudent() {
		String student = "Kincaid";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String[] expected = {"grass", "clover", "clover", "grass"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void fullGardenLastStudent() {
		String student = "Larry";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String[] expected = {"grass", "violets", "clover", "violets"};

        assertEquals(expected, new KindergartenGarden(plants)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void customStudentGardenFirstStudent() {
		String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
		String student = "Patricia";
        String plants = "VCRRGVRG\nRVGCCGCV";
        String[] expected = {"violets", "clover", "radishes", "violets"};

        assertEquals(expected, new KindergartenGarden(plants, studentArray)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void customStudentGardenSecondStudent() {
		String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
		String student = "Roger";
        String plants = "VCRRGVRG\nRVGCCGCV";
        String[] expected = {"radishes", "radishes", "grass", "clover"};

        assertEquals(expected, new KindergartenGarden(plants, studentArray)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void customStudentGardenThirdStudent() {
		String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
		String student = "Samantha";
        String plants = "VCRRGVRG\nRVGCCGCV";
        String[] expected = {"grass", "violets", "clover", "grass"};

        assertEquals(expected, new KindergartenGarden(plants, studentArray)
        						.getPlantsOfStudent(student));
	}
	
	@Ignore("Remove to run test")
	@Test
	public void customStudentGardenFourthStudent() {
		String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
		String student = "Xander";
        String plants = "VCRRGVRG\nRVGCCGCV";
        String[] expected = {"radishes", "grass", "clover", "violets"};

        assertEquals(expected, new KindergartenGarden(plants, studentArray)
        						.getPlantsOfStudent(student));
	}
}
