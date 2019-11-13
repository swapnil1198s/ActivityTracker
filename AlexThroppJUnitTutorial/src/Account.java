public class Account {

    private double currentBal;

    public Account(double amount){
        currentBal = amount;
    }
    public void deposit(double amount){
        currentBal += amount;
    }
    public double withdraw(double amount){
        if(currentBal >= amount){
            currentBal -= amount;
            return amount;
        }
        else if(currentBal < amount){
            return 0.0;
        }
        return amount;
    }
    public double getBalance(){
        return currentBal;
    }
}
