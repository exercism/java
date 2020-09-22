import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class RemoteControlCarTest {
    @Test
    public void race() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        assertSame(20, experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled());
    }

    @Ignore("Remove to run test")
    @Test
    public void rankCars() {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(3);
        prc2.setNumberOfVictories(2);
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(prc1, prc2);
        assertSame(prc1, rankings.get(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void ensureCarsAreComparables() {
        assertTrue(RemoteControlCar.class.isAssignableFrom(ProductionRemoteControlCar.class));
    }
}
