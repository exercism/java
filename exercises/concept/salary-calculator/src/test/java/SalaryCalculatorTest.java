import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class SalaryCalculatorTest {
    
    public SalaryCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new SalaryCalculator();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The multiplierPerDaysSkipped method returns 1.0 when daysSkipped is below the threshold")
    public void multiplierPerDaysSkippedWhenDaysSkippedIs4() {
        int daysSkipped = 4;
        assertThat(calculator.multiplierPerDaysSkipped(daysSkipped)).isEqualTo(1.0);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The multiplierPerDaysSkipped method returns 1.0 when daysSkipped is equal to the threshold")
    public void multiplierPerDaysSkippedWhenDaysSkippedIs5() {
        int daysSkipped = 5;
        assertThat(calculator.multiplierPerDaysSkipped(daysSkipped)).isEqualTo(0.85);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The multiplierPerDaysSkipped method returns 0.85 when daysSkipped is above the threshold")
    public void multiplierPerDaysSkippedWhenDaysSkippedIs6() {
        int daysSkipped = 6;
        assertThat(calculator.multiplierPerDaysSkipped(daysSkipped)).isEqualTo(0.85);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The multiplierPerProductsSold method returns 10 when productsSold is below the threshold")
    public void multiplierPerProductsSoldWhenProductsSoldIs19() {
        int productsSold = 19;
        assertThat(calculator.multiplierPerProductsSold(productsSold)).isEqualTo(10);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The multiplierPerProductsSold method returns 13 when productsSold is equal to the threshold")
    public void multiplierPerProductsSoldWhenProductsSoldIs20() {
        int productsSold = 20;
        assertThat(calculator.multiplierPerProductsSold(productsSold)).isEqualTo(13);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The multiplierPerProductsSold method returns 13 when productsSold is above the threshold")
    public void multiplierPerProductsSoldWhenProductsSoldIs21() {
        int productsSold = 21;
        assertThat(calculator.multiplierPerProductsSold(productsSold)).isEqualTo(13);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusForProductsSold method returns 5 when productsSold is below the threshold")
    public void bonusForProductsSoldWhenProductsSoldIs5() {
        int productsSold = 5;
        assertThat(calculator.bonusForProductsSold(productsSold)).isEqualTo(50);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusForProductsSold method returns 273 when productsSold is above the threshold")
    public void bonusForProductsSoldWhenProductsSoldIs21() {
        int productsSold = 21;
        assertThat(calculator.bonusForProductsSold(productsSold)).isEqualTo(273);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the regular salary without multiplier and bonus")
    public void regularSalary() {
        assertThat(calculator.finalSalary(0, 0)).isEqualTo(1000.0);
    }
    
    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped below threshold")
    public void skippedBelowThreshold () {
        assertThat(calculator.finalSalary(3, 0)).isEqualTo(1000.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped above threshold")
    public void skippedAboveThreshold() {
        assertThat(calculator.finalSalary(7, 0)).isEqualTo(850.0);
    }
    
    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when productsSold below threshold")
    public void soldBelowThreshold() {
        assertThat(calculator.finalSalary(0, 10)).isEqualTo(1100.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when productsSold above threshold")
    public void soldAboveThreshold() {
        assertThat(calculator.finalSalary(0, 25)).isEqualTo(1325.0);
    }
    
    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped and productsSold below threshold")
    public void skippedBelowThresholdAndSoldBelowThreshold() {
        assertThat(calculator.finalSalary(2, 5)).isEqualTo(1050.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("finalSalary method returns correct result when daysSkipped below and productsSold above threshold")
    public void skippedBelowThresholdAndSoldAboveThreshold() {
        assertThat(calculator.finalSalary(4, 40)).isEqualTo(1520.0);
    }   
     
    @Test
    @Tag("task:3")
    @DisplayName("finalSalary method returns correct result when daysSkipped above and productsSold below threshold")
    public void skippedAboveThresholdAndSoldBelowThreshold() {
        assertThat(calculator.finalSalary(10, 2)).isEqualTo(870.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped and productsSold above threshold")
    public void skippedAboveThresholdAndSoldAboveThreshold() {
        assertThat(calculator.finalSalary(7, 50)).isEqualTo(1500.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result getting closer to the maximum")
    public void salaryCanReachCloseToMaximum() {
        assertThat(calculator.finalSalary(0, 76)).isEqualTo(1988.0);
    }
    
    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result capped at maximum salary")
    public void salaryRespectMaximum() {
        assertThat(calculator.finalSalary(0, 77)).isEqualTo(2000.0);
    }
    
}
