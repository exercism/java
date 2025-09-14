import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class KindergartenGardenTest {

    @Test
    @DisplayName("garden with single student")
    public void singleStudent() {
        String garden = "RC\nGG";
        String student = "Alice";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.RADISHES, Plant.CLOVER, Plant.GRASS, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("different garden with single student")
    public void singleStudent2() {
        String garden = "VC\nRC";
        String student = "Alice";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("garden with two students")
    public void twoStudents() {
        String garden = "VVCG\nVVRC";
        String student = "Bob";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second student's garden")
    public void oneGardenSecondStudent() {
        String garden = "VVCCGG\nVVCCGG";
        String student = "Bob";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.CLOVER, Plant.CLOVER, Plant.CLOVER, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("third student's garden")
    public void oneGardenThirdStudent() {
        String garden = "VVCCGG\nVVCCGG";
        String student = "Charlie";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.GRASS, Plant.GRASS, Plant.GRASS, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Alice, first student's garden")
    public void fullGardenForAlice() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Alice";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.VIOLETS, Plant.RADISHES, Plant.VIOLETS, Plant.RADISHES);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Bob, second student's garden")
    public void fullGardenForBob() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Bob";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.CLOVER, Plant.GRASS, Plant.CLOVER, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Charlie")
    public void fullGardenForCharlie() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Charlie";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.VIOLETS, Plant.VIOLETS, Plant.CLOVER, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for David")
    public void fullGardenForDavid() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "David";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.RADISHES, Plant.VIOLETS, Plant.CLOVER, Plant.RADISHES);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Eve")
    public void fullGardenForEve() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Eve";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.CLOVER, Plant.GRASS, Plant.RADISHES, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Fred")
    public void fullGardenForFred() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Fred";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.GRASS, Plant.CLOVER, Plant.VIOLETS, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Ginny")
    public void fullGardenForGinny() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Ginny";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.CLOVER, Plant.GRASS, Plant.GRASS, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Harriet")
    public void fullGardenForHarriet() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Harriet";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.VIOLETS, Plant.RADISHES, Plant.RADISHES, Plant.VIOLETS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Ileana")
    public void fullGardenForIleana() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Ileana";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.GRASS, Plant.CLOVER, Plant.VIOLETS, Plant.CLOVER);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Joseph")
    public void fullGardenForJoseph() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Joseph";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Kincaid, second to last student's garden")
    public void fullGardenForKincaid() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Kincaid";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.GRASS, Plant.CLOVER, Plant.CLOVER, Plant.GRASS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("for Larry, last student's garden")
    public void fullGardenForLarry() {
        String garden = "VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV";
        String student = "Larry";

        assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student))
                .containsExactly(Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS);
    }

}
