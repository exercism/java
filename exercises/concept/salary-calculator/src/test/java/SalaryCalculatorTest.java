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
    @DisplayName("The salaryMultiplier method returns 1.0 when daysSkipped is below the threshold")
    public void salaryMultiplierWhenDaysSkippedIs4() {
        assertThat(calculator.salaryMultiplier(4)).isEqualTo(1.0);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The salaryMultiplier method returns 0.85 when daysSkipped is equal to the threshold")
    public void salaryMultiplierWhenDaysSkippedIs5() {
        assertThat(calculator.salaryMultiplier(5)).isEqualTo(0.85);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The bonusMultiplier method returns 0.85 when daysSkipped is above the threshold")
    public void salaryMultiplierWhenDaysSkippedIs6() {
        assertThat(calculator.salaryMultiplier(6)).isEqualTo(0.85);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusMultiplier method returns 10 when productsSold is below the threshold")
    public void bonusMultiplierWhenProductsSoldIs19() {
        assertThat(calculator.bonusMultiplier(19)).isEqualTo(10);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusMultiplier method returns 13 when productsSold is equal to the threshold")
    public void bonusMultiplierWhenProductsSoldIs20() {
        assertThat(calculator.bonusMultiplier(20)).isEqualTo(13);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusMultiplier method returns 13 when productsSold is above the threshold")
    public void bonusMultiplierWhenProductsSoldIs21() {
        assertThat(calculator.bonusMultiplier(21)).isEqualTo(13);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The bonusForProductsSold method returns the right result")
    public void bonusForProductsSoldWhenProductsSoldIs5() {
        assertThat(calculator.bonusForProductsSold(5)).isEqualTo(50);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the regular salary without multiplier and bonus")
    public void regularSalary() {
        assertThat(calculator.finalSalary(0, 0)).isEqualTo(1000.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped above threshold")
    public void skippedAboveThreshold() {
        assertThat(calculator.finalSalary(7, 0)).isEqualTo(850.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result when daysSkipped and productsSold below threshold")
    public void skippedBelowThresholdAndSoldBelowThreshold() {
        assertThat(calculator.finalSalary(2, 5)).isEqualTo(1050.0);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The finalSalary method returns the correct result capped at maximum salary")
    public void salaryRespectMaximum() {
        assertThat(calculator.finalSalary(0, 77)).isEqualTo(2000.0);
    }

}
