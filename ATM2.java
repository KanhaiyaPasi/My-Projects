import java.util.Scanner;
import java.util.*;
class bankaccount {
    private double balanceamt;

    public bankaccount(double currentbalance) {
        this.balanceamt = currentbalance;
    }

    public double getBalanceamt() {
        return balanceamt;
    }

    public void deposit(double amount) {
        balanceamt += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balanceamt) {
            balanceamt -= amount;
            return true;
        }
        return false;
    }
}
class Atm {
    private bankaccount userAcct;

    public Atm(bankaccount account) {
        this.userAcct = account;
    }

    public void displayMenu() {
        System.out.println("WELLCOME TO THIS ATM!!");
        System.out.println("PRESS 1: TO CHECK BALANCE");
        System.out.println("PRESS 2: TO DEPOSIT AMOUNT");
        System.out.println("PRESS 3: TO WITHDRAW AMOUNT");
        System.out.println("PRESS 4: TO EXIT");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("PLEASE SELECT AN OPTION: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("ENTER THE DEPOSIT AMOUNT: Rs.");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("ENTER THE WITHDRAWAL AMOUNT: Rs.");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("THANK YOU FOR USING THIS ATM!!");
                    break;
                default:
                    System.out.println("INVALID OPTION!! \n PLEASE TRY AGAIN");
            }
        }
        sc.close();
    }

    private void checkBalance() {
        double balance = userAcct.getBalanceamt();
        System.out.println("CURRENT BALANCE IN ACCOUNT: Rs." + balance);
    }

    private void deposit(double amt) {
        if (amt > 0) {
            userAcct.deposit(amt);
            System.out.println("AMOUNT DEPOSIT SUCCESSFUL. NEW BALANCE AFTER AMOUNT DEPOSIT : Rs." + userAcct.getBalanceamt());
        }
        else {
            System.out.println("AMOUNT DEPOSIT FAILED. PLEASE ENTER A VALID AMOUNT!");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0) {
            if (userAcct.withdraw(amount)) {
                System.out.println("AMOUNT WITHDRAWAL SUCCESSFUL. NEW BALANCE AFTER AMOUNT WITHDRAWAL: Rs." + userAcct.getBalanceamt());
            }
            else {
                System.out.println("INSUFFICIENT BALANCE. AMOUNT WITHDRAWAL UNSUCCESSFUL.");
            }
        } else {
            System.out.println("INVALID AMOUNT WITHDRAWAL. PLEASE ENTER A VALID AMOUNT!");
        }
    }
}

  public class ATM2 {
    public static void main(String[] args) {
        bankaccount userAcct = new bankaccount(1000.0);
        Atm atm = new Atm(userAcct);
        atm.run();
    }
}
