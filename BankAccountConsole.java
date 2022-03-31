
import java.util.Scanner; //needed to read user input

public class BankAccountConsole{
  /* for getting keyboard input*/
  private Scanner keyboardIn;
  /* New account object with methods*/
  private SimpleAccount account;
  /* New account object with methods*/



  public BankAccountConsole(){ // this constructor
    this.keyboardIn = new Scanner(System.in);
    double balance = balance();
    this.account = new SimpleAccount(balance);
  }
  private double balance(){ //method to get initial balance from user
    System.out.print("Enter Initial Balance: ");
    double balance = keyboardIn.nextDouble();
    return balance;
  }
  public void run(){ //this method controls the bulk of this program
    boolean game = true;
    while (game==true){
      System.out.print("Choices: 1 = Withdraw, 2 = deposit, 3 = quit the application: ");

      int response = keyboardIn.nextInt();

      if (response==1){
        System.out.print("Enter the amount to withdraw: ");
        double with = keyboardIn.nextDouble();
        account.withdraw(with);
        double print=account.getBalance();
        System.out.print("Current balance: " + print+"\n");
      }
      if (response==2){
        System.out.print("Enter the amount to deposit: ");
        double depo = keyboardIn.nextDouble();
        account.deposit(depo);
        double prints=account.getBalance();
        System.out.print("Current balance: " +  prints+"\n");
      }
      if (response==3){
        game=false; //ends while loop, hence ending the program
      }


    }
  }


  public static void main(String[] args) {

    BankAccountConsole woah = new BankAccountConsole();

    woah.run();
  }




  }
