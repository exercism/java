import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class KindergartenGardenTest {

    @Test
    public void singleStudent() {
        String student = "Alice";
        String plants = "RC\nGG";
        Plant[] expected = {Plant.RADISHES, Plant.CLOVER, Plant.GRASS, Plant.GRASS};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void singleStudent2() {
        String student = "Alice";
        String plants = "VC\nRC";
        Plant[] expected = {Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.CLOVER};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void twoStudents() {
        String student = "Bob";
        String plants = "VVCG\nVVRC";
        Plant[] expected = {Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.CLOVER};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenSecondStudent() {
        String student = "Bob";
        String plants = "VVCCGG\nVVCCGG";
        Plant[] expected = {Plant.CLOVER, Plant.CLOVER, Plant.CLOVER, Plant.CLOVER};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenThirdStudent() {
        String student = "Charlie";
        String plants = "VVCCGG\nVVCCGG";
        Plant[] expected = {Plant.GRASS, Plant.GRASS, Plant.GRASS, Plant.GRASS};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenFirstStudent() {
        String student = "Alice";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        Plant[] expected = {Plant.VIOLETS, Plant.RADISHES, Plant.VIOLETS, Plant.RADISHES};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondStudent() {
        String student = "Bob";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        Plant[] expected = {Plant.CLOVER, Plant.GRASS, Plant.CLOVER, Plant.CLOVER};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondToLastStudent() {
        String student = "Kincaid";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        Plant[] expected = {Plant.GRASS, Plant.CLOVER, Plant.CLOVER, Plant.GRASS};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenLastStudent() {
        String student = "Larry";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        Plant[] expected = {Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS};

        assertEquals(expected,
                new KindergartenGarden(plants).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void customStudentGardenFirstStudent() {
        String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
        String student = "Patricia";
        String plants = "VCRRGVRG\nRVGCCGCV";
        Plant[] expected = {Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.VIOLETS};

        assertEquals(expected,
                new KindergartenGarden(plants, studentArray).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void customStudentGardenSecondStudent() {
        String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
        String student = "Roger";
        String plants = "VCRRGVRG\nRVGCCGCV";
        Plant[] expected = {Plant.RADISHES, Plant.RADISHES, Plant.GRASS, Plant.CLOVER};

        assertEquals(expected,
                new KindergartenGarden(plants, studentArray).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void customStudentGardenThirdStudent() {
        String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
        String student = "Samantha";
        String plants = "VCRRGVRG\nRVGCCGCV";
        Plant[] expected = {Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.GRASS};

        assertEquals(expected,
                new KindergartenGarden(plants, studentArray).getPlantsOfStudent(student));
    }

    @Ignore("Remove to run test")
    @Test
    public void customStudentGardenFourthStudent() {
        String[] studentArray = {"Samantha", "Patricia", "Xander", "Roger"};
        String student = "Xander";
        String plants = "VCRRGVRG\nRVGCCGCV";
        Plant[] expected = {Plant.RADISHES, Plant.GRASS, Plant.CLOVER, Plant.VIOLETS};

        assertEquals(expected,
                new KindergartenGarden(plants, studentArray).getPlantsOfStudent(student));
    }
}
