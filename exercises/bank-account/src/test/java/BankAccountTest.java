import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BankAccountTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private BankAccount bankAccount;

    @Before
    public void setup() {
        bankAccount = new BankAccount();
    }

    @Test
    public void newlyOpenedAccountHasEmptyBalance() throws BankAccountActionInvalidException {
        bankAccount.open();

        assertEquals(0, bankAccount.getBalance());
    }

    @Ignore("Remove to run test")
    @Test
    public void canDepositMoney() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(10);

        assertEquals(10, bankAccount.getBalance());
    }

    @Ignore("Remove to run test")
    @Test
    public void canDepositMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();

        bankAccount.deposit(5);
        bankAccount.deposit(23);

        assertEquals(28, bankAccount.getBalance());
    }

    @Ignore("Remove to run test")
    @Test
    public void canWithdrawMoney() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);

        bankAccount.withdraw(5);

        assertEquals(5, bankAccount.getBalance());
    }

    @Ignore("Remove to run test")
    @Test
    public void canWithdrawMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(23);

        bankAccount.withdraw(10);
        bankAccount.withdraw(13);

        assertEquals(0, bankAccount.getBalance());
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoneyFromEmptyAccount() throws BankAccountActionInvalidException {
        bankAccount.open();

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Cannot withdraw money from an empty account");

        bankAccount.withdraw(5);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoreMoneyThanYouHave() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(6);

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Cannot withdraw more money than is currently in the account");

        bankAccount.withdraw(7);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotDepositNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Cannot deposit or withdraw negative amount");

        bankAccount.deposit(-1);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(105);

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Cannot deposit or withdraw negative amount");

        bankAccount.withdraw(-5);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotGetBalanceOfClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        bankAccount.close();

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Account closed");

        bankAccount.getBalance();
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotDepositMoneyIntoClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.close();

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Account closed");

        bankAccount.deposit(5);
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotWithdrawMoneyFromClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(20);
        bankAccount.close();

        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Account closed");

        bankAccount.withdraw(5);
    }

    @Ignore("Remove to run test")
    @Test
    public void bankAccountIsClosedBeforeItIsOpened() throws BankAccountActionInvalidException {
        expectedException.expect(BankAccountActionInvalidException.class);
        expectedException.expectMessage("Account closed");

        bankAccount.getBalance();
    }

    @Ignore("Remove to run test")
    @Test
    public void canAdjustBalanceConcurrently() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);

        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
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

        assertEquals(1000, bankAccount.getBalance());
    }
}
