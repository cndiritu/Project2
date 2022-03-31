import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class BankAccountGUI extends CloseableFrame implements ActionListener{

    /** Prompt for entering sides. */
    private JTextField initialbalance;
    /** Prompt for entering sides. */
    private JTextField transamount;
    /** Button to click when balance is  entered. */
    private JButton balancebutton;
    /** Display the balance */
    private JTextArea balancedisplay; //this will show the balance as it changes
    /** Button to click to withdraw. */
    private JButton withdraw;
    /** Button to click to deposit. */
    private JButton deposit;
    /** object for account */
    private SimpleAccount acct;



    public BankAccountGUI(){ //construtor
      this.buildGUI();

      super.setVisible(true);
    }

    private void buildGUI(){ //
      super.setSize(700, 300); //window size
      super.setTitle("Bank Account");

      Container contentPane = super.getContentPane(); //creates the different sections to input panels into
      contentPane.setLayout(new BorderLayout());

      //lines 35-38 use inheritence to make new objects specific for working with the balance
      JLabel Prompt = new JLabel("Enter Initial Balance: "); //a text line
      this.initialbalance = new JTextField(10); //gets user input
      this.balancebutton = new JButton("Click here to initialize balance"); //button
      this.balancebutton.addActionListener(this); //later will be used implement what the button actually does
      //lines 39-44 add the new specific info into the Panel from left to right
      JPanel balPanel = new JPanel();
      balPanel.add(Prompt);
      balPanel.add(this.initialbalance);
      balPanel.add(this.balancebutton);
      contentPane.add("North", balPanel); //'North' is one of the designated words for the contentpane object that will put balPanel on the top of the window
      // Create a text area to display the current balance
      this.balancedisplay = new JTextArea(20, 10);
      contentPane.add("Center", this.balancedisplay);

      JLabel Prompt2 = new JLabel("Enter Transaction Account");
      this.transamount = new JTextField(10);
      this.withdraw = new JButton("Withdraw");
      this.deposit = new JButton("Deposit");
      this.withdraw.addActionListener(this); //later will be used implement what the button actually does
      this.deposit.addActionListener(this); //later will be used implement what the button actually does

      JPanel tranbal = new JPanel();
      tranbal.add(Prompt2);
      tranbal.add(transamount);
      tranbal.add(this.withdraw);
      tranbal.add(this.deposit);
      contentPane.add("South",tranbal);




    }
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.balancebutton){ //this just says" if the "click to initializes" button is pressed"
        // Get the text input for balance
        String balText = this.initialbalance.getText();
        // Convert the String input to an int using the Integer wrapper class
        int numbal = Integer.parseInt(balText);

        this.balancebutton.setEnabled(false); //can no longer press the button

        this.balancedisplay.setText("Current balance: " + numbal);

        acct = new SimpleAccount(numbal);

        this.withdraw.setEnabled(true); //next two lines will turn on the buttons to withdraw and deposit
        this.deposit.setEnabled(true);

      }

      else if(e.getSource() == this.withdraw) {
        String num1 = this.transamount.getText();
        int y = Integer.parseInt(num1);
        acct.withdraw(y);
        double  x = acct.getBalance();
        this.balancedisplay.setText("Current balance: " + x);

      }
      else if(e.getSource() == this.deposit){
        String num2 = this.transamount.getText();
        int f = Integer.parseInt(num2);
        acct.deposit(f);
        double  h = acct.getBalance();
        this.balancedisplay.setText("Current balance: " + h);

      }
    }

    public static void main(String[] args){
      new BankAccountGUI();
    }

}
