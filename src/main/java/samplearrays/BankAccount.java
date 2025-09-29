package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    double transactions[]=new double[1000];
    static int numberOfTransaction=0;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions

    public BankAccount(String name, int startingBalance){
        this.name=name;
        this.currentBalance=startingBalance;
    }

    public void deposit(double amount){
        if(amount<0){
            System.out.println("The amount must be positive");
        }
        else{
            transactions[numberOfTransaction]=1;
            numberOfTransaction++;
            currentBalance+=amount;
            System.out.println("[ the depositor's name: "+name+", deposited amount: "+amount+", new balnace: "+currentBalance+" ]");
        }
    }

    public void withdraw(double amount){
        if(amount>currentBalance){
            System.out.println("The amount must be less than your current balance");
        }
        else{
            transactions[numberOfTransaction]=-1;
            numberOfTransaction++;
            currentBalance-=amount;
        }

    }

    public void displayTransactions(){
        System.out.print("[ ");
        for(double i:transactions){
            if(i==0){
                break;
            }
            System.out.print(i+", ");
        }
        System.out.println("]");

    }

    public void displayBalance(){
        System.out.println("The current balance is: "+currentBalance);

    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
