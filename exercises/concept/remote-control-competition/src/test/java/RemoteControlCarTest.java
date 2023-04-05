import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteControlCarTest {
    @Test
    public void productionRccIsRemoteControlCar() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        assertThat(productionCar instanceof RemoteControlCar).isTrue();
    }

    @Test
    public void experimentalRccIsRemoteControlCar() {
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        assertThat(experimentalCar instanceof RemoteControlCar).isTrue();
    }

    @Test
    public void productionCarTravels10UnitsPerDrive() {
        ProductionRemoteControlCar car = new ProductionRemoteControlCar();
        assertThat(car.getDistanceTravelled()).isEqualTo(0);
        car.drive();
        assertThat(car.getDistanceTravelled()).isEqualTo(10);
    }

    @Test
    public void experimentalCarTravels20UnitsPerDrive() {
        ExperimentalRemoteControlCar car = new ExperimentalRemoteControlCar();
        assertThat(car.getDistanceTravelled()).isEqualTo(0);
        car.drive();
        assertThat(car.getDistanceTravelled()).isEqualTo(20);
    }

    @Test
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
    public void ensureCarsAreComparable() {
        assertThat(Comparable.class).isAssignableFrom(ProductionRemoteControlCar.class);
    }

    private static ProductionRemoteControlCar getCarWithVictories(int numberOfVictories) {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(numberOfVictories);
        return prc1;
    }

    @Test
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
