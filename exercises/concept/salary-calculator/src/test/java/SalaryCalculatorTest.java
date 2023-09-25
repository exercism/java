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
