import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class SalaryCalculatorTest {
    
    public SalaryCalculator calculator;

 
    @Before
    public void setUp() {
        calculator = new SalaryCalculator();
    }

    @Test
    public void regularSalary() {
        assertThat(calculator.finalSalary(0, 0)).isEqualTo(1000.0);
    }
    
    @Test
    public void skippedBelowThreshold () {
        assertThat(calculator.finalSalary(3, 0)).isEqualTo(1000.0);
    }

    @Test
    public void skippedAboveThreshold() {
        assertThat(calculator.finalSalary(7, 0)).isEqualTo(850.0);
    }
    
    @Test
    public void soldBelowThreshold() {
        assertThat(calculator.finalSalary(0, 10)).isEqualTo(1100.0);
    }

    @Test
    public void soldAboveThreshold() {
        assertThat(calculator.finalSalary(0, 25)).isEqualTo(1325.0);
    }
    
    @Test
    public void skippedBelowThresholdAndSoldBelowThreshold() {
        assertThat(calculator.finalSalary(2, 5)).isEqualTo(1050.0);
    }

    @Test
    public void skippedBelowThresholdAndSoldAboveThreshold() {
        assertThat(calculator.finalSalary(4, 40)).isEqualTo(1520.0);
    }   
     
    @Test
    public void skippedAboveThresholdAndSoldBelowThreshold() {
        assertThat(calculator.finalSalary(10, 2)).isEqualTo(870.0);
    }

    @Test
    public void skippedAboveThresholdAndSoldAboveThreshold() {
        assertThat(calculator.finalSalary(7, 50)).isEqualTo(1500.0);
    }

    @Test
    public void salaryCanReachCloseToMaximum() {
        assertThat(calculator.finalSalary(0, 76)).isEqualTo(1988.0);
    }
    
    @Test
    public void salaryRespectMaximum() {
        assertThat(calculator.finalSalary(0, 77)).isEqualTo(2000.0);
    }
    
}
