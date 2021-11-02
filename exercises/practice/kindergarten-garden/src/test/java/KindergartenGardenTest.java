
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

public class KindergartenGardenTest {

    @Test
    public void singleStudent() {
        assertThat(
            new KindergartenGarden("RC\nGG").getPlantsOfStudent("Alice")
        ).containsExactly(
            Plant.RADISHES, Plant.CLOVER, Plant.GRASS, Plant.GRASS
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void singleStudent2() {
        assertThat(
            new KindergartenGarden("VC\nRC").getPlantsOfStudent("Alice")
        ).containsExactly(
            Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.CLOVER
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void twoStudents() {
        assertThat(
            new KindergartenGarden("VVCG\nVVRC").getPlantsOfStudent("Bob")
        ).containsExactly(
            Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.CLOVER
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenSecondStudent() {
        assertThat(
            new KindergartenGarden("VVCCGG\nVVCCGG").getPlantsOfStudent("Bob")
        ).containsExactly(
            Plant.CLOVER, Plant.CLOVER, Plant.CLOVER, Plant.CLOVER
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void oneGardenThirdStudent() {
        assertThat(
            new KindergartenGarden("VVCCGG\nVVCCGG").getPlantsOfStudent("Charlie")
        ).containsExactly(
            Plant.GRASS, Plant.GRASS, Plant.GRASS, Plant.GRASS
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenFirstStudent() {
        assertThat(
            new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Alice")
        ).containsExactly(
            Plant.VIOLETS, Plant.RADISHES, Plant.VIOLETS, Plant.RADISHES
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondStudent() {
        assertThat(
            new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Bob")
        ).containsExactly(
            Plant.CLOVER, Plant.GRASS, Plant.CLOVER, Plant.CLOVER
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenSecondToLastStudent() {
        assertThat(
            new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Kincaid")
        ).containsExactly(
            Plant.GRASS, Plant.CLOVER, Plant.CLOVER, Plant.GRASS
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void fullGardenLastStudent() {
        assertThat(
            new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Larry")
        ).containsExactly(
            Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS
        );
    }

}
