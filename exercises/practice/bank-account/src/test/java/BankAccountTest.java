import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

public class BankAccountTest {
    private BankAccount bankAccount = new BankAccount();

    @Test
    public void newlyOpenedAccountHasEmptyBalance() throws BankAccountActionInvalidException {
        bankAccount.open();

        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void canDepositMoney() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(10);

        assertThat(bankAccount.getBalance()).isEqualTo(10);
    }

    @Ignore("Remove to run test")
    @Test
    public void canDepositMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(5);
        bankAccount.deposit(23);

        assertThat(bankAccount.getBalance()).isEqualTo(28);
    }

    @Ignore("Remove to run test")
    @Test
    public void canWithdrawMoney() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);

        bankAccount.withdraw(5);

        assertThat(bankAccount.getBalance()).isEqualTo(5);
    }

    @Ignore("Remove to run test")
    @Test
    public void canWithdrawMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(23);

        bankAccount.withdraw(10);
        bankAccount.withdraw(13);

        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoneyFromEmptyAccount() {
        bankAccount.open();

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.withdraw(5))
            .withMessage("Cannot withdraw money from an empty account");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoreMoneyThanYouHave() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(6);

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.withdraw(7))
            .withMessage("Cannot withdraw more money than is currently in the account");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotDepositNegativeAmount() {
        bankAccount.open();

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.deposit(-1))
            .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(105);

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.withdraw(-5))
            .withMessage("Cannot deposit or withdraw negative amount");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotGetBalanceOfClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        bankAccount.close();

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(bankAccount::getBalance)
            .withMessage("Account closed");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotDepositMoneyIntoClosedAccount() {
        bankAccount.open();
        bankAccount.close();

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.deposit(5))
            .withMessage("Account closed");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoneyFromClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(20);
        bankAccount.close();

        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(() -> bankAccount.withdraw(5))
            .withMessage("Account closed");
    }

    @Ignore("Remove to run test")
    @Test
    public void bankAccountIsClosedBeforeItIsOpened() {
        assertThatExceptionOfType(BankAccountActionInvalidException.class)
            .isThrownBy(bankAccount::getBalance)
            .withMessage("Account closed");
    }

    @Ignore("Remove to run test")
    @Test
    public void canAdjustBalanceConcurrently() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);

        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
            assertThat(bankAccount.getBalance()).isEqualTo(1000);
        }
    }

    private void adjustBalanceConcurrently() throws BankAccountActionInvalidException, InterruptedException {
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
