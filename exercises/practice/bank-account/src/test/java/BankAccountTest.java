import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @DisplayName("Newly opened account has empty balance")
    @Test
    public void newlyOpenedAccountHasEmptyBalance() throws BankAccountActionInvalidException {
        bankAccount.open();
        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @DisplayName("Deposit into account")
    @Test
    public void singleDeposit() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        assertThat(bankAccount.getBalance()).isEqualTo(100);
    }

    @Disabled("Remove to run test")
    @DisplayName("Deposit into account several times")
    @Test
    public void multipleDeposits() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        bankAccount.deposit(50);
        assertThat(bankAccount.getBalance()).isEqualTo(150);
    }

    @Disabled("Remove to run test")
    @DisplayName("Withdraw some money")
    @Test
    public void withdrawOnce() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        bankAccount.withdraw(75);
        assertThat(bankAccount.getBalance()).isEqualTo(25);
    }

    @Disabled("Remove to run test")
    @DisplayName("Withdraw entire balance")
    @Test
    public void withdrawTwice() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        bankAccount.withdraw(80);
        bankAccount.withdraw(20);
        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @DisplayName("Can do multiple operations sequentially")
    @Test
    public void canDoMultipleOperationsSequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        bankAccount.deposit(110);
        bankAccount.withdraw(200);
        bankAccount.deposit(60);
        bankAccount.withdraw(50);
        assertThat(bankAccount.getBalance()).isEqualTo(20);
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot get balance of closed account")
    @Test
    public void cannotCheckBalanceOfClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.close();
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(bankAccount::getBalance)
                .withMessage("Account closed");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot deposit money into closed account")
    @Test
    public void cannotDepositIntoClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.close();
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.deposit(50))
                .withMessage("Account closed");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot deposit money into unopened account")
    @Test
    public void cannotDepositIntoUnopenedAccount() {
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.deposit(50))
                .withMessage("Account closed");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot withdraw money from closed account")
    @Test
    public void cannotWithdrawFromClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.close();
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(50))
                .withMessage("Account closed");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot close unopened account")
    @Test
    public void cannotCloseAnAccountThatWasNotOpened() {
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(bankAccount::close)
                .withMessage("Account not open");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot open already opened account")
    @Test
    public void cannotOpenAnAlreadyOpenedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(bankAccount::open)
                .withMessage("Account already open");
    }

    @Disabled("Remove to run test")
    @DisplayName("Reopened account does not retain balance")
    @Test
    public void reopenedAccountDoesNotRetainBalance() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(50);
        bankAccount.close();
        bankAccount.open();
        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot withdraw more than was deposited")
    @Test
    public void cannotWithdrawMoreThanWasDeposited() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(25);
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(50))
                .withMessage("Cannot withdraw more money than is currently in the account");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot withdraw negative amount")
    @Test
    public void cannotWithdrawNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(100);
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.withdraw(-50))
                .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Disabled("Remove to run test")
    @DisplayName("Cannot deposit negative amount")
    @Test
    public void cannotDepositNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
                .isThrownBy(() -> bankAccount.deposit(-50))
                .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Disabled("Remove to run test")
    @DisplayName("Can handle concurrent transactions")
    @Test
    public void canHandleConcurrentTransactions() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);

        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
            assertThat(bankAccount.getBalance()).isEqualTo(1000);
        }
    }

    private void adjustBalanceConcurrently() throws InterruptedException {
        Random random = new Random();

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                try {
                    bankAccount.deposit(5);
                    Thread.sleep(random.nextInt(10));
                    bankAccount.withdraw(5);
                } catch (BankAccountActionInvalidException e) {
                    fail("Exception should not be thrown: " + e.getMessage());
                } catch (InterruptedException ignored) {
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
