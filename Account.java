import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set customer Number */
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* Get customer number */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /* Set Pin Number */
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* get PinNumber */
    public int getPinNumber() {
        return pinNumber;
    }

    /* get current Account Balance */
    public double getcurrentBalance() {
        return currentBalance;
    }

    /* get Saving Account Balance */
    public double getSavingsBalance() {
        return savingBalance;
    }

    /* Calculate current Account Withdrawal */
    public double calcurrentWithdraw(double amount) {
        currentBalance = currentBalance - amount;
        return currentBalance;
    }

    /* Calculate Savings Account Withdrawal */
    public double calSavingWithdraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    /* Calculate current Account deposit */
    public double calcurrentDeposit(double amount) {
        currentBalance = currentBalance + amount;
        return currentBalance;
    }

    /* Calculate Savings Account deposit */
    public double calSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    /* Customer current Account Withdraw imnput */
    public void getcurrentWithdrawInput() {
        System.out.println("current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Amount you want to withdraw from current account: ");
        double amount = input.nextDouble();

        if (currentBalance - amount >= 0) {
            calcurrentWithdraw(amount);
            System.out.println("New current Account balance:" + moneyFormat.format(currentBalance));
        } else {
            System.out.println("Balance cannot be negative ");
        }
    }

    /* Customer Saving Account Withdraw imnput */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving account: ");
        double amount = input.nextDouble();

        if (savingBalance - amount >= 0) {
            calSavingWithdraw(amount);
            System.out.println("New saving Account balance:" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative ");
        }
    }

    /* Customer current Account Withdraw imnput */
    public void getcurrentDepositInput() {
        System.out.println("current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Amount you want to deposit from current account: ");
        double amount = input.nextDouble();

        if (currentBalance + amount >= 0) {
            calcurrentDeposit(amount);
            System.out.println("New current Account balance:" + moneyFormat.format(currentBalance));
        } else {
            System.out.println("Balance cannot be negative ");
        }
    }

    /* Customer Saving Account Withdraw input */
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from saving account: ");
        double amount = input.nextDouble();

        if (savingBalance + amount >= 0) {
            calSavingDeposit(amount);
            System.out.println("New saving Account balance:" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative ");
        }
    }
}