import java.util.Scanner;
class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        balance = initialBalance;
    }
    public double checkBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposit successfully. New balance:$"+balance);
    }
    public boolean withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            System.out.println("withdrawl successfully.New balance:$"+balance);
            return true;
        }
        else{
            System.out.println("insufficient funds.withdrawal failed.");
            return false;
        }
    }
}
class atm{
    private BankAccount userAccount;
    public atm(BankAccount account){
        userAccount = account;
    }
    public void displaymenu(){
        System.out.println("ATM menu:");
        System.out.println("1.check balance");
        System.out.println("2.deposit");
        System.out.println("3.withdraw");
        System.out.println("4.exit");
    }
        public void UserChoice(int choice,Scanner scanner){
            switch(choice){
                case 1:
                checkBalance();
                break;
                case 2:
                System.out.println("enter deposit amount:$");
                double depositAmount=validateAmountInput(scanner);
                deposit(depositAmount);
                break;
                case 3:
                System.out.println("enter withdraw amount:$");
                double withdrawalAmount=validateAmountInput(scanner);
                withdraw(withdrawalAmount);
                break;
                case 4:
                System.out.println("Exiting.Thankyou!");
                break;
                default :
                System.out.println("invalid choice. please try again");
            }
        }
        private void checkBalance(){
            System.out.println("your balance is:$"+userAccount.checkBalance());
        }
        private void deposit(double amount){
            userAccount.deposit(amount);
        }
        private void withdraw(double amount){
            if(userAccount.withdraw(amount)){
                System.out.println("withdrawal successfully.New balance:$"+userAccount.checkBalance());
            }
        }
        private double validateAmountInput(Scanner scanner){
            while(!scanner.hasNextDouble()){
                System.out.println("Invalid input.please enter a valid amount:");
                scanner.next();
            }
            return scanner.nextDouble();
        }
    }    
    public class atmMachine{
        public static void main(String[] args){
            BankAccount userAccount=new BankAccount(1000);
            atm atmmachine=new atm(userAccount);
            Scanner scanner = new Scanner(System.in);
            int choice;
            do{
                atmmachine.displaymenu();
                System.out.println("enter your choice:");
                while(!scanner.hasNextInt()){
                    System.out.println("Inavlid input.please enter a number.");
                    scanner.next();
                }
                choice = scanner.nextInt();
                atmmachine.UserChoice(choice,scanner);
            }
            while(choice!=4);
            scanner.close();
        }
    }        
        














        


    

