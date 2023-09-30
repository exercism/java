import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteControlCarTest {
    @Test
    @Tag("task:1")
    @DisplayName("The ProductionRemoteControlCar is an instance of the RemoteControlCar interface")
    public void productionRccIsRemoteControlCar() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        assertThat(productionCar instanceof RemoteControlCar).isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The ExperimentalRemoteControlCar is an instance of the RemoteControlCar interface")
    public void experimentalRccIsRemoteControlCar() {
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        assertThat(experimentalCar instanceof RemoteControlCar).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getDistanceTravelled method of the ProductionRemoteControlCar returns 10 after driving once")
    public void productionCarTravels10UnitsPerDrive() {
        ProductionRemoteControlCar car = new ProductionRemoteControlCar();
        assertThat(car.getDistanceTravelled()).isEqualTo(0);
        car.drive();
        assertThat(car.getDistanceTravelled()).isEqualTo(10);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getDistanceTravelled method of the ExperimentalRemoteControlCar returns 20 after driving once")
    public void experimentalCarTravels20UnitsPerDrive() {
        ExperimentalRemoteControlCar car = new ExperimentalRemoteControlCar();
        assertThat(car.getDistanceTravelled()).isEqualTo(0);
        car.drive();
        assertThat(car.getDistanceTravelled()).isEqualTo(20);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The TestTrack.race method uses the drive method on the remote control car")
    public void race() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        assertThat(experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled()).isEqualTo(20);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The ProductionRemoteControlCar implements the Comparable interface")
    public void ensureCarsAreComparable() {
        assertThat(Comparable.class).isAssignableFrom(ProductionRemoteControlCar.class);
    }

    private static ProductionRemoteControlCar getCarWithVictories(int numberOfVictories) {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(numberOfVictories);
        return prc1;
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getRankedCars returns a list of two cars sorted by number of victories")
    public void rankTwoCars() {
        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>() {
            {
                add(getCarWithVictories(2));
                add(getCarWithVictories(3));
            }
        };
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        assertThat(rankings.get(0).getNumberOfVictories()).isEqualTo(3);
        assertThat(rankings.get(1).getNumberOfVictories()).isEqualTo(2);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getRankedCars returns a list of multiple cars sorted by number of victories")
    public void rankManyCars() {
        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>() {
            {
                add(getCarWithVictories(0));
                add(getCarWithVictories(3));
                add(getCarWithVictories(5));
                add(getCarWithVictories(7));
                add(getCarWithVictories(2));
                add(getCarWithVictories(1));
            }
        };
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        assertThat(rankings.get(0).getNumberOfVictories()).isEqualTo(7);
        assertThat(rankings.get(1).getNumberOfVictories()).isEqualTo(5);
        assertThat(rankings.get(2).getNumberOfVictories()).isEqualTo(3);
        assertThat(rankings.get(3).getNumberOfVictories()).isEqualTo(2);
        assertThat(rankings.get(4).getNumberOfVictories()).isEqualTo(1);
        assertThat(rankings.get(5).getNumberOfVictories()).isEqualTo(0);
    }
}
