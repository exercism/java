import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class KindergartenGardenTest {

    @Test
    public void singleStudent() {
        String student = "Alice";
        String plants = "RC\nGG";
        List<Plant> expected = Arrays.asList(Plant.RADISHES, Plant.CLOVER, Plant.GRASS, Plant.GRASS);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void singleStudent2() {
        String student = "Alice";
        String plants = "VC\nRC";
        List<Plant> expected = Arrays.asList(Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.CLOVER);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void twoStudents() {
        String student = "Bob";
        String plants = "VVCG\nVVRC";
        List<Plant> expected = Arrays.asList(Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.CLOVER);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenSecondStudent() {
        String student = "Bob";
        String plants = "VVCCGG\nVVCCGG";
        List<Plant> expected = Arrays.asList(Plant.CLOVER, Plant.CLOVER, Plant.CLOVER, Plant.CLOVER);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenThirdStudent() {
        String student = "Charlie";
        String plants = "VVCCGG\nVVCCGG";
        List<Plant> expected = Arrays.asList(Plant.GRASS, Plant.GRASS, Plant.GRASS, Plant.GRASS);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenFirstStudent() {
        String student = "Alice";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        List<Plant> expected = Arrays.asList(Plant.VIOLETS, Plant.RADISHES, Plant.VIOLETS, Plant.RADISHES);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondStudent() {
        String student = "Bob";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        List<Plant> expected = Arrays.asList(Plant.CLOVER, Plant.GRASS, Plant.CLOVER, Plant.CLOVER);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondToLastStudent() {
        String student = "Kincaid";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        List<Plant> expected = Arrays.asList(Plant.GRASS, Plant.CLOVER, Plant.CLOVER, Plant.GRASS);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenLastStudent() {
        String student = "Larry";
        String plants = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        List<Plant> expected = Arrays.asList(Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS);

        assertEquals(
            expected,
            new KindergartenGarden(plants).getPlantsOfStudent(student)
        );
    }

}
