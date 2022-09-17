import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    /* Validate login crediantals */
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(12345, 2001);
                data.put(67890, 2000);

                // Scanner sc = new Scanner(System.in);
                // System.out.println("Enter any number greater than 0 to start OR ");
                // System.out.println("Enter 0 to cancel the Transaction ");
                // x = sc.nextInt();
                // if(x == 0){
                // System.out.println("Thank you for using this ATM, BYE!");
                // break;
                // }

                System.out.println("Enter your customer ID");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN No :");
                setPinNumber(menuInput.nextInt());
                // sc.close();

            } catch (Exception e) {
                System.out.println("invalid Input Format" + "\n");
                x = 2;
            }
            boolean found = false;
            for (Entry<Integer, Integer> entry : data.entrySet()) {

                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    found = true;
                    getAccountType();
                }
            }
            if (found == false)
                System.out.println("Wrong customer Number or Pin Number" + "\n");
        } while (x == 1);
        // sc.close();
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to Access: ");
        System.out.println("Type 1 - current Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");
        System.out.print("choice : ");

        selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getcurrent();
                break;

            case 2:
                getSavings();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, BYE");
                break;

            default:
                System.out.println("Invalid Choice");
                getAccountType();
        }
    }

    /* display current account Menu */
    public void getcurrent() {
        System.out.println("current Account ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("current Account Balance: " + moneyFormat.format(getcurrentBalance()));
                break;
            case 2:
                getcurrentWithdrawInput();
                getAccountType();
                break;
            case 3:
                getcurrentDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, BYE");
                break;
            default:
                System.out.println("Invalid Choice");
                getcurrent();
        }
    }

    /* Display Saving Account Menu */
    public void getSavings() {
        System.out.println("Savings Account ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingsBalance()));
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, BYE");
                break;
            default:
                System.out.println("Invalid Choice");
                getcurrent();
        }
    }

    int selection;
}
